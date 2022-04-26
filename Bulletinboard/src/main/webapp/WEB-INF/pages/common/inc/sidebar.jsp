<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<aside
	class="main-sidebar sidebar-dark-primary elevation-4 sidebar-design">

	<div class="sidebar">
		<nav class="mt-2 ">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<li class="nav-item has-treeview"><a href="#" class="nav-link">
						<i class="nav-icon fas fa-clipboard"></i>
						<p class="sidebar-text">
							Post <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a
							href="${pageContext.request.contextPath}/postList"
							class="nav-link sidebar-text"> <i
								class="far fa-list-alt nav-icon"></i>
								<p>List</p>
						</a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath}/createPost"
							class="nav-link sidebar-text"> <i
								class="far fa-plus-square nav-icon"></i>
								<p>New</p>
						</a></li>
					</ul></li>
				<li class="nav-item has-treeview"><a href="#" class="nav-link">
						<i class="nav-icon fas fa-user"></i>
						<p class="sidebar-text">
							User <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a
							href="${pageContext.request.contextPath}/userList"
							class="nav-link sidebar-text"> <i
								class="far fa-list-alt nav-icon"></i>
								<p>List</p>
						</a></li>
						<li class="nav-item"><a
							href="${pageContext.request.contextPath}/createUser"
							class="nav-link sidebar-text"> <i
								class="far fa-plus-square nav-icon"></i>
								<p>New</p>
						</a></li>
					</ul></li>
				<li class="nav-item has-treeview"><a
					href="${pageContext.request.contextPath}/detailUser?id=${loginUserId}"
					class="nav-link"> <i class="nav-icon fas fa-address-card"></i>
						<p class="sidebar-text">Profile</p>
				</a></li>
			</ul>
		</nav>
	</div>
</aside> --%>