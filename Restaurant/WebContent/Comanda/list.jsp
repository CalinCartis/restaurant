<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Comenzi</title>
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
									<h3 class="card-title">Lista Comenzi</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body table-responsive p-0">
									<table class="table table-hover text-nowrap">
										<thead>
											<tr>
												<td>ID</td>
												<td>ID Client</td>
												<td>ID Restaurant</td>
												<td></td>
												<td></td>
												<td></td>

											</tr>
										</thead>
										<c:forEach var="c" items="${ comenzi }">
											<tr>
												<td><c:out value="${ c.id }" /></td>
												<td><c:out value="${ c.idClient }" /></td>
												<td><c:out value="${ c.idRestaurant }" /></td>

												<td><a class="btn btn-primary"
													href="<c:url value = '/detaliiComanda.htm?id=${ c.id }'/>">Detalii</a></td>
												<td><a class="btn btn-primary"
													href="<c:url value = '/editare-comanda.htm?id=${ c.id }'/>">Edit</a></td>
												<td><a class="btn btn-primary"
													href="<c:url value = '/deleteComanda.htm?id=${ c.id }'/>">Sterge</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
							<a class="btn btn-primary"
								href="<c:url value='/adaugare-comanda.htm'/>">Adaugare
								comanda</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>