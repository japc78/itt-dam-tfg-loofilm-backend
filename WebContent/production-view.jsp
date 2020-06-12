<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1><span class="badge badge-success">Ver</span> <span class="badge badge-primary">${production.id}</span> <span class="badge badge-info">${production.type eq 0 ? 'serie':'film'}</span> ${production.name} </h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Inicio</a></li>
						<li class="breadcrumb-item active">
							Ver Producción (Film o Serie)
						</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<form action="production-create" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-4">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Informacion general</h3>
						</div>
						<div class="card-body box-profile">
							<div class="row">
								<div class="col-md-12"><a data-fancybox="gallery" href="${path}${production.filename}"><img class="img-fluid" src="${path}${production.filename}"></a></div>
							</div>
							<hr>
							<strong><i class="fas fa-align-left mr-1"></i> Descripcion</strong>
							<p class="text-muted">${production.description}</p>
							<hr>
							<strong><i class="fas fa-users mr-1"></i> Casting</strong>
							<p class="text-muted">${production.cast}</p>
							<hr>
							<strong><i class="fas fa-info-circle"></i> Información</strong>
							<c:if test="${not empty production.web}">
							<p><a class="link" href="${production.web}">${production.web}</a></p>
							</c:if>
						</div>
						<!-- /.card-body -->
					</div>
				</div>

				<div class="col-md-8">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Escenas rodadas</h3>
						</div>
						<div class="card-body">
							<table id="list_object" data-type="scene" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th style="width: 1%;">id</th>
									<th style="width: 5%;" class="no-sort">Imagen</th>
									<th>Escena</th>
									<th style="width: 5%;">Localizacion</th>
									<th style="width: 5%;">Ciudad</th>
									<th style="width: 2%;" class="text-center">Estado</th>
									<th style="max-width: 130px;" class="no-sort"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${production.scenes}" var="s">
								<tr id="production-${p[0]}">
								<td>${s.id}</td>
								<td><img src="images/scenes/${s.scenesMedias[0].filename != null ? s.scenesMedias[0].filename : 'default.png'}" height="50px"></td>
								<td>${s.name}</td>
								<td>${s.location.name}</td>
								<td>${s.location.city.city}</td>
								<td class="text-center">
									<div class="custom-control custom-switch custom-switch-off-danger custom-switch-on-success">
										<input type="checkbox" class="custom-control-input check" id="check-${s.id}" ${s.active eq 'false' ? '': 'checked'}>
										<label class="custom-control-label" for="check-${s.id}"><span class="hidden">${s.active}</span></label>
									</div>
								</td>
								<td class="project-actions text-right">
									<a class="btn btn-primary btn-xs" href="#">Ver</a>
									<a class="btn btn-info btn-xs" href="#">Editar</a>
									<a id="del-${s.id}" class="btn btn-danger btn-xs btnDel" href="#">Borrar</a>
								</td>
								</tr>
								</c:forEach>
							</tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>
				</div>
			</div>

			<div class="row pb-3">
				<div class="col-12 text-right">
					<a href="production?id=${production.id}&page=edit" class="btn btn-info mr-2">Editar</a>
					<a href="production-list" class="btn btn-primary mr-2">Ir al listado</a>
				</div>
			</div>
		</form>
	</section>
	<!-- /.content -->
<%@include file="../WEB-INF/template/bottom.jsp" %>