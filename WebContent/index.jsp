<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Loofilm Admin</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="assets/css/styles.css">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<img src="assets/img/loofilm-logo.svg" alt="Logo Loofilm">
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Inicie la sesión</p>
				<div class="text-danger msg ${msgType}">
					<span>${msg}</span>
				</div>
				<form action="login" method="post">
					<div class="input-group mb-3">
						<input type="email" class="form-control" placeholder="Email" required name="email" value="${email}">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="Password" required name="pass" value="${pass}">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12 text-right">
							<button type="submit" class="btn btn-primary">Entrar</button>
						</div>
						<!-- /.col -->
					</div>
				</form>
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="assets/js/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="assets/js/adminlte.min.js"></script>

</body>

</html>