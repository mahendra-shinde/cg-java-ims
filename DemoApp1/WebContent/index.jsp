<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
  String type=request.getParameter("type");
	if(type==null || type.trim().equals("")){
		type="plain";
	}
   String color = request.getParameter("color");
   if(color == null || color.trim().equals("") ){
	   color="white";
   }
  response.setContentType("text/"+type);	
%>
<html>
<head>
<meta charset="ISO-8859-1"/>
<title>Hello World</title>
</head>
<body bgcolor="<%= color %>">
<p>I know who you are, you are <%= request.getRemoteHost() %>!</p>
<h2>Hello World!</h2>
</body>
</html>