<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="<c:url value="/resources/js/showImage.js"/>"></script>
<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-12">
				<div class="forms-mr">
					<div class="col-sm-6 col-md-6 form-detail">
						<c:url var="addAction" value="/updateUserConfirm"></c:url>
						<form:form action="${addAction}" modelAttribute="editedUserForm"
							method="POST" id="form" enctype="multipart/form-data">
							<input type="hidden" name="id" value="${oldUserForm.id }" />
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<h4 class="text-center forms-header">
										<b>User Edition</b>
									</h4>
									<c:if test="${errorMsg != null }">
										<div class="alert alert-danger">
											<strong>${errorMsg }</strong>
										</div>
									</c:if>
									<div class="form-group">
										<label for="name">Name</label> <input class="form-control"
											type="text" name="name" value="${oldUserForm.name }"
											placeholder="Enter Name" />
										<form:errors path="name" class="text-danger" />
									</div>
									<div class="form-group">
										<label for="email">Email</label> <input class="form-control"
											name="email" value="${oldUserForm.email }"
											placeholder="Enter Email">
										<form:errors path="email" class="text-danger" />
									</div>
									<div class="form-group">
										<input type="hidden" name="password"
											value="${oldUserForm.password }" />
									</div>
									<div class="form-group">
										<c:if test="${LOGIN_USER.type == 0 }">
											<label for="type">Type</label>
											<select id="type" name="type" class="form-control">
												<c:if test="${oldUserForm.type == 1 }">
													<option value="1">User</option>
													<option value="0">Admin</option>
												</c:if>
												<option value="0">Admin</option>
												<option value="1">User</option>
											</select>
											<form:errors path="type" class="text-danger" />
										</c:if>
										<c:if test="${LOGIN_USER.type == 1 }">
											<input type="hidden" name="type" value="${oldUserForm.type }">
										</c:if>
										<form:errors path="type" class="text-danger" />
									</div>
									<div class="form-group">
										<label for="phone">Phone</label> <input class="form-control"
											type="text" name="phone" value="${oldUserForm.phone }"
											placeholder="Enter Phone" />
										<form:errors path="phone" class="text-danger" />
									</div>
									<div class="form-group">
										<label for="dob">Date Of Birth</label>
										<div class="input-group date datepicker"
											data-provide="datepicker">
											<input class="form-control" name="dob"
												value="${oldUserForm.dob }"
												placeholder="Enter Date Of Birth">
											<div class="input-group-addon">
												<span class="glyphicon glyphicon-th"></span>
											</div>
										</div>
										<form:errors path="dob" class="text-danger" />
									</div>
									<div class="form-group">
										<label for="address">Address</label> <input
											class="form-control" name="address"
											value="${oldUserForm.address }" placeholder="Enter Address">
									</div>
									<div class="form-group">
										<label for="profile">Profile</label>
										<div class="input-group">
											<input type="file" name="fileUpload" id="fileUpload"
												accept="image/*" value="${imageData }"
												onchange="showImage.call(this)" /> <input name="imageData"
												type="hidden" id="imageData" value="${oldUserForm.profile }" />
											<c:if test="${oldUserForm.profile!= null }">
												<a class="float-right" style="margin-left: 130px"> <img
													src="${oldUserForm.profile }" id="image"
													class="profile-user-img img-fluid img-circle" />
												</a>
											</c:if>
										</div>
									</div>
									<button type="submit" class="btn btn-info"
										name="updateUserConfirm">Update</button>
									<button type="submit" class="btn btn-secondary"
										name="cancelUser">Cancel</button>
									<button type="reset" class="btn btn-danger">Reset</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>