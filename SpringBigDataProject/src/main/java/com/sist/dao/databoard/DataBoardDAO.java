package com.sist.dao.databoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class DataBoardDAO {
	 @Autowired
     private DataBoardMapper mapper;
	 public List<DataBoardVO> databoardAllData(Map map)
	 {
		 return mapper.databoardAllData(map);
	 }
}
