// register the plugins with FilePond
FilePond.registerPlugin(
	FilePondPluginImagePreview,
	FilePondPluginImageResize,
	FilePondPluginImageTransform
  );

  const inputElement = document.querySelector('input[type="file"]');
  const pond = FilePond.create(inputElement, {
	allowMultiple: true,
	maxParallelUploads: 1,
	maxFiles: 5,
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
