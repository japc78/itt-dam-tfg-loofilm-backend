<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
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
		<form action="production-create" method="post">
			<div class="row">
				<div class="col-md-6">
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
							<div class="form-group">
								<label for="inputName">Nombre <small>max. 180 caracteres</small></label>
								<input type="text" id="inputName" class="form-control maxlength" name="name" maxlength="180" required/>
							</div>

							<div class="row">
								<div class="col-sm-6">
									<!-- text input -->
									<div class="form-group">
										<label>Año</label>
										<input type="inputYear" name="year" min="1885" max="2099" step="1" value="2020" class="form-control" required/>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>Tipo de Producción</label>
										<select id="inputType" name="type" class="custom-select">
											<option value="0">Serie</option>
											<option value="1" selected="selected">Pelicula</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="inputDescription">Descripción <small>máx. 500 caracteres.</small></label>
								<textarea id="inputDescription" class="form-control maxlength" rows="4" name="description"  maxlength="500" required></textarea>
							</div>

							<div class="form-group">
								<label for="inputCast">Casting <small>máx. 320 caracteres.</small></label>
								<textarea id="inputCast" class="form-control maxlength" rows="4" name="cast"  maxlength="320" required></textarea>
							</div>

							<div class="form-group mb-3">
								<label for="inputWeb">Web <small>max. 320 caracteres</small></label>
								<input type="url" id="inputWeb" class="form-control maxlength" name="web" placeholder="Ej. https://www.alhambra.com" required  maxlength="320"/>
							</div>

							<div class="form-group">
								<label for="inputWeb">Imagenes</label>
								<div id="formImageUpload"></div>

								<!-- <form action="/file-upload" class="dropzone" id="my-awesome-dropzone">
									<div class="fallback">
										<input name="file" type="file" multiple />
									</div>
								</form> -->
								<input type="file" class="imageUpload" name="filepond"/>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
				<div class="col-md-6">
					<div class="card card-info">
						<div class="card-header">
							<h3 class="card-title">Escenas</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body p-0">
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="width: 10px">id</th>
										<th>Escena o Rodaje</th>
										<th>Localización</th>
										<th>Ciudad</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Recrear el esplendor de los Palacios Nazaríes</td>
										<td>La Alhambra</td>
										<td>Granada</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>

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