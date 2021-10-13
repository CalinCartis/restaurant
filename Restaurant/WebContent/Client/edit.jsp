<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editare Client</title>

<jsp:include page="/jsp/common/head_imports.jsp" />

</head>
<body class="hold-transition sidebar-mini dark-mode">
	<div class="wrapper">

		<jsp:include page="/jsp/common/sidebar.jsp" />
		<div class="content-wrapper">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="box box-primary">
								<div class="box-header with-border">
									<br />
									<h3 class="box-title">Editare Client</h3>
								</div>
								<form:form
									action="${pageContext.request.contextPath}/editare-client-save.htm"
									method="post" modelAttribute="clientForm" role="form">

									<div class="box-body">

										<div class="form-group">
											<label>ID</label>
											<form:input class="form-control" path="id" readonly="true" />
										
										</div>
										<div class="form-group">
											<label>Nume</label>
											<form:input class="form-control" path="nume" />
											
										</div>

										<div class="form-group">
											<label>Prenume</label>
											<form:input class="form-control" path="prenume" />
											
										</div>

										<div class="form-group">
											<label>Adresa</label>
											<form:input class="form-control" path="adresa" />
										
										</div>

										<div class="form-group">
											<label>Telefon</label>
											<form:input class="form-control" path="telefon" />
										
										</div>
									</div>
									<div class="box-footer">
										<button class="btn btn-primary" type="submit">Salveaza</button>
									</div>
								</form:form>
							</div>
							<br />
							<a class="btn btn-primary"
								href="<c:url value="/listClienti.htm"/>">Inapoi la lista</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="/jsp/common/bottom_imports.jsp" />
</body>
</html>