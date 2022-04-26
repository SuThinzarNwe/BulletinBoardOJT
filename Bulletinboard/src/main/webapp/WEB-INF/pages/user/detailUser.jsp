<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-12">
				<div class="forms-mr">
					<div class="col-sm-6 col-md-6 form-detail">
						<c:url var="addAction" value="/detailUser"></c:url>
						<form:form class="form-detail" action="${addAction}"
							modelAttribute="userDetail" method="POST" id="form">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<div class="text-center">
										<c:if test="${empty userDetail.profile }">
											<img class="profile-user-img img-fluid img-circle"
												src="<c:url value='/resources/img/profile.png'/>"
												alt="User profile picture">
										</c:if>
										<c:if test="${not empty userDetail.profile }">
											<img class="profile-user-img img-fluid img-circle"
												src="${userDetail.profile}" />
										</c:if>
									</div>
									<h3 class="profile-username text-center">${userDetail.name }</h3>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item"><b>Email</b> <a
											class="float-right">${userDetail.email }</a></li>
										<li class="list-group-item"><b>Type</b> <c:if
												test="${userDetail.type == 0 }">
												<a class="float-right">ADMIN</a>
											</c:if> <c:if test="${userDetail.type == 1 }">
												<a class="float-right">USER</a>
											</c:if></li>
										<li class="list-group-item"><b>Phone</b> <a
											class="float-right">${userDetail.phone }</a></li>
										<li class="list-group-item"><b>Date Of Birth</b> <a
											class="float-right">${userDetail.dob }</a></li>
										<li class="list-group-item"><b>Address</b> <a
											class="float-right">${userDetail.address }</a></li>
									</ul>
									<a
										href="${pageContext.request.contextPath}/updateUser?id=${userDetail.id }"
										class="btn btn-info btn-block"><b>Edit Profile</b></a>
									<div class="changePwd-txt">
										<a
											href="${pageContext.request.contextPath}/changePassword?id=${userDetail.id }">Change
											Password</a>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>