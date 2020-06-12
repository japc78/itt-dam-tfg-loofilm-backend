<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1><span class="badge badge-success">Ver</span> <span class="badge badge-primary">${scene.id}</span> <span class="badge badge-info">${scene.name}</span></h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Inicio</a></li>
						<li class="breadcrumb-item active">
							Ver Escena
						</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Informacion de la escena</h3>
						</div>
						<div class="card-body box-profile">
							<strong><i class="fas fa-align-left mr-1"></i> Descripcion</strong>
							<p class="text-muted">${scene.description}</p>

							<div class="embed-responsive embed-responsive-16by9">
								<iframe class="embed-responsive-item" src="https://www.youtube.com/embed/${video}?rel=0" allowfullscreen></iframe>
							</div>
							<hr>

							<div class="row">
								<c:forEach items="${scene.scenesMedias}" var="img">
									<div class="col-md-4"><a data-fancybox="gallery" href="${path}scenes/${img.filename}"><img class="img-fluid" src="${path}scenes/${img.filename}"></a></div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title"><span class="badge badge-warning mb-0">${scene.production.id}</span> <span class="badge badge-info mb-0">${scene.production.type eq 0 ? 'serie':'film'}</span> ${scene.production.name} </h3>
						</div>
						<div class="card-body box-profile">
							<div class="row">
								<div class="col-md-12"><a data-fancybox="gallery" href="${path}productions/${scene.production.filename}"><img class="img-fluid" src="${path}productions/${scene.production.filename}"></a></div>
							</div>
							<hr>
							<strong><i class="fas fa-align-left mr-1"></i> Descripcion</strong>
							<p class="text-muted">${scene.production.description}</p>
							<hr>
							<strong><i class="fas fa-users mr-1"></i> Casting</strong>
							<p class="text-muted">${scene.production.cast}</p>
							<hr>
							<strong><i class="fas fa-info-circle"></i> Información</strong>
							<c:if test="${not empty scene.production.web}">
							<p><a class="link" href="${scene.production.web}">${scene.production.web}</a></p>
							</c:if>
						</div>
						<!-- /.card-body -->
					</div>
				</div>

				<div class="col-md-4">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title"><span class="badge badge-warning mb-0">${scene.location.id}</span> <span class="badge badge-info mb-0">${scene.location.city.city}</span> ${scene.location.name} </h3>
						</div>
						<div class="card-body box-profile">
							<div id="map" class="map rounded mb-3"></div>
							<input type="hidden" id="inputGps" name="gps" value="${scene.location.gps}">

							<p class="text-muted">${scene.location.description}</p>
							<div class="row">
								<c:forEach items="${scene.location.locationsMedias}" var="imgl">
									<div class="col-md-4"><a data-fancybox="gallery" href="${path}locations/${imgl.filename}"><img class="img-fluid" src="${path}locations/${imgl.filename}"></a></div>
								</c:forEach>
							</div>
							<hr>

							<strong><i class="fas fa-map-marker-alt mr-1"></i> Ubicación</strong>
							<p class="text-muted">
								${scene.location.street}, ${scene.location.city.city} ${scene.location.postalcode} <br>
								${scene.location.city.county.county}, ${scene.location.city.county.country.country}
							</p>
							<p><a class="btn btn-primary btn-sm" href="https://www.google.es/maps/dir//${scene.location.gps}/@${scene.location.gps},12z" target="_blank">¿Cómo llegar?</a>
							</p>

							<c:if test="${not empty scene.location.web or not empty scene.location.email or not empty scene.location.phone }">
							<hr>
							<strong><i class="fas fa-info-circle"></i> Información de contacto</strong>
							<p>
								<c:if test="${not empty scene.location.web}"><span class="d-block"><b>Web: </b><a class="link" href="${scene.location.web}">${scene.location.web}</a></span></c:if>
								<c:if test="${not empty scene.location.email}"><span class="d-block"><b>Email: </b><a class="link" href="mailto:${scene.location.email}">${scene.location.email}</a></span></c:if>
								<c:if test="${not empty scene.location.phone}"><span class="d-block"><b>Teléfono: </b><a class="link" href="tel:${scene.location.phone}">${scene.location.phone}</a></span></c:if>
							</p>
							</c:if>
						</div>
						<!-- /.card-body -->
					</div>
				</div>
			</div>
		</div>
		<div class="row pb-3">
			<div class="col-12 text-right">
				<a href="scene?id=${scene.id}&page=edit" class="btn btn-info mr-2">Editar</a>
				<a href="scene-list" class="btn btn-primary mr-2">Ir al listado</a>
			</div>
		</div>
	</section>
	<!-- /.content -->
<%@include file="../WEB-INF/template/bottom.jsp" %>