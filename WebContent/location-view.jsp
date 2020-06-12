<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Content Header (Page header) -->
<section class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1><span class="badge badge-success">Ver</span> <span class="badge badge-primary">${location.id}</span> ${location.name} </h1>
			</div>
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="#">Inicio</a></li>
					<li class="breadcrumb-item active">Ver Localización</li>
				</ol>
			</div>
		</div>
	</div><!-- /.container-fluid -->
</section>

<!-- Main content -->
<section class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">Informacion general</h3>
					</div>
					<div class="card-body box-profile">
						<div id="map" class="map rounded mb-3"></div>
						<p class="text-muted">${location.description}</p>
						<div class="row">
							<c:forEach items="${location.locationsMedias}" var="img">
								<div class="col-md-4"><a data-fancybox="gallery" href="${path}${location.locationsMedias[0].filename}"><img class="img-fluid" src="${path}${location.locationsMedias[0].filename}"></a></div>
							</c:forEach>
						</div>
						<hr>

						<strong><i class="fas fa-map-marker-alt mr-1"></i> Ubicación</strong>
						<p class="text-muted">
							${location.street}, ${location.city.city} ${location.postalcode} <br>
							${location.city.county.county}, ${location.city.county.country.country}

						
						<p><a class="btn btn-primary btn-sm" href="https://www.google.es/maps/dir//${location.gps}/@${location.gps},12z" target="_blank">¿Cómo llegar?</a>
						</p>

						<c:if test="${not empty location.web or not empty location.email or not empty location.phone }">
						<hr>
						<strong><i class="fas fa-info-circle"></i> Información de contacto</strong>
						<p>
							<c:if test="${not empty location.web}"><span class="d-block"><b>Web: </b><a class="link" href="${location.web}">${location.web}</a></span></c:if>
							<c:if test="${not empty location.email}"><span class="d-block"><b>Email: </b><a class="link" href="mailto:${location.email}">${location.email}</a></span></c:if>
							<c:if test="${not empty location.phone}"><span class="d-block"><b>Teléfono: </b><a class="link" href="tel:${location.phone}">${location.phone}</a></span></c:if>
						</p>
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
							<th>Nombre</th>
							<th style="width: 5%;">Produccion</th>
							<th style="width: 5%;">Tipo</th>
							<th style="width: 2%;" class="text-center">Estado</th>
							<th style="max-width: 120px;" class="no-sort"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${location.scenes}" var="s">
							<tr id="production-${p[0]}">
							<td>${s.id}</td>
							<td><img src="images/scenes/${s.scenesMedias[0].filename != null ? s.scenesMedias[0].filename : 'default.png'}" height="50px"></td>
							<td>${s.name}</td>
							<td>${s.production.name}</td>
							<td>${s.production.type eq 0 ? 'serie':'film'}</td>
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
	</div>

	<div class="row pb-3">
		<div class="col-12 text-right">
			<input type="hidden" id="inputGps" name="gps" value="${location.gps}">
			<a href="location?id=${location.id}&page=edit" class="btn btn-info mr-2">Editar</a>
			<a href="location-list" class="btn btn-primary mr-2">Ir al listado</a>
		</div>
	</div>
</section>
<!-- /.content -->

<%-- Mensajes --%>
<div class="msg ${msgType}">
	<span>${msg}</span>
</div>
<%@include file="../WEB-INF/template/bottom.jsp" %>