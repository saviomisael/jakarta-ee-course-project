package com.exemplo.hello.finalproject.controller;

import com.exemplo.hello.finalproject.beans.Employee;
import com.exemplo.hello.finalproject.dao.EmployeeDAO;
import com.exemplo.hello.finalproject.dao.EmployeeDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class EmployeeController extends HttpServlet {
    private EmployeeDAO employeeDAO = null;

    @Override
    public void init() throws ServletException {
        super.init();

        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/add" -> addNewEmployee(req, resp);
            case "/update" -> updateEmployee(req, resp);
            case "/delete" -> deleteEmployee(req, resp);
            case "/get" -> getEmployee(req, resp);
            default -> listEmployees(req, resp);
        }
    }

    private void getEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("Start deleteEmployee");

            int id = Integer.parseInt(req.getParameter("id"));

            Employee employee = employeeDAO.getEmployee(id);
            req.setAttribute("employee", employee);
            System.out.println("getEmployee, result is ==> " + employee);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/employeesView.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void listEmployees(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("Start deleteEmployee");

            List<Employee> employees = employeeDAO.getAll();
            req.setAttribute("employees", employees);
            System.out.println("listEmployee, result is ==> " + employees);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/employeesView.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("Start deleteEmployee");

            int id = Integer.parseInt(req.getParameter("id"));

            employeeDAO.deleteEmployee(id);
            System.out.println("deleteEmployee, result is ==> " + id);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/employeesView.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("Start updateEmployee");

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");

            Employee employee = new Employee(id, name, email, phone, address);

            System.out.println("Employee details" + employee);
            System.out.println("updateEmployee, result is ==> " + employeeDAO.updateEmployee(employee));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/employeesView.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addNewEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("Start addNewEmployee");

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");

            Employee employee = new Employee(name, email, phone, address);

            System.out.println("Employee details" + employee);
            System.out.println("addNewEmployee, result is ==> " + employeeDAO.addEmployee(employee));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/employeesView.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
