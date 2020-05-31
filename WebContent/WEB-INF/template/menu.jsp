<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item">
		<a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
		</li>
	</ul>
	<!-- Right navbar links -->
	<ul class="navbar-nav ml-auto">
		<li class="nav-item user user-menu">
		<small>Juan Antonio</small><button type="button" class="btn btn-info btn-xs ml-3">Salir</button>
		</li>
	</ul>
</nav>
<!-- /.navbar -->

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="home" class="brand-link">
		<img src="assets/img/loofilm_icon.svg" alt="Loofilm" class="brand-image img-circle elevation-3">
		<span class="brand-text font-weight-light">LOOFILM</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar Menu -->
		<nav class="mt-2">
		<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
			<!-- Add icons to the links using the .nav-icon class
			with font-awesome or any other icon font library -->
			<li class="nav-item">
			<a href="home" class="nav-link">
				<i class="nav-icon fas fa-th"></i>
				<span>Inicio</span>
			</a>
			</li>
			<li class="nav-item has-treeview">
				<a href="#" class="nav-link">
					<i class="nav-icon fas fa-map-marker-alt"></i>
					<p>
						Localización
						<i class="fas fa-angle-left right"></i>
					</p>
				</a>
				<ul class="nav nav-treeview">
					<li class="nav-item">
						<a href="location-list" class="nav-link">
							<i class="far fa-circle nav-icon"></i>
							<p>Listado</p>
						</a>
					</li>
					<li class="nav-item">
						<a href="location-create" class="nav-link">
							<i class="far fa-circle nav-icon"></i>
							<p>Nueva Localizacion</p>
						</a>
					</li>
				</ul>
			</li>
			<li class="nav-item has-treeview">
			<a href="#" class="nav-link">
				<i class="nav-icon fas fa-video"></i>
				<p>
				Producción
				<i class="fas fa-angle-left right"></i>
				</p>
			</a>
			<ul class="nav nav-treeview">
				<li class="nav-item">
				<a href="production-list" class="nav-link">
					<i class="far fa-circle nav-icon"></i>
					<p>Listado</p>
				</a>
				</li>
				<li class="nav-item">
				<a href="production-create" class="nav-link">
					<i class="far fa-circle nav-icon"></i>
					<p>Nueva producción</p>
				</a>
				</li>
			</ul>
			</li>
			<li class="nav-item has-treeview">
			<a href="#" class="nav-link">
				<i class="nav-icon fas fa-film"></i>
				<p>
				Escenas
				<i class="fas fa-angle-left right"></i>
				</p>
			</a>
			<ul class="nav nav-treeview">
				<li class="nav-item">
				<a href="scene-list" class="nav-link">
					<i class="far fa-circle nav-icon"></i>
					<p>Listado</p>
				</a>
				</li>
				<li class="nav-item">
				<a href="scene-create" class="nav-link">
					<i class="far fa-circle nav-icon"></i>
					<p>Nueva escena</p>
				</a>
				</li>
			</ul>
			</li>

		</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
<!-- /.sidebar -->
</aside>