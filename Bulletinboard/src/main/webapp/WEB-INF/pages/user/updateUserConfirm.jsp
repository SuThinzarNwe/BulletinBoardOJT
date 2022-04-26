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
						<c:url var="addAction" value="/editUser"></c:url>
						<form:form action="${addAction}"
							modelAttribute="finalConfirmUserForm" method="POST" id="form">
							<input type="hidden" name="id" value="${updateConfirmForm.id }">
							<div class="card card-primary card-outline">
								<div class="card-body box-profile">
									<h4 class="text-center forms-header">
										<b>Edited User Confirm</b>
									</h4>
									<c:if test="${errorMsg != null }">
										<div class="alert alert-danger">
											<strong>${errorMsg }</strong>
										</div>
									</c:if>
									<ul class="list-group list-group-unbordered mb-3">
										<li class="list-group-item"><b>Name</b> <a
											class="float-right">${updateConfirmForm.name } <input
												type="hidden" name="name" value="${updateConfirmForm.name }"
												class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Email</b> <a
											class="float-right">${updateConfirmForm.email } <input
												type="hidden" name="email"
												value="${updateConfirmForm.email }" class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Password</b> <a
											class="float-right"> <input type="password"
												name="password" value="${updateConfirmForm.password }"
												class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Type</b> <c:if
												test="${updateConfirmForm.type == 0 }">
												<a class="float-right">Admin <input type="hidden"
													name="type" value="${updateConfirmForm.type }"
													class="form-control" />
												</a>
											</c:if> <c:if test="${updateConfirmForm.type != 0 }">
												<a class="float-right">User <input type="hidden"
													name="type" value="${updateConfirmForm.type }"
													class="form-control" />
												</a>
											</c:if></li>
										<li class="list-group-item"><b>Phone</b> <a
											class="float-right">${updateConfirmForm.phone } <input
												type="hidden" name="phone"
												value="${updateConfirmForm.phone }" class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Date Of Birth</b> <a
											class="float-right">${updateConfirmForm.dob } <input
												type="hidden" name="dob" value="${updateConfirmForm.dob }"
												class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Address</b> <a
											class="float-right">${updateConfirmForm.address } <input
												type="hidden" name="address"
												value="${updateConfirmForm.address }" class="form-control" />
										</a></li>
										<li class="list-group-item"><b>Profile</b> <c:if
												test="${updateConfirmForm.profile != null }">
												<a class="float-right"><img
													src="${updateConfirmForm.profile }" id="image"
													class="profile-user-img img-fluid img-circle" /><input
													type="hidden" name="profile"
													value="${updateConfirmForm.profile }" class="form-control" /></a>
											</c:if></li>
									</ul>
									<button type="submit" class="btn btn-info" name="update">Update</button>
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