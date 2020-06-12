<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1><span class="badge badge-warning">Editar</span> <span class="badge badge-primary">${scene.id}</span> ${scene.name} </h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Inicio</a></li>
						<li class="breadcrumb-item active">
							Editar Escena
						</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<form id="form" action="scene-create" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-12">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">Información general</h3>
							<div class="card-tools">
								<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="form-group col-md-6">
									<label for="">Localización</label>
									<select class="form-control select2" name="location">
										<option></option>
										<c:forEach items="${locations}" var="l">
										<option value="${l[0]}" ${scene.location.id eq l[0]? 'selected':''}>${l[1]} - ${l[2]} - ${l[3]}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-6">
									<label for="">Producción</label>
									<select class="form-control select2" name="production">
										<option></option>
										<c:forEach items="${productions}" var="p">
										<option value="${p[0]}" ${scene.production.id eq p[0]? 'selected':''}>${p[1]} - ${p[2]} - ${p[3] eq 0 ? 'film':'serie'}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="inputName">Nombre de la escena <small>max. 180 caracteres</small></label>
								<input type="text" id="inputName" class="form-control maxlength" name="name" maxlength="180" required value="${scene.name}"/>
							</div>

							<div class="form-group">
								<label for="inputDescription">Descripción <small>máx. 320 caracteres.</small></label>
								<textarea id="inputDescription" class="form-control maxlength" rows="4" name="inputDescription" maxlength="320" required >${scene.description}</textarea>
							</div>

							<div class="form-group mb-3">
								<label for="inputName">Añadir video  <small>Link Youtube</small></label>
								<input id="inputVideo" type="text" class="form-control maxlength" placeholder="https://youtu.be/yST45Y1y5zU" value="${scene.video}" maxlength="320">
							</div>

							<div class="form-group">
								<label for="inputName">Imágenes <small>(max. 5 imágenes)</small></label>
								<div class="input-images" data-maxfiles="5"></div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>

			<div class="row pb-3">
				<div class="col-12 text-right">
					<a href="#" class="btn btn-secondary mr-2">Cancelar</a>
					<input type="submit" value="Guardar" class="btn btn-success float-right" />
				</div>
			</div>
		</form>
	</section>
	<!-- /.content -->
<%@include file="../WEB-INF/template/bottom.jsp" %>