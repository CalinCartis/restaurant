<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Navbar -->
<nav class="main-header navbar navbar-expand  navbar-dark">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#" role="button"><i class="fas fa-bars"></i></a></li>
	</ul>
</nav>
<!-- /.navbar -->

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="<c:url value="http://localhost:8080/Restaurant/"/>"
		class="brand-link"> <i class="fas fa-hamburger fa-2x"></i> <span
		class="brand-text font-weight-light">Restaurant</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">

				<li class="nav-item"><a
					href="<c:url value="/listRestaurante.htm"/>" class="nav-link">
						<i class="nav-icon fas fa-thin fa-utensils"></i>
						<p>Lista Restaurante</p>
				</a></li>
				<li class="nav-item"><a
					href="<c:url value="/listClienti.htm"/>" class="nav-link"> <i
											class="nav-icon fas fa-solid fa-users"></i>
						<p>Lista Clienti</p>
				</a></li>
				<li class="nav-item"><a
					href="<c:url value="/listComenzi.htm"/>" class="nav-link"> <i
											class="nav-icon fas fa-shopping-cart"></i>
						<p>Lista Comenzi</p>
				</a></li>
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
