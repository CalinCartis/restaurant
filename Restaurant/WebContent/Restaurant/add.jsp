<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adaugare restaurant</title>
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
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="box box-primary">
								<div class="box-header with-border">
									<br />
									<h3 class="box-title">Adaugare Restaurant</h3>
								</div>
								<form:form
									action="${pageContext.request.contextPath}/adaugare-restaurant-save.htm"
									method="post" modelAttribute="restaurantForm">

									<div class="form-group">
										<label>Nume</label>
										<form:input class="form-control" path="nume" />
									</div>
									<div class="form-group">
										<label>Telefon</label>
										<form:input class="form-control" path="telefon" />
									</div>
									<div class="form-group">
										<label>Adresa</label>
										<form:input class="form-control" path="adresa" />
									</div>
									<div class="form-group">
										<label>Rating</label>
										<form:input class="form-control" path="rating" />
									</div>
									<div class="form-group">
										<label>Imagine</label>
										<form:input class="form-control" path="imagine" />
									</div>

									<br />

									<button class="btn btn-primary" type="submit">Salveaza</button>
									<br />

								</form:form>
							</div>
							<br /> <a class="btn btn-primary"
								href="<c:url value="/listRestaurante.htm"/>">Inapoi la lista</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>