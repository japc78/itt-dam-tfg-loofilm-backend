<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../template/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Listado</h1>
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
            <table
              id="list_object"
              class="table table-bordered table-striped"
            >
              <thead>
                <tr>
                  <th style="width: 1%;">id</th>
                  <th style="width: 5%;" class="no-sort">Imagen</th>
                  <th>Nombre</th>
                  <th style="width: 5%;">Año</th>
                  <th style="width: 5%;">Tipo</th>
                  <th style="width: 5%;">Escenas</th>
 				  <th style="width: 2%;" class="text-center">Estado</th> 
                  <th style="width: 15%;" class="no-sort"></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${productions}" var="p">
                <tr>
                  <td>${p[0]}</td>
                  <td><img src="images/productions/doom_patrol.jpg" width="50px"></td>
                  <td>${p[1]}</td>
                  <td>${p[2]}</td>
                  <td>${p[3] eq 0 ? 'film':'serie'}</td>
                  <td>${p[4]}</td>
					<td class="text-center">
						<div class="custom-control custom-switch custom-switch-off-danger custom-switch-on-success">
							<input type="checkbox" class="custom-control-input check" id="check-${p[0]}" ${p[5] eq 'false' ? '': 'checked'}>  
							<label class="custom-control-label" for="check-${p[0]}"><span class="hidden">${p[5]}</span></label>
						</div>
					</td>                  
                  <td class="project-actions text-right">
                    <a class="btn btn-primary btn-xs" href="#">
                      <i class="fas fa-folder"> </i>
                      Ver
                    </a>
                    <a class="btn btn-info btn-xs" href="#">
                      <i class="fas fa-pencil-alt"> </i>
                      Editar
                    </a>
                    <a class="btn btn-danger btn-xs" href="#">
                      <i class="fas fa-trash"> </i>
                      Borrar
                    </a>
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
<%@include file="../template/bottom.jsp" %>