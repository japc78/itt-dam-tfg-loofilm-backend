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
            <table id="list_object" class="table table-bordered table-striped location"> 
              <thead>
                <tr>
                  <th style="width: 1%;" class="order">id</th>
                  <th style="width: 5%;" class="no-sort">Imagen</th>
                  <th style="width: 15%;">Nombre</th>
                  <th style="width: 10%;">Ciudad</th>
                  <th style="width: 10%;">Provincia</th>
                  <th style="width: 10%;">País</th>
                  <th style="width: 5%;" class="text-center">Produc.</th>
                  <th style="width: 10%;" class="no-sort"></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${locations}" var="l">
                <tr>
                  <td>${l[0]}</td>
                  <td><img src="images/locations/default.png" width="50px"></td>
                  <td>${l[1]}</td>
                  <td>${l[2]}</td>
                  <td>${l[3]}</td>
                  <td>${l[4]}</td>
                  <td class="text-center">${l[5]}</td>
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