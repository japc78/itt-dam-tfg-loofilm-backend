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
					<li class="breadcrumb-item active">Añadir Localización</li>
				</ol>
			</div>
		</div>
	</div><!-- /.container-fluid -->
</section>

<!-- Main content -->
<section class="content">
	<form id="form" action="location-create" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-md-6">
				<!-- Card GPS -->
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">Localización</h3>
						<div class="card-tools">
							<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
								<i class="fas fa-minus"></i></button>
						</div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<input id="pac-input" class="form-control mb-3" type="text" placeholder="Escribe la dirección de la localización" autocomplete="off">
							<div id="map" class="map rounded"></div>
						</div>
						<div class="form-group">
							<div class="">
								<ul id="addressPreview" class="infoAddress alert-default-info list-unstyled rounded p-3"></ul>
							</div>

							<!-- <textarea id="inputAddressPreview" class="form-control" rows="3" disabled="" name="inputAddressPreview"></textarea> -->
							<input type="hidden" id="inputCity" name="locality" value="">
							<input type="hidden" id="inputPostalCode" name="postal_code" value="">
							<input type="hidden" id="inputCounty" name="administrative_area_level_2" value="">
							<input type="hidden" id="inputCountry" name="country" value="">
							<input type="hidden" id="inputCountryCode" name="countryCode" value="">
							<input type="hidden" id="inputGps" name="gps" value="">
							<%-- <button type="submit" class="btn btn-primary mt-2">Corregir textos</button> --%>

						</div>
						<!-- <div class="form-group">
							<label for="inputGPS">GPS <small>(coordenadas GPS: Latitud,Longitud)</small></label>
							<input type="text" id="inputGPS" class="form-control" name="inputGPS" disabled>
							<small>Haz Click para obtener Ciudad, Provincia o Estado, y País de la Localización.</small>
							<button type="submit" class="btn btn-primary mt-2">Obtener</button>
						</div> -->
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">General</h3>
						<div class="card-tools">
							<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
								<i class="fas fa-minus"></i></button>
						</div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="inputName">Nombre <small>max. 180 caracteres</small></label>
							<input type="text" id="inputName" class="form-control maxlength" name="name" maxlength="180" required>
						</div>
						<div class="form-group">
							<label for="inputDescription">Descripción <small>máx. 500 caracteres.</small></label>
							<textarea id="inputDescription" class="form-control maxlength" rows="4" name="description" maxlength="500" required></textarea>
						</div>
					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->

				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">Info</h3>

						<div class="card-tools">
							<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
								<i class="fas fa-minus"></i></button>
						</div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="inputStreet">Dirección <small>max. 320 caracteres.</small></label>
							<input type="text" id="inputStreet" class="form-control maxlength mb-3" name="street" maxlength="320" required>
						</div>

						<div class="form-group">
							<label for="inputWeb">Web <small>max. 320 caracteres</small></label>
							<input type="url" id="inputWeb" class="form-control maxlength" name="web" placeholder="Ej. https://www.alhambra.com" maxlength="320">
						</div>
						<div class="form-group">
							<label for="inputEmail">Email</label>
							<input type="email" name="email" class="form-control maxlength" id="inputEmail" placeholder="Ej. info@alhambra.com" maxlength="320">
						</div>

						<div class="form-group">
							<label for="inputPhone">Teléfono</label>
							<input type="text" name="phone" class="form-control maxlength" id="inputPhone" placeholder="Ej. 999777888" maxlength="12">
						</div>
					</div>
					<!-- /.card-body -->
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-12">

				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">Imagenes <small>(max. 5 imágenes)</small></h3>
						<div class="card-tools">
							<button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
								<i class="fas fa-minus"></i></button>
						</div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<!--<div id="formImageUpload"></div>
							 <form action="/file-upload" class="dropzone" id="my-awesome-dropzone">
							<div class="fallback">
								<input name="file" type="file" multiple />
							</div>
							</form> -->

							<input name="file" type="file" multiple required/>

							<!-- <form action="" method="post" enctype="multipart/form-data">
										<div class="input-group">
											<div class="custom-file">
												<input type="file" class="custom-file-input" id="exampleInputFile" multiple>
												<label class="custom-file-label" for="exampleInputFile">Añade las imágenes</label>
											</div>
											<div class="input-group-append">
												<span class="input-group-text" id="">Upload</span> 
											</div>
										</div>
							</form> -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row pb-3">
			<div class="col-12 text-right">
				<a href="#" class="btn btn-secondary mr-2">Cancelar</a>
				<input type="submit" value="Guardar" class="btn btn-success float-right"> 
			</div>
		</div>
	</form>
</section>
<!-- /.content -->

<%-- Mensajes --%>
<div class="msg ${msgType}">
	<span>${msg}</span>
</div>
<%@include file="../WEB-INF/template/bottom.jsp" %>