<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalii</title>
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
									<h3 class="card-title">Detalii Comanda</h3>
								</div>
								<div class="card-body">
									ID:
									<c:out value="${ comanda.id }" />
									<br /> ID Client: <a
										href="detaliiClient.htm?id=<c:url value = "${ comanda.idClient }"/>"><c:out
											value="${ comanda.idClient }" /></a><br /> ID Restaurant: <a
										href="detaliiRestaurant.htm?id=<c:url value = "${ comanda.idRestaurant }"/>"><c:out
											value="${ comanda.idRestaurant }" /></a><br /> Produs Comandat:
									<c:out value="${ comanda.produsComandat }" />
									<br /> Cantitate:
									<c:out value="${ comanda.cantitate }" />
									<br /> Pret:
									<c:out value="${ comanda.pret }" /> RON
									<br />

								</div>
							</div>
							<a class="btn btn-primary" href="<c:url value='/listComenzi.htm'/>">Inapoi
								la lista</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>