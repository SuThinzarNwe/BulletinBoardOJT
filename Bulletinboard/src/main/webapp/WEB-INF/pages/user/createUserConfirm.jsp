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
						<c:url var="addAction" value="/insertUser"></c:url>
						<form:form action="${addAction}" modelAttribute="createUser"
							method="POST" id="form">
							<input type="hidden" name="id" value="${userForm.id }">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<h4 class="text-center forms-header">
										<b>Created User Confirm</b>
									</h4>
									<c:if test="${errorMsg != null }">
										<div class="alert alert-danger">
											<strong>${errorMsg }</strong>
										</div>
									</c:if>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item"><b>Name</b> <a
											class="float-right">${userForm.name } <form:input
													path="name" type="hidden" name="name"
													value="${userForm.name }" class="form-control" /></a></li>
										<li class="list-group-item"><b>Email</b> <a
											class="float-right">${userForm.email } <form:input
													path="email" type="hidden" name="email"
													value="${userForm.email }" class="form-control" /></a></li>
										<li class="list-group-item"><b>Password</b> <a
											class="float-right"> <form:input path="password"
													type="password" name="password"
													value="${userForm.password }" class="form-control" /></a></li>
										<li class="list-group-item"><b>Type</b> <a
											class="float-right"> <c:if test="${userForm.type ==0 } ">
													<p>Admin</p>
												</c:if> User <%--  ${userForm.type }  --%> <form:input path="type"
													type="hidden" name="type" value="${userForm.type }"
													class="form-control" /></a></li>
										<li class="list-group-item"><b>Phone</b> <a
											class="float-right">${userForm.phone } <form:input
													path="phone" type="hidden" name="phone"
													value="${userForm.phone }" class="form-control" /></a></li>
										<li class="list-group-item"><b>Date Of Birth</b> <a
											class="float-right">${userForm.dob } <form:input
													path="dob" type="hidden" name="dob"
													value="${userForm.dob }" class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Address</b> <a
											class="float-right">${userForm.address } <form:input
													path="address" type="hidden" name="address"
													value="${userForm.address }" class="form-control" /></a></li>
										<li class="list-group-item"><b>Profile</b> <c:if
												test="${userForm.profile != null }">
												<a class="float-right"> <img src="${userForm.profile }"
													id="image" class="profile-user-img img-fluid img-circle" />
													<form:input path="profile" type="hidden" name="profile"
														value="${userForm.profile }" class="form-control" /></a>
											</c:if></li>
									</ul>
									<button type="submit" class="btn btn-info" name="addUser">Add</button>
									<button type="submit" class="btn btn-secondary" name="cancel">Cancel</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>