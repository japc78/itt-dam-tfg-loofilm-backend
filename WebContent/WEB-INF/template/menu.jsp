<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="page" value="${fn:split(req.requestURI, '/')}" />

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
		<small>Juan Antonio <%= request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/")+1) %> </small><button type="button" class="btn btn-info btn-xs ml-3">Salir</button>
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
			<a href="home" class="nav-link ${page[1] eq 'dashboard.jsp' ? 'active': ''}">
				<i class="nav-icon fas fa-th"></i>
				<span>Inicio</span>
			</a>
			</li>
			<li class="nav-item has-treeview ${fn:split(page[1], '-')[0] eq 'location' ? 'menu-open': ''}">
				<a href="#" class="nav-link ${fn:split(page[1], '-')[0] eq 'location' ? 'active': ''}">
					<i class="nav-icon fas fa-map-marker-alt"></i>
					<p>
						Localización
						<i class="fas fa-angle-left right"></i>
					</p>
				</a>
				<ul class="nav nav-treeview">
					<li class="nav-item">
						<a href="location-list" class="nav-link ${page[1] eq 'location-list.jsp' ? 'active': ''}">
							<i class="far fa-circle nav-icon"></i>
							<p>Listado</p>
						</a>
					</li>
					<li class="nav-item">
						<a href="location-create" class="nav-link ${page[1] eq 'location-create.jsp' ? 'active': ''}">
							<i class="far fa-circle nav-icon"></i>
							<p>Nueva Localizacion</p>
						</a>
					</li>
				</ul>
			</li>
			<li class="nav-item has-treeview ${fn:split(page[1], '-')[0] eq 'production' ? 'menu-open': ''}">
			<a href="#" class="nav-link ${fn:split(page[1], '-')[0] eq 'production' ? 'active': ''}">
				<i class="nav-icon fas fa-video"></i>
				<p>
				Producción
				<i class="fas fa-angle-left right"></i>
				</p>
			</a>
			<ul class="nav nav-treeview">
				<li class="nav-item">
				<a href="production-list" class="nav-link ${page[1] eq 'production-list.jsp' ? 'active': ''}">
					<i class="far fa-circle nav-icon"></i>
					<p>Listado</p>
				</a>
				</li>
				<li class="nav-item">
				<a href="production-create" class="nav-link ${page[1] eq 'production-create.jsp' ? 'active': ''}">
					<i class="far fa-circle nav-icon"></i>
					<p>Nueva producción</p>
				</a>
				</li>
			</ul>
			</li>
			<li class="nav-item has-treeview ${fn:split(page[1], '-')[0] eq 'scene' ? 'menu-open': ''}">
			<a href="#" class="nav-link ${fn:split(page[1], '-')[0] eq 'scene' ? 'active': ''}">
				<i class="nav-icon fas fa-film"></i>
				<p>
				Escenas
				<i class="fas fa-angle-left right"></i>
				</p>
			</a>
			<ul class="nav nav-treeview">
				<li class="nav-item">
				<a href="scene-list" class="nav-link ${page[1] eq 'scene-list.jsp' ? 'active': ''}">
					<i class="far fa-circle nav-icon"></i>
					<p>Listado</p>
				</a>
				</li>
				<li class="nav-item">
				<a href="scene-create" class="nav-link ${page[1] eq 'scene-create.jsp' ? 'active': ''}">
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