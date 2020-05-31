// Scripts para el proyecto.
// Jquery
$(document).ready(function () {
	// bsCustomFileInput.init();
	// $("#formImageUpload").dropzone({ url: "/file-upload" });

	// Evita que los formularios se envien al pulsar enter.
	$("form").keypress(function(e){
		if(e.keyCode == 13) {
			e.preventDefault();
			return false;
		}
	})

	// Contador de caracteres para Bootsrap
	// Links: https://www.jqueryscript.net/form/jQuery-Character-Counter-Limit-Plugin-For-Bootstrap.html
	$('.maxlength').maxlength({
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

	// Bootstrap Select2. Select con buscador.
	$('.select2').select2({
		placeholder: 'Seleccione una opción',
		allowClear: true,
		language: "es"
	});

	// Datatables
	$("#list_object").DataTable({
		responsive: true,
		autoWidth: true,
		ordering: true,
		paging: true,
		info: true,
		lengthMenu: [15, 30, 50, 100],
		order: [ 0, "desc" ],
		responsive: true,
        columnDefs: [
            { orderable: false, targets: 'no-sort' }
        ],
		language: {
		"url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
		}
	});

	// Activar un elemento del listado Localicaiones
	$(".check").click(function(){
		// Se recoge al inputcheck sobre el que se realiza la accion.
		check = $(this);

		// Se recogen los datos del listado
		id = this.id.split('-');
		active = $(this).prop("checked");
		
		// Se guarda el estado anterior por si falla al actualizarse
		stateBefore = $(this).prop("checked") == true ? false : true;

		// Se recoge la url, asi el mismo metodo me vale para los 3 listados.
		url = $(location).attr("href").split('/');

		// console.log('id: ' + id[1]);
		// console.log('active: ' + active);
		// console.log('url: ' + url[url.length-1]);

		// A traves del http post se realiza la actualizacion del elemento.
		$.post(url[url.length-1],
		{
		  id: id[1],
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
});