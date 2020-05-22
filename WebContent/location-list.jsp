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
                    Provincia
                  </th>
                  <th style="width: 10%;">
                    País
                  </th>
                  <th style="width: 5%;" class="text-center">
                    Produc.
                  </th>
                  <th style="width: 10%;" class="text-center">
                    Fecha Alta
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
                    <img src="images/locations/mini/loofilm-alhambra-01.jpg" width="50px" alt="Loofilm - Imagen de la Alhambra">
                  </td>
                  <td>
                    Alhambra
                  </td>
                  <td>
                    Granada
                  </td>
                  <td>
                    España
                  </td>
                  <td class="text-center">
                    5
                  </td>
                  <td class="text-center">
                    2020-01-19 03:14:07
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