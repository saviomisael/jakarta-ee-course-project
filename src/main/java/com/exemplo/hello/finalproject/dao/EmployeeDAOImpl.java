package com.exemplo.hello.finalproject.dao;

import com.exemplo.hello.finalproject.beans.Employee;
import com.exemplo.hello.finalproject.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean addEmployee(Employee employee) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();
            String sql = """
                    INSERT INTO employee_db.employee (
                        name,
                        email,
                        phone,
                        address
                    )
                    VALUES (
                        ?,
                        ?,
                        ?,
                        ?
                    )
                    """;

            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getAddress());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception e) {
                // do nothing
            }
            throw ex;
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();
            String sql = """
                    UPDATE employee_db.employee
                    SET name = ?,
                    email = ?,
                    phone = ?,
                    address = ?
                    WHERE
                    id = ?
                    """;

            ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getAddress());
            ps.setInt(5, employee.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception e) {
                // do nothing
            }
            throw ex;
        } finally {
            if(ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();
            String sql = """
                    DELETE FROM employee_db.employee
                    WHERE
                    id = ?
                    """;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception e) {
                // do nothing
            }
            throw ex;
        } finally {
            if(ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Employee> getAll() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();
            String sql = """
                    SELECT * FROM employee_db.employee
                    """;

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            List<Employee> employees = new ArrayList<>();
            EmployeeMapper mapper = new EmployeeMapper();
            while(rs.next()) {
                Employee employee = mapper.buildEmployee(rs);
                employees.add(employee);
            }

            return employees;
        } catch (Exception ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception e) {
                // do nothing
            }
            throw ex;
        } finally {
            if(rs != null) {
                rs.close();
            }

            if(ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Employee getEmployee(int employeeId) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();
            String sql = """
                    SELECT * FROM employee_db.employee
                    WHERE
                    id = ?
                    """;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);

            rs = ps.executeQuery();

            EmployeeMapper mapper = new EmployeeMapper();
            if(rs.next()) {
                return mapper.buildEmployee(rs);
            }

            return null;
        } catch (Exception ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception e) {
                // do nothing
            }
            throw ex;
        } finally {
            if(rs != null) {
                rs.close();
            }

            if(ps != null) {
                ps.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    private static class EmployeeMapper {
        public Employee buildEmployee(ResultSet rs) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String address = rs.getString("address");

            return new Employee(id, name, email, phone, address);
        }
    }
}
