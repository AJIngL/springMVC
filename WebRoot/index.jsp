<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.news.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function check() {
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if (login_username.value == "") {
			alert("用户名不能为空！请重新填入！");
			login_username.focus();
			return false;
		} else if (login_password.value == "") {
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}

	function focusOnLogin() {
		var login_username = document.getElementById("uname");
		login_username.focus();
	}
</script>
</head>
<body onload="focusOnLogin()">

	<div id="header">
		<div id="top_login">
			<form action="login" method="post" onsubmit="return check()">

				<label> 登录名 </label> <input type="text" name="username" value=""
					class="login_input" /> <label> 密&#160;&#160;码 </label> <input
					type="password" name="userpwd" value="" class="login_input" /> <input
					type="submit" class="login_sub" value="登录" /> <label id="error">
				</label> <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
			</form>
		</div>
		<div id="nav">
			<div id="logo">
				<img src="images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">
		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="d" items="${DomesticList }" begin="0" end="5">
						<li><a href='readnews?nid=${d.nid }'>${d.title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="f" items="${ForeignList }" begin="0" end="5">
						<li><a href='readnews?nid=${d.nid }'>${f.title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="e" items="${EntertainmentList }" begin="0" end="5">
						<li><a href='readnews?nid=${d.nid }'>${e.title}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="class_type">
				<img src="images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content" style="position:relative;">
				<ul class="class_date">
					<li id='class_month'><c:forEach var="tl" items="${topicList }"
							begin="0" end="9">
							<a href='readnews?nid=${d.nid }'><b>${tl.topicName }</b></a>
						</c:forEach></li>
					<li id='class_month'><c:forEach var="tl" items="${topicList }"
							begin="10">
							<a href='#'><b>${tl.topicName }</b></a>
						</c:forEach></li>
				</ul>
				<ul>
					<c:forEach var="all" items="${allNews }">
						<li><a href='#'><b>${all.title}&#160;&#160; </b></a></li>
						<li style="text-align: right;">${all.aurthor }&#160;&#160;${all.createdate }</li>

						<li>${all.content }&#160;&#160;</li>
						<br />

					</c:forEach>
				</ul>
				<div class="page" style="position:absolute;bottom:0;">
					<%
				Page p = new Page();
				//获取当前页
				/* String currentPage = request.getParameter("pageIndex");
				if(currentPage == null){
				     currentPage = "1";
				} */
				
				int pageIndex=p.getCurrPageNo();
				%>
					当前页数：[${currPage }/<%=p.getTotalPageCount()%>]
					<%-- <%
				if(pageIndex > 1){//控制页面显示风格
				%>  --%>
					<a href="index.jsp?currPage=1">首页</a>&nbsp; <a
						href="index.jsp?currPage=${currPage-1 }">上一页</a>
					<%-- <%
				} if(request.getAttribute("currPage") < p.getTotalPageCount()){//控制页面显示风格
				%> --%>
					<a href="index.jsp?currPage=${currPage+1 }">下一页</a> <a
						href="index.jsp?currPage=<%=p.getTotalPageCount()%>">末页</a>
					<%-- <%   
				} %>   --%>

				</div>
			</div>
			<%@include file="index-elements/index_rightbar.html"%>
		</div>
	</div>
	<%@include file="index-elements/index_bottom.html"%>
</body>
</html>
