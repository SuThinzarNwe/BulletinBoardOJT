<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="login-box" style="text-align: center">
	<div class="card">
		<div class="card-body login-card-body">
			<div class="login-logo">
				<a href="#" class="text-info">Bulletinboard</a>
			</div>
			<form:form class="form-signin" action="${addAction}"
				modelAttribute="loginForm" method="post">
				<c:if test="${errorMsg != null }">
					<div class="alert alert-danger">
						<i class="far fa-times-circle"></i> <strong>${errorMsg }</strong>
					</div>
				</c:if>
				<div class="input-group mb-3">
					<form:input class="form-control" placeholder="Email" type="text"
						path="email" autofocus="autofocus" id="loginEmail" />
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
					<div class="input-group">
						<form:errors path="email" class="has-error text-danger" />
					</div>
				</div>
				<div class="input-group mb-3">
					<form:input class="form-control" placeholder="Password"
						type="password" path="password" id="loginPassword" />
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
					<div class="input-group">
						<form:errors path="password" class="has-error text-danger" />
					</div>
				</div>
				<div class="input-group mb-3">
					<div class="icheck-primary">
						<input type="checkbox" id="remember"> <label
							for="remember"> Remember Me </label>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<button type="submit" class="btn btn-info btn-block" id="LoginID"
							name="login">Sign In</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
