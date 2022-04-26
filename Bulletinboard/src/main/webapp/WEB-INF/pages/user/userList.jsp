<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="content-wrapper" style="margin-left: 0px;">
	<section class="content">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">User List</h3>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-sm-12 col-md-12">
								<div class="search-sec">
									<c:url var="addAction" value="/searchUser"></c:url>
									<form:form action="${addAction}"
										modelAttribute="searchForm" method="POST" id="form"
										class="searchForm-mr">
										<label> <form:input path="name" type="text"
												placeholder="name" />
										</label>
										<label> <form:input path="email" type="text"
												placeholder="email" />
										</label>

										<label>
											<div class="date datepicker">
												<form:input path="createdFrom" type="date"
													class="form-control form-control-sm search-text-pd"
													placeholder="Create From" />
												<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
												</div>
											</div>
										</label>

										<label>
											<div class="date datepicker">
												<form:input path="createdTo" type="date"
													class="form-control form-control-sm search-text-pd"
													placeholder="Create To" />
												<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
												</div>
											</div>
										</label>

										<input type="submit" class="btn btn-secondary" value="Search" />
										<c:if test="${LOGIN_USER.type == 0 }">
											<a href="${pageContext.request.contextPath}/createUser"
												class="btn btn-info">Add</a>
										</c:if>
									</form:form>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Name</th>
											<th>Email</th>
											<th>Created User</th>
											<th>Phone</th>
											<th>Birth Date</th>
											<th>Address</th>
											<th>Created At</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${userList}" var="user" varStatus="loop">
											<tr>
												<c:if test="${LOGIN_USER.email != user.email}">
													<td>${user.name }</td>
													<td>${user.email }</td>
													<td>${user.createdUserName }</td>
													<td>${user.phone }</td>
													<td>${user.dob }</td>
													<td>${user.address }</td>
													<td><fmt:formatDate pattern="yyyy-MM-dd"
															value="${user.createdAt }" /></td>
													<c:if test="${LOGIN_USER.type == 0 }">
														<td class="text-right py-0 align-middle">
															<div class="btn-group btn-group-sm">
																<a href="<c:url value='detailUser?id=${user.id}'/>"
																	class="btn btn-info"><i class="fas fa-eye"></i></a> <a
																	href="#" data-toggle="modal"
																	data-href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
																	data-target="#myModal" class="btn btn-danger"><i
																	class="fas fa-trash"></i></a>
															</div>
														</td>
													</c:if>
												</c:if>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${noOfPages > 0}">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<div class="dataTables_paginate paging_simple_numbers"
						id="example1_paginate">
						<ul class="pagination">
							<c:if test="${currentPage != 1}">
								<li class="page-item"><a class="page-link"
									href="userList?recordsPerPage=${recordsPerPage}&currentPage=${currentPage - 1}">Previous</a>
								</li>
							</c:if>
							<c:forEach begin="1" end="${noOfPages }" var="i">
								<c:choose>
									<c:when test="${currentPage eq i}">
										<li class="page-item active"><a class="page-link">
												${i} <span class="sr-only">(current)</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="userList?recordsPerPage=${recordsPerPage}&currentPage=${i}">
												${i} </a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${currentPage lt noOfPages}">
								<li class="page-item"><a class="page-link"
									href="userList?recordsPerPage=${recordsPerPage}&currentPage=${currentPage + 1}">Next</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
	</section>
</div>
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Delete User Confirmation!</h4>
			</div>
			<div class="modal-body">
				<p>Are You Sure Want to Delete!</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<a class="btn btn-danger btn-ok">OK</a>
			</div>
		</div>
	</div>
</div>
<script src="<c:url value="/resources/js/delete.js"/>"></script>

