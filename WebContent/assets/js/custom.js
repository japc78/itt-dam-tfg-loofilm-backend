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
		language: "es",
		selectionAdapter: 'SingleSelection'
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
});