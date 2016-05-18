package com.sist.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.dao.book.*;
@Controller
public class MainController {
  @Autowired
  private BookManager bm;
  @RequestMapping("main.do")
  public String main_page(Model model)
  {
	  List<BookVO> list=bm.bookAllData();
	  model.addAttribute("list", list);
	  return "main";
  }
}



