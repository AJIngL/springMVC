<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="<%=request.getContextPath() %>/css/read.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	  		function check(){
	  			var cauthor = document.getElementById("cauthor");
	  			var content = document.getElementById("ccontent");
	  			if(cauthor.value == ""){
	  				alert("用户名不能为空！！");
	  				return false;
	  			}else if(content.value == ""){
	  				alert("评论内容不能为空！！");
	  				return false;
	  			}
	  			return true;
	  		}
	  	</script>
</head>
<body>
	<div id="header">
		<div id="top_login">
			<label> 登录名 </label> <input type="text" id="uname" value=""
				class="login_input" /> <label> 密&#160;&#160;码 </label> <input
				type="password" id="upwd" value="" class="login_input" /> <input
				type="button" class="login_sub" value="登录" onclick="login()" /> <label
				id="error"> </label> <a href="index.jsp" class="login_link">返回首页</a>
			<img src="../images/friend_logo.gif" alt="Google" id="friend_logo" />
		</div>
		<div id="nav">
			<div id="logo">
				<img src="<%=request.getContextPath() %>/images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="<%=request.getContextPath() %>/images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">
		<div class="sidebar">
			<h1>
				<img src="<%=request.getContextPath() %>/images/title_1.gif"
					alt="国内新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="d" items="${DomesticList }" begin="0" end="5">
						<li><a href='#'>${d.title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="<%=request.getContextPath() %>/images/title_2.gif"
					alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="f" items="${ForeignList }" begin="0" end="5">
						<li><a href='#'>${f.title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="<%=request.getContextPath() %>/images/title_3.gif"
					alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach var="e" items="${EntertainmentList }" begin="0" end="5">
						<li><a href='#'>${e.title}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="class_type">
				<img src="<%=request.getContextPath() %>/images/class_type.gif"
					alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="classlist">
					<table width="80%" align="center">
						<tr width="100%">
							<td colspan="2" align="center">${news.getTitle() }</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td align="center">${news.getCreatedate() }</td>
							<td align="left">${news.getAurthor() }</td>
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2">
								${news.getContent() }</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<table width="80%" align="center">
						<td colspan="6">暂无评论！</td>
						<tr>
							<td colspan="6"><hr /></td>
						</tr>
					</table>
				</ul>
				<ul class="classlist">
					<form action="#" method="post" onsubmit="return check()">
						<table width="80%" align="center">
							<tr>
								<td>评 论</td>
							</tr>
							<tr>
								<td>用户名：</td>
								<td><input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下" />
									IP： <input name="cip" value="127.0.0.1" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="ccontent" cols="70"
										rows="10"></textarea></td>
							</tr>
							<td><input name="submit" value="发  表" type="submit" /></td>
						</table>
					</form>
				</ul>
			</div>
		</div>
	</div>
	<%@include file="/index-elements/index_bottom.html"%>
</body>
</html>
