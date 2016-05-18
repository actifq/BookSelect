package com.sist.dao.book;
import java.net.*;
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
@Component
public class BookManager {
   public List<BookVO> bookAllData()
   {
	   List<BookVO> list=new ArrayList<BookVO>();
	   try
	   {
		   Document doc=Jsoup.connect("http://www.bandinlunis.com/front/display/listBest.do").get();
		   Elements posterElem=doc.select("div.prod_thumb_img img");
		   Elements reviewElem=doc.select("dl.prod_info dd.txt_bex");
		   for(int i=0;i<6;i++)
		   {
			   Element pelem=posterElem.get(i);
			   String poster=pelem.attr("src");
			   Element relem=reviewElem.get(i);
			   BookVO vo=new BookVO();
			   vo.setPoster(poster);
			   vo.setReview(relem.text());
			   list.add(vo);
		   }
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   return list;
   }
}






