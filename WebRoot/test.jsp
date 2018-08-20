<%@page import="com.news.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.news.util.NewsPage"%>
<%@page import="com.news.service.NewsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<News> list = new ArrayList();
		list = (List<News>) request.getAttribute("currNewsList");
		NewsPage newsPage = (NewsPage)request.getAttribute("newsPage");
		System.out.println("test.jsp打印----"+newsPage.getCurrPageNo());
		int nextPage = newsPage.getCurrPageNo()+1;
		int backPage = newsPage.getCurrPageNo()-1;
		
	%>
	<h2>aaaaaa</h2>

	<ul>
		<%
			if (list != null) {
				for (News news : list) {
		%>
		<li><%=news.getTitle()%></li>
		<%
			}
			}
		%>

		<p align="center">
			当前页数： <a href="NewsServlet?currPage=1">首页</a> 
			<a href="NewsServlet?currPage=<%=backPage %>">上一页</a> 
			<a href="NewsServlet?currPage=<%=newsPage.getNextPageNo() %>">下一页</a> 
			<a href="">末页</a> <a href="NewsServlet">显示所有新闻</a>
		</p>
	</ul>

</body>
</html>