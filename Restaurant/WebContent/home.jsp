<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant</title>
<jsp:include page="/jsp/common/head_imports.jsp" />

</head>
<body class="hold-transition sidebar-mini dark-mode">
	<div class="wrapper">

		<jsp:include page="/jsp/common/sidebar.jsp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<br />
			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="row">
								<div class="col-12 col-sm-6 col-md-4">
									<div class="info-box  mb-4">
										<span class="info-box-icon bg-info elevation-1"> <i
											class="fas fa-thin fa-utensils"></i></span>

										<div class="info-box-content">
											<a href="<c:url value="/listRestaurante.htm"/>"
												style="color: white"><span class="info-box-text">Restaurante</span>
												<span class="info-box-number"> <c:out
														value="${ restaurante }" />
											</span></a>

										</div>
										<!-- /.info-box-content -->
									</div>
									<!-- /.info-box -->
								</div>
								<!-- /.col -->
								<div class="col-12 col-sm-6 col-md-4">
									<div class="info-box mb-4">
										<span class="info-box-icon bg-danger elevation-1"><i
											class="fas fa-solid fa-users"></i></span>

										<div class="info-box-content">
											<a href="<c:url value="/listClienti.htm"/>"
												style="color: white"><span class="info-box-text">Clienti</span>
												<span class="info-box-number"><c:out
														value="${ clienti }" /></span></a>

										</div>
										<!-- /.info-box-content -->
									</div>
									<!-- /.info-box -->
								</div>
								<!-- /.col -->

								<!-- fix for small devices only -->
								<div class="clearfix hidden-md-up"></div>

								<div class="col-12 col-sm-6 col-md-4">
									<div class="info-box mb-4">
										<span class="info-box-icon bg-success elevation-1"><i
											class="fas fa-shopping-cart"></i></span>

										<div class="info-box-content"><a href="<c:url value="/listComenzi.htm"/>"
												style="color: white">
											<span class="info-box-text">Comenzi</span> <span
												class="info-box-number"><c:out value="${ comenzi }" /></span></a>
										</div>
										<!-- /.info-box-content -->
									</div>
									<!-- /.info-box -->
								</div>
								<!-- /.col -->
							</div>
							<h1>Proiect Restaurant</h1>
							<p>Scopul acestui mic proiect este de a gestiona
								restaurantele online (restaurante, clienti, comenzi). Am
								incercat sa creez o interfata usor de utilizat cu care se pot
								efectua operatii CRUD pe cele 3 tabele din baza de date. Am
								folosit Java + Spring MVC pentru a crea acest proiect si xampp
								pentru baza de date.</p>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>