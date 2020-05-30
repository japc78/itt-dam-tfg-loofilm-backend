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
});