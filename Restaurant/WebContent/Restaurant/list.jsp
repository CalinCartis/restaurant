<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Restaurante</title>

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
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Lista Restaurante</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body table-responsive p-0">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<td>ID</td>
												<td>Nume</td>
												<td>Telefon</td>
												<td>Adresa</td>
												<td></td>
												<td></td>
												<td></td>

											</tr>
										</thead>
										<c:forEach var="r" items="${ restaurante }">
											<tr>
												<td><c:out value="${ r.id }" /></td>
												<td><c:out value="${ r.nume }" /></td>
												<td><c:out value="${ r.telefon }" /></td>
												<td><c:out value="${ r.adresa }" /></td>

												<td><a class="btn btn-primary"
													href="<c:url value = '/detaliiRestaurant.htm?id=${ r.id }'/>">Detalii</a></td>
												<td><a class="btn btn-primary"
													href="<c:url value = '/editare-restaurant.htm?id=${ r.id }'/>">Edit</a></td>
												<td><a class="btn btn-primary"
													href="<c:url value = '/deleteRestaurant.htm?id=${ r.id }'/>">Sterge</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<a class="btn btn-primary"
								href="<c:url value='/adaugare-restaurant.htm'/>">Adauga
								restaurant</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>