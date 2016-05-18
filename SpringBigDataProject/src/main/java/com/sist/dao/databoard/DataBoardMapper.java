package com.sist.dao.databoard;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface DataBoardMapper {
   @Select("SELECT no,subject,name,regdate,hit,num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT no,subject,name,regdate,hit "
		  +"FROM multiDataBoard ORDER BY no DESC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   
   public List<DataBoardVO> databoardAllData(Map map);
}
