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
});