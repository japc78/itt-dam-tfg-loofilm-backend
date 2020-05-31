<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Añadir</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Inicio</a></li>
						<li class="breadcrumb-item active">
							Añadir Producción (Film o Serie)
						</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<form action="scene-create" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="card card-info">
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
										<option value="${l[0]}">${l[1]} - ${l[2]} - ${l[3]}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-6">
									<label for="">Producción</label>
									<select class="form-control select2" name="production">
										<option></option>
										<c:forEach items="${productions}" var="p">
										<option value="${p[0]}">${p[1]} - ${p[2]} - ${p[3] eq 0 ? 'film':'serie'}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="inputName">Nombre de la escena <small>max. 180 caracteres</small></label>
								<input type="text" id="inputName" class="form-control maxlength" name="name" maxlength="180" required/>
							</div>

							<div class="form-group">
								<label for="inputDescription">Descripción <small>máx. 320 caracteres.</small></label>
								<textarea id="inputDescription" class="form-control maxlength" rows="4" name="inputDescription" maxlength="320" required ></textarea>
							</div>

							<div class="form-group mb-3">
								<label for="inputName">Añadir video  <small>Link Youtube</small></label>
								<div class="input-group input-group">
									<input id="inputVideo" type="text" class="form-control maxlength" placeholder="https://youtu.be/yST45Y1y5zU" value="" maxlength="320">
									<span class="input-group-append">
										<button type="button" class="btn btn-info btn-flat rounded-right">Añadir vídeo</button>
									</span>
								</div>
							</div>

							<%-- <div class="form-group">
								<label for="inputDescription">Vídeos (Youtube) <small>enlaces de los vídeos separados por ; . max 5</small></label>
								<textarea id="inputDescription" class="form-control" rows="4" name="inputDescription" placeholder="Ej. https://youtu.be/iAqhy1E9i3E, https://youtu.be/iAqhy1E9i3E"></textarea>
							</div> --%>

							<div class="form-group">
								<label for="inputName">Imágenes</label>
								<div id="formImageUpload"></div>

								<!-- <form action="/file-upload" class="dropzone" id="my-awesome-dropzone">
									<div class="fallback">
										<input name="file" type="file" multiple />
									</div>
								</form> -->

								<input type="file" class="imageUpload" name="filepond" />
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