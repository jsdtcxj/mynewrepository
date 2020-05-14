<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta charset="ISO-8859-1">
<title>Spring 5 MVC - Hello World Example | javaguides.net</title>
</head>
   <body>
      <h2>${helloWorld.message}</h2>
      <h4>Server date time is : ${helloWorld.dateTime}</h4>
   </body>
</html>