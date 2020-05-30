<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../template/top.jsp"%>
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
										<optgroup label="Granada">
											<option value="3">Alhambra</option>
											<option value="8">Sierra Nevada</option>
										</optgroup>
										<optgroup label="Sevilla">
											<option value="2">La Giralda</option>
											<option value="1">Torre del Oro</option>
										</optgroup>
									</select>
								</div>

								<div class="form-group col-md-6">
									<label for="">Producción</label>
									<select class="form-control select2" name="location">
										<option></option>
										<optgroup label="Films">
											<option value="2">Queen & Slim </option>
										</optgroup>
										<optgroup label="Series">
											<option value="1">Doom Patrol</option>
											<option value="4">The Boyz</option>
										</optgroup>

										<!-- <optgroup label="España/Sevilla">
											<option>La Giralda</option>
											<option>Torre del Oro</option>
										</optgroup> -->
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

								<form action="" method="post" enctype="multipart/form-data">
									<input type="file" class="imageUpload" name="filepond" />
								</form>
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
<%@include file="../template/bottom.jsp" %>