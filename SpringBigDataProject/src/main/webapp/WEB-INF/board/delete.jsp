<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/*
 *   selector : ���尴ü , �±׸�( $('�±׸�')=>$('tr')) , 
                ID�� ($('#ID��')) ,
                Class�� ($('.class��'))
             $(document)
 */
$(function(){
	$('#sendBtn').click(function(){
		
		var pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			$('#pwd').val("");
			return;
		}
		
		$('#frm').submit();
	});
});
</script>
</head>
<body>
  <center>
    <h3>�����ϱ�</h3>
    <br/><br/><br/><br/>
    <form method=post action="board_delete_ok.do" id="frm">
    
          <table id="table_content">
        
           <tr>
            <td width=15% align="right">��й�ȣ</td>
            <td width=85% align="left">
             <input type="password" size=10 name=pwd id="pwd">
             <input type="hidden" name="no" value="${no }">
             <input type="hidden" name="page" value="${page }">
             
            </td>
           </tr>
           <tr>
            <td colspan="2" align="center">
             <input type="button" value="����" id="sendBtn">
             <input type="button" value="���"
              onclick="javascript:history.back()">
            </td>
           </tr>
          </table>
        
    </form>
   </center>
</body>
</html>







