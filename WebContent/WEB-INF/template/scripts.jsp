<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="assets/js/jquery.min.js"></script>

<!-- Toastr -->
<script src="assets/js/toastr.min.js"></script>

<c:if test="${isForm ge 1}">
	<!-- Bootstrap 4 -->
	<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/bootstrap-maxlength.min.js"></script>

	<!-- Image upload</script>-->
	<script src="assets/js/image-uploader.min.js"></script>
</c:if>

<c:if test="${withSelect2 ge 1}">
	<!-- Select2 -->
	<script src="assets/js/select2/select2.min.js"></script>
	<script src="assets/js/select2/es.js"></script>
</c:if>

<c:if test="${isList ge 1}">
	<!-- DataTables -->
	<script src="assets/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/dataTables.bootstrap4.min.js"></script>
	<script src="assets/js/dataTables.responsive.min.js"></script>
	<script src="assets/js/responsive.bootstrap4.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</c:if>

<c:if test="${withMaps ge 1}">
	<!-- Googole maps -->
	<script src="https://maps.googleapis.com/maps/api/js?v=weekly&key=AIzaSyAtE8CLC9umWj6xxhoQIdZ7kK-iKzcWZY0&libraries=places&language=es-ES&callback=initMap" async defer></script>
	<script src="assets/js/maps.js"></script>
</c:if>

<c:if test="${withBasicMaps ge 1}">
	<!-- Googole maps -->
	<script src="https://maps.googleapis.com/maps/api/js?v=weekly&key=AIzaSyAtE8CLC9umWj6xxhoQIdZ7kK-iKzcWZY0&language=es-ES&callback=basicMap" async defer></script>
	<script src="assets/js/maps.js"></script>
</c:if>


<c:if test="${withFancyBox ge 1}">
	<!-- Googole maps -->
	<script src="assets/js/jquery.fancybox.min.js"></script>
</c:if>

<!-- AdminLTE App -->
<script src="assets/js/adminlte.min.js"></script>
<script src="assets/js/custom.js"></script>
