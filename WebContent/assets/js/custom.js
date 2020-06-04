// Scripts para el proyecto.
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
			check = $(this);

			// Se recogen los datos del listado
			id = this.id.split('-');
			active = $(this).prop("checked");

			// Se guarda el estado anterior por si falla al actualizarse
			stateBefore = $(this).prop("checked") == true ? false : true;

			// Se recoge la url, asi el mismo metodo me vale para los 3 listados, se obtiene la procedencia -> categoy.
			url = $(location).attr("href").split('/');
			category = url[url.length-1].split('-')[0];

			// console.log('id: ' + id[1]);
			// console.log('active: ' + active);
			// console.log('url: ' + url);
			// console.log('url: ' + category);

			// A traves del http post se realiza la actualizacion del elemento.
			$.post("update-status",
			{
				id: id[1],
				category: category,
				active: active
			},
			function(data, status){
				// Muestra un mensaje con el estado que devuelve el servlet.
				if (data.split(':')[0] == 'OK') {
					toastr.options = {
						"positionClass": "toast-top-center",
						"showDuration": "300",
						"hideDuration": "500",
						"timeOut": "1000"
					}
					toastr.success(data);
				} else {
					toastr.success(data);
					// Sino vuelve al estado anterior.
					check.prop("checked", stateBefore);
				}
				// console.log('Data: ' + data);
				// console.log('Status: ' + status);
			});
		});
	}

	// Eliminar un elemento.
		if ($(".btnDel").length){
			$(".btnDel").click(function(e){
				e.preventDefault();
				// Se recoge el id del elemento
				id = this.id.split('-')[1];

				// Se recoge la url, asi el mismo metodo me vale para los 3 listados, se obtiene la procedencia -> categoy.
				url = $(location).attr("href").split('/');
				category = url[url.length-1].split('-')[0];

				// console.log('id: ' + id);
				// console.log('category: ' + category);

				// Plantilla de la modal a mostrar para confirmar el borrado.
				htmlTeplate = `
					<form class="modal fade" id="modaldanger" action="delete" method="post">
						<div class="modal-dialog" role="document">
							<div class="modal-content bg-danger">
								<div class="modal-header">
									<h4 class="modal-title">Atención!!</h4>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								</div>
								<div class="modal-body">
									<p>Esta seguro que desea borrar el elemento</p>
								</div>
								<div class="modal-footer">
									<input type="hidden" name="id" value="${id}">
									<input type="hidden" name="category" value="${category}">

									<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
									<button type="submit" class="btn btn-primary btnConfirmDel">Borrar</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal-dialog -->
					</form><!-- /.modal -->`

				$("body").append(htmlTeplate);
				$('#modaldanger').modal('show');
			});
		}

		if ($(".btnConfirmDel").length){
			$(".btnConfirmDel").click(function(e){
				e.preventDefaul();
				// Se recoge al inputcheck sobre el que se realiza la accion.
				btn = $(this);
				log

				// Se recogen los datos del listado
				category = this.id.split('-')[0];
				id = this.id.split('-')[1];

				console.log('id: ' + id);
				console.log('categoria: ' + category);

				// A traves del http post se realiza la actualizacion del elemento.
				$.post("delete",
				{
					id: id[1],
					category: category
				});
			});
		}

});