<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<nav
	class="main-header navbar navbar-expand navbar-white navbar-light nav-design"
	style="margin-left: 0px;">
	<ul class="nav navbar-nav">
		<li class="nav-item"><a class="btn btn-info btn-block" href="#">Home</a></li>&nbsp;&nbsp;
		<li class="nav-item"><a class="btn btn-info btn-block"
			href="postList">Posts List</a></li>&nbsp;&nbsp;
		<li class="nav-item"><a class="btn btn-info btn-block"
			href="userList">Users List</a></li>
	</ul>

	<ul class="navbar-nav ml-auto">
		<c:if test="${LOGIN_USER!= null }">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="detailUser?id=${LOGIN_USER.id}" class="nav-link">${LOGIN_USER.email}</a></li>
				<li><a href="${pageContext.request.contextPath}/logout"
					class="btn btn-info btn-block">Logout</a></li>
			</ul>
		</c:if>
	</ul>
</nav>
