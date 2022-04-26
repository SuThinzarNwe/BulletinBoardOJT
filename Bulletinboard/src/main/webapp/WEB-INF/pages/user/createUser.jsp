<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="<c:url value="/resources/js/showImage.js"/>"></script>
<div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="forms-mr">
          <div class="col-sm-6 col-md-6 form-detail">
            <c:url var="addAction" value="/createUserConfirm"></c:url>
            <form:form action="${addAction}" modelAttribute="createUser"
              method="POST" id="form" role="form"
              enctype="multipart/form-data">
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                  <h4 class="text-center forms-header">
                    <b>User Creation</b>
                  </h4>
                  <c:if test="${errorMsg != null }">
                    <div class="alert alert-danger">
                      <strong>${errorMsg }</strong>
                    </div>
                  </c:if>
                  <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="name" class="form-control"
                      placeholder="Enter Name" />
                    <form:errors path="name" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <form:input path="email" class="form-control"
                      placeholder="Enter Email" autocomplete="false" />
                    <form:errors path="email" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <form:password path="password"
                      value="${rollBackUserForm.password }"
                      class="form-control" placeholder="Enter Password" />
                    <form:errors path="password" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label>Confirm Password</label> <input
                      type="password" name="confirmPassword"
                      value="${rollBackUserForm.password }"
                      class="form-control"
                      placeholder="Enter Confirm Password" />
                  </div>

                  <div class="form-group">
                    <label for="type">Type</label>
                    <form:select path="type" id="type"
                      class="form-control">
                      <option value="0">Admin</option>
                      <option value="1">User</option>
                    </form:select>
                    <form:errors path="type" cssClass="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="phone">Phone</label>
                    <form:input type="text" path="phone"
                      pattern="[0]{1}[9]{1}[0-9]{9}"
                      class="form-control" placeholder="Enter Phone" />
                    <form:errors path="phone" cssClass="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="dob">Date Of Birth</label>
                    <div class="date datepicker">
                      <form:input path="dob" type="date"
                        class="form-control"
                        placeholder="Enter Date Of Birth" />
                      <div class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                      </div>
                    </div>
                    <form:errors path="dob" cssClass="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="address">Address</label>
                    <form:textarea path="address" class="form-control"
                      placeholder="Enter Address"></form:textarea>
                  </div>
                  <div class="form-group">
                    <label for="profile">Profile</label>
                    <div class="input-group">
                      <input type="file" name="fileUpload"
                        id="fileUpload" accept="image/*"
                        value="${imageData }"
                        onchange="showImage.call(this)" /> <input
                        name="imageData" type="hidden" id="imageData"
                        value="" />
                      <c:if test="${rollBackUserForm.profile != null }">
                        <a class="float-right"
                          style="margin-left: 130px"> <img
                          src="${rollBackUserForm.profile }" id="image"
                          class="profile-user-img img-fluid img-circle" />
                          <form:input path="profile" type="hidden"
                            value="${imageData}" class="form-control" />
                        </a>
                      </c:if>
                    </div>
                  </div>
                  <button type="submit" class="btn btn-info"
                    name="confirmUser">Confirm</button>
                  <button type="submit" class="btn btn-secondary"
                    name="clearUserData">Back</button>
                  <button type="reset" class="btn btn-danger"
                    name="clearUser">Reset</button>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
<script>
	$('.datepicker').datepicker({
		format : 'yyyy-mm-dd',
	});
</script>