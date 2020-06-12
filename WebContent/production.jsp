<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1><span class="badge badge-warning">Editar</span> <span class="badge badge-primary">${production.id}</span> <span class="badge badge-primary">${production.type eq 0 ? 'serie':'film'}</span>  ${production.name}</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Inicio</a></li>
						<li class="breadcrumb-item active">
							Editar Producción (Film o Serie)
						</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<form action="production-update" method="post" enctype="multipart/form-data">
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
							<div class="form-group">
								<label for="inputName">Nombre <small>max. 180 caracteres</small></label>
								<input type="text" id="inputName" class="form-control maxlength" name="name" maxlength="180" required value="${production.name}"/>
								<input type="hidden" id="inputId" name="id" value="${production.id}">
								<input type="hidden" id="inputActive" name="active" value="${production.active}">

							</div>

							<div class="row">
								<div class="col-sm-6">
									<!-- text input -->
									<div class="form-group">
										<label>Año</label>
										<input type="inputYear" name="year" min="1885" max="2099" step="1" value="2020" class="form-control" required value="${production.year}"/>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>Tipo de Producción</label>
										<select id="inputType" name="type" class="custom-select">
											<option value="0" ${production.type eq 0? selected : ''}>Serie</option>
											<option value="1" ${production.type eq 1? selected : ''}>Film</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="inputDescription">Descripción <small>máx. 500 caracteres.</small></label>
								<textarea id="inputDescription" class="form-control maxlength" rows="4" name="description"  maxlength="500" required>${production.description}</textarea>
							</div>

							<div class="form-group">
								<label for="inputCast">Casting <small>máx. 320 caracteres.</small></label>
								<textarea id="inputCast" class="form-control maxlength" rows="4" name="cast"  maxlength="320" required>${production.cast}</textarea>
							</div>

							<div class="form-group mb-3">
								<label for="inputWeb">Web <small>max. 320 caracteres</small></label>
								<input type="url" id="inputWeb" class="form-control maxlength" name="web" placeholder="Ej. https://www.alhambra.com" required  maxlength="320" value="${production.web}"/>
							</div>

							<div class="form-group">
								<label for="inputWeb">Cartel o imagen</label>
								<ul>
									<li><img class="image" src="${path}${production.filename}" data-id="${production.id}"></li>
								</ul>
 								<div class="input-images" data-maxfiles="1"></div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-12 text-right">
					<a href="production-list" class="btn btn-secondary mr-2">Cancelar</a>
					<input type="submit" value="Guardar" class="btn btn-success float-right" />
				</div>
			</div>
		</form>
	</section>
	<!-- /.content -->
<%@include file="../WEB-INF/template/bottom.jsp" %>