<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Header (Page header) -->
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
		          <h1><span class="badge badge-success">Listado</span> <span class="badge badge-primary">Escenas</span></h1>
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
					<table id="list_object" data-type="scene" class="table table-bordered table-striped">
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
								<th style="max-width: 120px;"></th>
							</tr>
						</thead>
						<tbody>
						 	<c:forEach items="${scenes}" var="s">
							<tr id="scene-${s.id}">
								<td>${s.id}</td>
								<td><img src="images/scenes/${s.scenesMedias[0].filename != null ? s.scenesMedias[0].filename : 'default.png'}" width="50px"></td>
								<td>${s.name}</td>
								<td>${s.production.name}</td>
								<td>${s.production.type eq 0 ? 'serie':'film'}</td>
								<td>${s.location.name}</td>
								<td>${s.location.city.city}</td>
								<td class="text-center">
									<div class="custom-control custom-switch custom-switch-off-danger custom-switch-on-success">
										<input type="checkbox" class="custom-control-input check" id="check-${s.id}" ${s.active eq 'false' ? '': 'checked'}>
										<label class="custom-control-label" for="check-${s.id}"><span class="hidden">${s.active}</span></label>
									</div>
								</td>
								<td class="project-actions text-right">
									<a class="btn btn-primary btn-xs" href="scene?id=${s.id}&page=view">Ver</a>
									<a class="btn btn-info btn-xs btnEdit" href="scene?id=${s.id}&page=edit">Editar</a>
				                    <a id="del-${s.id}" class="btn btn-danger btn-xs btnDel" href="#">Borrar</a>
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