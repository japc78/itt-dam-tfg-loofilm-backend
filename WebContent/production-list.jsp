<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1><span class="badge badge-success">Listado</span> <span class="badge badge-primary">Producciones</span></h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item active">
              Listado de Localizaciones
            </li>
          </ol>
        </div>
      </div>
    </div>
    <!-- /.container-fluid -->
  </section>

  <!-- Main content -->
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-body">
            <table id="list_object" data-type="production" class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th style="width: 1%;">id</th>
                  <th style="width: 5%;" class="no-sort">Imagen</th>
                  <th>Nombre</th>
                  <th style="width: 5%;">Año</th>
                  <th style="width: 5%;">Tipo</th>
                  <th style="width: 5%;">Escenas</th>
 				  <th style="width: 2%;" class="text-center">Estado</th>
                  <th style="width: 120px;" class="no-sort"></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${productions}" var="p">
                <tr id="production-${p.id}">
                  <td>${p.id}</td>
                  <td><img src="images/productions/${(p.filename != '') ? p.filename : 'default.png'}" height="50px"></td>
                  <td>${p.name}</td>
                  <td>${p.year}</td>
                  <td>${p.type eq 0 ? 'serie':'film'}</td>
                  <td>${fn:length(p.scenes)}</td>
					<td class="text-center">
						<div class="custom-control custom-switch custom-switch-off-danger custom-switch-on-success">
							<input type="checkbox" class="custom-control-input check" id="check-${p.id}" ${p.active eq 'false' ? '': 'checked'}>
							<label class="custom-control-label" for="check-${p.id}"><span class="hidden">${p.active}</span></label>
						</div>
					</td>
                  <td class="project-actions text-right">
                    <a class="btn btn-primary btn-xs" href="production?id=${p.id}&page=view">Ver</a>
                    <a class="btn btn-info btn-xs" href="production?id=${p.id}&page=edit">Editar</a>
                    <a id="del-${p.id}" class="btn btn-danger btn-xs btnDel" href="#">Borrar</a>
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <!-- /.card-body -->
        </div>
        <!-- /.card -->
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->
  </section>
  <!-- /.content -->
<%@include file="../WEB-INF/template/bottom.jsp" %>