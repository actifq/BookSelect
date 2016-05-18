package com.sist.dao.board;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;
import com.mongodb.*;
@Repository("dao")
public class BoardDAO {
    private MongoClient mc; // Connection
    private DB db; // ORCL (database)
    private DBCollection dbc;// TABLE
    public BoardDAO()
    {
    	try
    	{
    		mc=new MongoClient("localhost");
    		db=mc.getDB("mydb"); // use mydb
    		dbc=db.getCollection("board");// CREATE OR REPLACE 
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    }
    // 목록 : 페이지별 출력   => 정렬  (sort,skip,limit)
    public List<BoardVO> boardAllData(int page)
    {
    	List<BoardVO> list=new ArrayList<BoardVO>();
    	try
    	{
    		int rowSize=10;
    		int skip=(page*rowSize)-rowSize;
    		DBCursor cursor=dbc.find().
    				sort(new BasicDBObject("group_id",-1).
    						append("group_step", 1)).
    				skip(skip).limit(rowSize);
    		// SELECT * FROM board WHERE rownum BETWEEN skip AND rowSize
    		// ORDER BY group_id DESC,group_step ASC
    	    // ResultSet
    		// [{no:1,name:""},{},{},{},{}]
    		while(cursor.hasNext())
    		{
    			BasicDBObject obj=(BasicDBObject)cursor.next();
    			BoardVO vo=new BoardVO();
    			vo.setNo(obj.getInt("no"));
    			vo.setName(obj.getString("name"));
    			vo.setSubject(obj.getString("subject"));
    			vo.setRegdate(obj.getString("regdate"));
    			vo.setHit(obj.getInt("hit"));
    			vo.setGroup_tab(obj.getInt("group_tab"));
    			list.add(vo);
    		}
    		cursor.close();
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	return list;
    }
    // 추가 : insert
    public void boardInsert(BoardVO vo)
    {
    	try
    	{
    		int no=0;
    		int gi=0;
    		DBCursor cursor=dbc.find();
    		//cursor.max(new BasicDBObject("no", cursor));
    		while(cursor.hasNext())
    		{
    			BasicDBObject obj=(BasicDBObject)cursor.next();
    			int n=obj.getInt("no");
    			if(no<n)
    				no=n;
    			int g=obj.getInt("group_id");
    			if(gi<g)
    				gi=g;
    		}
    		cursor.close();
    		// Sequence 
    		
    		// {no:1,name:"",....}
    		BasicDBObject query=
    				new BasicDBObject();
    		query.put("no", no+1);
    		query.put("name", vo.getName());
    		query.put("subject", vo.getSubject());
    		query.put("content", vo.getContent());
    		query.put("pwd", vo.getPwd());
    		query.put("regdate", new SimpleDateFormat("yyyy-MM-dd").
    				               format(new Date()));
    		query.put("hit", 0);
    		query.put("group_id", gi+1);
    		query.put("group_step", 0);
    		query.put("group_tab", 0);
    		query.put("root", 0);
    		query.put("depth", 0);
    		
    		dbc.insert(query);
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    }
    // 수정 : update
    // 삭제 : delete
    // 찾기 : $regex  find
    // 총페이지 : count
    public int boardTotalPage()
    {
    	int total=0;
    	try
    	{
    		DBCursor cursor=dbc.find();
    		int count=cursor.count();
    		// SELECT COUNT(*) FROM board
    		total=(int)(Math.ceil(count/10.0));
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	return total;
    }
    // 분석 : MapReduce
    // 내용보기 
    public BoardVO boardContent(int no,int type)
    {
    	BoardVO vo=new BoardVO();
    	try
    	{
    		BasicDBObject where=new BasicDBObject();
    		where.put("no", no); // WHERE no=1
    		if(type==1) // content => hit증가 
    		{
    			BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
    			int hit=obj.getInt("hit");
    			BasicDBObject up=new BasicDBObject();
    			up.put("hit", hit+1);
    			dbc.update(where, new BasicDBObject("$set",up));
    		}
    		BasicDBObject data=(BasicDBObject)dbc.findOne(where);
    		vo.setNo(data.getInt("no"));
    		vo.setName(data.getString("name"));
    		vo.setSubject(data.getString("subject"));
    		vo.setContent(data.getString("content"));
    		vo.setRegdate(data.getString("regdate"));
    		vo.setHit(data.getInt("hit"));
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	return vo;
    }
    public boolean boardUpdate(BoardVO vo)
    {
    	boolean bCheck=false;
    	BasicDBObject where=
    			new BasicDBObject();
    	where.put("no", vo.getNo());
    	try
    	{
    		BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
    		String pwd=obj.getString("pwd");
    		if(pwd.equals(vo.getPwd()))
    		{
    			bCheck=true;
    			BasicDBObject up=new BasicDBObject();
    			up.put("name", vo.getName());
    			up.put("subject", vo.getSubject());
    			up.put("content", vo.getContent());
    			dbc.update(where, new BasicDBObject("$set",up));
    		}
    		else
    		{
    			bCheck=false;
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	return bCheck;
    }
    
}




