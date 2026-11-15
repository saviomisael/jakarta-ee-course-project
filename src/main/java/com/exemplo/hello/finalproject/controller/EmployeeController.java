package com.exemplo.hello.finalproject.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.hello.finalproject.beans.Employee;
import com.exemplo.hello.finalproject.dao.EmployeeDAO;
import com.exemplo.hello.finalproject.dao.EmployeeDAOImpl;
import com.google.gson.Gson;

// If you use the root path, the project can't load the static files
@WebServlet("/employees/*")
public class EmployeeController extends HttpServlet {
    private static final int PAGE_SIZE = 5;
    private EmployeeDAO employeeDAO = null;

    @Override
    public void init() throws ServletException {
        super.init();

        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listEmployees(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
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

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(new Gson().toJson(employee));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void listEmployees(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int page = 1;
            String pageParameter = req.getParameter("page");
            if (pageParameter != null) {
                try {
                    page = Integer.parseInt(pageParameter);
                } catch (NumberFormatException ex) {
                    // it will use page equals 1
                }
                if (page < 1) {
                    page = 1;
                }
            }

            int totalEmployees = employeeDAO.getCount();
            int totalPages = (int) Math.ceil((double) totalEmployees / PAGE_SIZE);
            if (totalPages > 0 && page > totalPages) {
                page = totalPages;
            }

            int offset = (page - 1) * PAGE_SIZE;
            List<Employee> employees = employeeDAO.getPage(PAGE_SIZE, offset);
            req.setAttribute("employees", employees);
            req.setAttribute("page", page);
            req.setAttribute("totalEmployees", totalEmployees);
            req.setAttribute("totalPages", totalPages);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/employeesView.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            boolean isDeleted = false;
            RuntimeException deleteException = null;

            try {
                System.out.println("Start deleteEmployee");

                int id = Integer.parseInt(req.getParameter("id"));

                employeeDAO.deleteEmployee(id);
                System.out.println("deleteEmployee, result is ==> " + id);

                isDeleted = true;
            } catch(Exception ex) {
                deleteException = new RuntimeException(ex);
            }

            try {
                String ids = req.getParameter("ids");

                List<Integer> idsInt = Stream.of(ids.split(",")).map(Integer::parseInt).toList();

                for(int idInt : idsInt) {
                    System.out.println(employeeDAO.deleteEmployee(idInt));
                }

                isDeleted = true;
            } catch(Exception ex) {
                deleteException = new RuntimeException(ex);
            }

            if(!isDeleted) {
                throw deleteException;
            }

            listEmployees(req, resp);
        } catch (Exception ex) {
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
            listEmployees(req, resp);
        } catch (Exception ex) {
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
            listEmployees(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
