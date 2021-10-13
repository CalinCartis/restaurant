<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii restaurant</title>
<jsp:include page="/jsp/common/head_imports.jsp" />

</head>
<body class="hold-transition sidebar-mini dark-mode">
	<div class="wrapper">
		<jsp:include page="/jsp/common/sidebar.jsp" />
		<div class="content-wrapper">
			<br />
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Detalii Restaurant</h3>
								</div>
								<div class="card-body">
									<img src="<c:out value = "${ restaurant.imagine }"/>"
										style="width: 400px;"> <br /> ID:
									<c:out value="${ restaurant.id }" />
									<br /> Nume:
									<c:out value="${ restaurant.nume }" />
									<br /> Telefon:
									<c:out value="${ restaurant.telefon }" />
									<br /> Adresa:
									<c:out value="${ restaurant.adresa }" />
									<br /> Rating:
									<c:out value="${ restaurant.rating }" />
									<br />
								</div>
							</div>
							<a class="btn btn-primary"
								href="<c:url value='/listRestaurante.htm'/>">Inapoi la lista</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>