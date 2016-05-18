package com.sist.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.dao.databoard.*;

@Controller
public class DataBoardController {
   @Autowired
   private DataBoardDAO dao;
   @RequestMapping("databoard_list.do")
   public String databoard_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=10;
	   int start=(curpage*rowSize)-(rowSize-1);
	   int end=curpage*rowSize;
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end", end);
	   List<DataBoardVO> list=dao.databoardAllData(map);
	   model.addAttribute("list", list);
	   return "databoard/list";
   }
}









