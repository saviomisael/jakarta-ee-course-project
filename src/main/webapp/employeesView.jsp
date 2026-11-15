<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="getEmployeeUrl" value="/employees/get"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Servlet, JSP, JDBC and MVC Example</title>

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/meu-projeto-tomcat/css/employee.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

    <script defer src="/meu-projeto-tomcat/js/employee.js"></script>
    <script defer src="/meu-projeto-tomcat/js/script.js"></script>
</head>
<body ng-app="employeeApp" ng-controller="employeeCtrl"
      data-get-employee-url="${getEmployeeUrl}">
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>
                        Manage <b>Employees</b>
                    </h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal" class="btn btn-success"
                       data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
								New Employee</span></a> <a href="#deleteEmployeeModal"
                                                           class="btn btn-danger" data-toggle="modal"><i
                        class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <span class="custom-checkbox">
                        <input type="checkbox" id="selectAll">
                        <label for="selectAll"></label>
                    </span>
                </th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input class="employeeCheckBox" type="checkbox" id="checkbox1" name="options[]" value="${employee.id}">
                            <label for="checkbox1"></label>
						</span>
                    </td>
                    <td>
                            ${employee.name}
                    </td>
                    <td>
                            ${employee.email}
                    </td>
                    <td>
                            ${employee.address}
                    </td>
                    <td>
                            ${employee.phone}
                    </td>
                    <td>
                        <a href="#editEmployeeModal" class="edit" data-toggle="modal">
                            <i class="material-icons" ng-click="getEmployeeDetails('${employee.id}')"
                               data-toggle="tooltip" title="Edit">&#xE254;</i>
                        </a>
                        <a href="#deleteEmployeeModal" class="delete" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="clearfix">
            <div class="hint-text">
                Showing <b>${employees.size()}</b> out of <b>${totalEmployees}</b> entries
            </div>
            <c:url var="employeesUrl" value="/employees"/>
            <ul class="pagination">
                <li class="page-item ${page <= 1 ? 'disabled' : ''}">
                    <c:choose>
                        <c:when test="${page <= 1}">
                            <a class="page-link" href="#" aria-disabled="true">Previous</a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link" href="${employeesUrl}?page=${page - 1}">Previous</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <c:forEach begin="1" end="${totalPages}" var="pageNumber">
                    <li class="page-item ${pageNumber == page ? 'active' : ''}">
                        <a href="${employeesUrl}?page=${pageNumber}" class="page-link">${pageNumber}</a>
                    </li>
                </c:forEach>
                <li class="page-item ${page >= totalPages ? 'disabled' : ''}">
                    <c:choose>
                        <c:when test="${page >= totalPages}">
                            <a class="page-link" href="#" aria-disabled="true">Next</a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link" href="${employeesUrl}?page=${page + 1}">Next</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/meu-projeto-tomcat/employees/add" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Employee</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label> <input name="name" type="text" class="form-control"
                                                   required>
                    </div>
                    <div class="form-group">
                        <label>Email</label> <input name="email" type="email" class="form-control"
                                                    required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea name="address" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Phone</label> <input name="phone" type="text" class="form-control"
                                                    required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal"
                           value="Cancel"> <input type="submit"
                                                  class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/meu-projeto-tomcat/employees/update" method="POST">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                </div>

                <div>
                    <input type="hidden" name="id" ng-value="employee.id">
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input ng-model="employee.name" name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input ng-model="employee.email" name="email" type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <textarea ng-model="employee.address" name="address" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input ng-model="employee.phone" name="phone" type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal"
                           value="Cancel"> <input type="submit" class="btn btn-info"
                                                  value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning">
                        <small>This action cannot be undone.</small>
                    </p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" id="deleteBtn" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>