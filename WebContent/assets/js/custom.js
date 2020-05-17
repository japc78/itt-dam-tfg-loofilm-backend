$(function(){
    // First register any plugins
    $.fn.filepond.registerPlugin(FilePondPluginImagePreview);

    // Set allowMultiple property to true
    $('.imageUpload').filepond({
		allowMultiple: true,
		maxParallelUploads: 1,
		maxFiles: 1,
		labelIdle: 'Arrastre y suelte sus archivos o haga click aquí: <span class="btn btn-primary filepond--label-action">Añadir</span>',
		labelInvalidField: 'El campo contiene archivos inválidos',
		labelFileWaitingForSize: 'Esperando el tamaño',
		labelFileSizeNotAvailable: 'Tamaño no disponible',
		labelFileLoadError: 'Error al leer los fichros',
		labelFileProcessing: 'Procesando',
		labelFileProcessingComplete: 'Proceso completado',
		labelFileProcessingAborted: 'Proceso cancelado',
		labelFileProcessingError: 'Error al subir los ficheros',
		labelFileRemoveError: 'Error al eliminar',
		labelTapToCancel: 'Pulse para cancelar',
		labelTapToRetry: 'Pulse para reintentar',
		labelTapToUndo: 'Pulse para desehacer',
		labelButtonRemoveItem: 'Borrar',
		labelButtonAbortItemLoad: 'Cancelar',
		labelButtonRetryItemLoad: 'Reintentar',
		labelButtonAbortItemProcessing: 'Cancelar',
		labelButtonUndoItemProcessing: 'Deschacer',
		labelButtonRetryItemProcessing: 'Reintentar',
		labelButtonProcessItem:'Subir'

	});

    // Listen for addfile event
    $('.imageUpload').on('FilePond:addfile', function(e) {
        console.log('file added event', e);
    });

    // Manually add a file using the addfile method
    // $('.my-pond').first().filepond('addFile', 'index.html').then(function(file){
    //   console.log('file added', file);
    // });

  });

$(document).ready(function () {
	bsCustomFileInput.init();
	// $("#formImageUpload").dropzone({ url: "/file-upload" });
});