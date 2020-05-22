<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../template/top.jsp"%>
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
                  <th style="width: 1%;">
                    id
                  </th>
                  <th style="width: 5%;">
                    Imagen
                  </th>
                  <th style="width: 15%;">
                    Nombre
                  </th>
                  <th style="width: 10%;">
                    Año
                  </th>
                  <th style="width: 10%;">
                    Tipo
                  </th>
                  <th style="width: 10%;"></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>
                    1
                  </td>
                  <td>
                    <img src="images/productions/doom_patrol.jpg" width="50px">
                  </td>
                  <td>
                    Doom Patrol
                  </td>
                  <td>
                    2019
                  </td>
                  <td>
                    Serie
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
                <tr>
                  <td>
                    2
                  </td>
                  <td>
                    <img src="images/productions/queen_slim.jpg" width="50px">
                  </td>
                  <td>
                    Queen & Slim
                  </td>
                  <td>
                    2019
                  </td>
                  <td>
                    film
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