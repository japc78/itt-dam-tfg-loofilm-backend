// Scripts para el proyecto.
function readURL(input) {
	if (input.files && input.files[0]) {
	  var reader = new FileReader();

	  reader.onload = function(e) {
		$('#blah').attr('src', e.target.result);
	  }

	  reader.readAsDataURL(input.files[0]); // convert to base64 string
	}
  }


// Jquery
$(document).ready(function () {
	// Evita que los formularios se envien al pulsar enter.
	if ($("form").length){
		$("form").keypress(function(e){
			if(e.keyCode == 13) {
				e.preventDefault();
				return false;
			}
		})
	}

	// Contador de caracteres para Bootsrap
	// Links: https://www.jqueryscript.net/form/jQuery-Character-Counter-Limit-Plugin-For-Bootstrap.html
	if ($(".maxlength").length){
		$(".maxlength").maxlength({
			showOnReady:false,
			alwaysShow:true,
			threshold: 0,
			warningClass:"badge badge-info",
			limitReachedClass:"badge badge-danger",
			separator:" / ",
			preText:"",
			postText:"",
			showMaxLength:true,
			placement:"bottom-right-inside",
			message:null,
			showCharsTyped:true,
			validate:false,
			utf8:false,
			appendToParent:false,
			twoCharLinebreak:true,
			customMaxAttribute:null,
			allowOverMax:false,
			zIndex: 1099
		});
	}

	// Bootstrap Select2. Select con buscador.
	if ($(".select2").length){
		$(".select2").select2({
			placeholder: 'Seleccione una opción',
			allowClear: true,
			language: "es"
		});
	}

	// Datatables
	if ($("#list_object").length){
		$("#list_object").DataTable({
			responsive: true,
			autoWidth: true,
			ordering: true,
			paging: true,
			info: true,
			lengthMenu: [10, 25, 50, 100],
			order: [ 0, "desc" ],
			responsive: true,
			columnDefs: [
				{ orderable: false, targets: 'no-sort' }
			],
			language: {
			"url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
			}
		});
	}

	// Activar un elemento del listado Localicaiones
	if ($(".check").length){
		$(".check").click(function(){
			// Se recoge al inputcheck sobre el que se realiza la accion.
			// closest('parametro') para obtener el primer elemento que coincida con el parámetro especificado, podría ser un ID, una clase o directamente un tag como en este caso.
			// https://es.stackoverflow.com/questions/200624/como-obtener-el-padre-superior-con-jquery
			idParent = $(this).closest('tr').attr("id");

			// Se recogen los datos del listado
			id = idParent.split('-')[1];
			category = idParent.split('-')[0];
			active = $(this).prop("checked");

			// Se guarda el estado anterior por si falla al actualizarse
			stateBefore = $(this).prop("checked") == true ? false : true;

			console.log('id: ' + id);
			console.log('active: ' + active);
			console.log('category: ' + category);

			// A traves del http post se realiza la actualizacion del elemento.

			$.post("update-status",
			{
				id: id,
				category: category,
				active: active
			},
			function(data, status){
				toastr.options = {
					"positionClass": "toast-top-center",
					"showDuration": "300",
					"hideDuration": "500",
					"timeOut": "1000"
				}
				// Muestra un mensaje con el estado que devuelve el servlet.
				if (data.split(':')[0] == 'OK') {
					toastr.success(data);
				} else {
					toastr.error(data);
					// Sino vuelve al estado anterior.
					check.prop("checked", stateBefore);
				}
				console.log('Data: ' + data);
				console.log('Status: ' + status);
			});
		});
	}

	// Eliminar un elemento, muestra una modal de confirmación antes de borrar.
	if ($(".btnDel").length){
		$(".btnDel").click(function(e){
			e.preventDefault();
			// Se recoge al inputcheck sobre el que se realiza la accion.
			// closest('parametro') para obtener el primer elemento que coincida con el parámetro especificado, podría ser un ID, una clase o directamente un tag como en este caso.
			// https://es.stackoverflow.com/questions/200624/como-obtener-el-padre-superior-con-jquery
			idParent = $(this).closest('tr').attr("id");

			// Se recogen los datos del listado
			id = idParent.split('-')[1];
			category = idParent.split('-')[0];

			// console.log('id: ' + id);
			// console.log('category: ' + category);
			msg1 = "Está seguro que desea borrar el elemento, se eliminaran también todas las escenas asociadas.";
			msg2 = "Está seguro que desea borrar el elemento";

			// Plantilla de la modal a mostrar para confirmar el borrado.
			htmlTeplate = `
				<form class="modal fade" id="modaldanger" action="delete" method="post">
					<div class="modal-dialog" role="document">
						<div class="modal-content bg-danger">
							<div class="modal-header">
								<h3 class="modal-title">ATENCIÓN!!</h3>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							</div>
							<div class="modal-body">
								<p>${(category == 'scene')?msg2:msg1}</p>
							</div>
							<div class="modal-footer">
								<input type="hidden" name="id" value="${id}">
								<input type="hidden" name="category" value="${category}">
								<button type="submit" class="btn btn-primary btnConfirmDel">Borrar</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</form><!-- /.modal -->`

			$("body").append(htmlTeplate);
			$('#modaldanger').modal('show');
		});
	}

	// Preview de imagnes en input files.
	// https://www.codehim.com/demo/jquery-image-uploader-preview-and-delete/
	if ($(".input-images").length){
		// Se recoge el maximo de imágenes desde un atributo data del elemento.
		maxfiles = $('.input-images').data("maxfiles");
		// console.log("Max files: " + maxfiles);

		$('.input-images').imageUploader({
				label: 'Arrstre y suelte los archivos aquí o haga clic para navegar',
				maxFiles: maxfiles,
				maxSize: 2097152, // 2Mb
				mimes: ['image/jpeg'],
				extensions: ['.jpg', '.jpeg']
			}
		);
	}
});