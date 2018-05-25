<%@page import="bitcamp.java106.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String refererUrl = request.getHeader("Referer");
if (refererUrl != null && !refererUrl.endsWith("/auth/login")) { 
    // 다시 로그인 페이지로 안돌아가게 하기 위함
    session.setAttribute("refererUrl", refererUrl);
}
// 웹브라우저가 "id"라는 쿠키를 보냈으면 입력폼을 출력할 때 사용한다.
String id = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("id")) {
            id = cookie.getValue();
            break;
        }
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<form action='login' method='post'>
<table border='1'>
<tr><th>아이디</th>
    <td><input type='text' name='id' value='<%=id%>'></td></tr>
<tr><th>암호</th>
    <td><input type='password' name='password'></td></tr>
</table>
<p><input type='checkbox' name='saveId'> 아이디 저장</p>
<button>로그인</button>
</form>
</body>
</html>
    