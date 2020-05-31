<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Header (Page header) -->
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1>Listado</h1>
			</div>
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item active">
						Listado de Escenas
					</li>
				</ol>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-12">
			<div class="card">
				<div class="card-body">
					<table id="list_object" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="width: 1%;">id</th>
								<th style="width: 5%;">Imagen</th>
								<th>Nombre</th>
								<th>Producción</th>
								<th>Tipo</th>
								<th>Localización</th>
								<th>Ciudad</th>
								<th style="width: 2%;" class="text-center">Estado</th>
								<th style="width: 15%;"></th>
							</tr>
						</thead>
						<tbody>
						 	<c:forEach items="${scenes}" var="s">
							<tr>
								<td>${s[0]}</td>
								<td><img src="images/scenes/isabel-alhambra-01.jpg" width="50px"></td>
								<td>${s[1]}</td>
								<td>${s[2]}</td>
								<td>${s[3] eq 0 ? 'film':'serie'}</td>
								<td>${s[4]}</td>
								<td>${s[5]}</td>
								<td class="text-center">
									<div class="custom-control custom-switch custom-switch-off-danger custom-switch-on-success">
										<input type="checkbox" class="custom-control-input check" id="check-${s[0]}" ${s[6] eq 'false' ? '': 'checked'}>
										<label class="custom-control-label" for="check-${s[0]}"><span class="hidden">${s[6]}</span></label>
									</div>
								</td>
								<td class="project-actions text-right">
									<a class="btn btn-primary btn-xs" href="#">
										<i class="fas fa-folder"> </i>
										Ver
									</a>
									<a class="btn btn-info btn-xs" href="#">
										<i class="fas fa-pencil-alt"> </i>
										Editar
									</a>
									<a class="btn btn-danger btn-xs" href="#">
										<i class="fas fa-trash"> </i>
										Borrar
									</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.card -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
<%@include file="../WEB-INF/template/bottom.jsp" %>