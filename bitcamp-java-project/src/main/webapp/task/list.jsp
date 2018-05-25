<%@page import="bitcamp.java106.pms.domain.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 목록(MVC)</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request, response);%>

<%
List<Task> list = (List<Task>)request.getAttribute("list");
String teamName = (String)request.getAttribute("teamName");
%>
<h1><a href='../team/view?name=<%=teamName%>'><%=teamName%></a>의 작업 목록(MVC)</h1>
<p><a href='add?teamName=<%=teamName%>'>새작업</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>작업명</th><th>기간</th><th>작업자</th>
</tr>
<%
for (Task task : list) {
%>
<tr>
    <td><%=task.getNo()%></td>    
    <td><a href='view?no=<%=task.getNo()%>'><%=task.getTitle()%></a></td>    
    <td><%=task.getStartDate()%> ~ <%=task.getEndDate()%></td>    
    <td><%
    if (task.getWorker() == null) {
        System.out.println("-");
    } else {
        task.getWorker().getId();
    }
    %></td>
</tr>
<%} %>
</table>
</body>
</html>
