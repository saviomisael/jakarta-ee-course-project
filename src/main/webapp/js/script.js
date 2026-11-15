var app = angular.module('employeeApp', []);

app.controller('employeeCtrl', function($scope, $http, $element) {
    $scope.getEmployeeDetails = function(employeeId) {
        return $http.post($element.attr('data-get-employee-url'), null, {
            params: {id: employeeId}
        }).then(function(response) {
            $scope.employee = response.data;
        }, function(error) {
            console.error('Error getting employee details:', error);
        });
    }
});

// Select All Employees Button
$(document).ready(function() {
    var checkbox = $('table tbody input[type="checkbox"]');

    $("#selectAll").click(function() {
        if(this.checked) {
            checkbox.each(function() {
                this.checked = true;
            });
        } else {
            checkbox.each(function() {
                this.checked = false;
            });
        }
    });
});

$('#deleteBtn').click(function() {
    var deletedEmployees = [];
    $("input:checkbox[class='employeeCheckBox']:checked").each(function() {
        deletedEmployees.push($(this).val());
    });

    deletedEmployees = deletedEmployees.join(",");
    var employeeIds = deletedEmployees.toString();

    $.ajax({
        url: '/meu-projeto-tomcat/employees/delete',
        type: 'POST',
        data: {"ids": employeeIds},
        success: function(data, textStatus, jqXHR) {
            if(data != "") {
                response = data;
            } else {
                response = '';
            }

            window.location.href = '/meu-projeto-tomcat/employees';
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("soemthing went wrong ==> ", errorThrown);
            response = '';
            alert('exception, errorThrown ==>', errorThrown);
        }
    })
});