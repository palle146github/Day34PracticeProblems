package com.bridgelabz;

import java.util.*;
import java.sql.*;

public class EmployeePayoll {

    public static void normalStatement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate("update employee_payroll set salary = 240000 where name = 'Terissa'");
            System.out.println(count);

            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4) + " : " + resultSet.getDate(5) + " : " + resultSet.getString(6) + " : " + resultSet.getString(7) + " : " + resultSet.getString(8) + " : " + resultSet.getFloat(9) + " : " + resultSet.getFloat(10) + " : " + resultSet.getFloat(11) + " : " + resultSet.getFloat(12) + " : " + resultSet.getFloat(13));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void prepareStatement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
            PreparedStatement statement = connection.prepareStatement("select * from employee_payroll where name =?");
            statement.setString(1, "Terissa");
            int count = statement.executeUpdate("update employee_payroll set salary = 3000000.00 where name = 'Terissa'");
            System.out.println(count);

            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4) + " : " + resultSet.getDate(5) + " : " + resultSet.getString(6) + " : " + resultSet.getString(7) + " : " + resultSet.getString(8) + " : " + resultSet.getFloat(9) + " : " + resultSet.getFloat(10) + " : " + resultSet.getFloat(11) + " : " + resultSet.getFloat(12) + " : " + resultSet.getFloat(13));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void employeeJoinedInparticularDate() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
            PreparedStatement statement = connection.prepareStatement("select * from employee_payroll where name =?");
            statement.setString(1, "Terissa");

            ResultSet resultSet = statement.executeQuery("select * from employee_payroll where start between cast('2010-12-06' as date) and cast('2020-06-12' as date)");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4) + " : " + resultSet.getDate(5) + " : " + resultSet.getString(6) + " : " + resultSet.getString(7) + " : " + resultSet.getString(8) + " : " + resultSet.getFloat(9) + " : " + resultSet.getFloat(10) + " : " + resultSet.getFloat(11) + " : " + resultSet.getFloat(12) + " : " + resultSet.getFloat(13));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sumAvgMinMaxCount() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "d11cpk1211");
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT " +
                            "    gender, " +
                            "    COUNT(*) AS total_employees, " +
                            "    SUM(salary) AS total_salary, " +
                            "    AVG(salary) AS average_salary, " +
                            "    MIN(salary) AS min_salary, " +
                            "    MAX(salary) AS max_salary " +
                            "FROM employee_payroll " +
                            "GROUP BY gender");

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Process the results
            while (rs.next()) {
                String gender = rs.getString("gender");
                double totalEmployees = rs.getDouble("total_employees");
                double totalSalary = rs.getDouble("total_salary");
                double averageSalary = rs.getDouble("average_salary");
                double minimumSalary = rs.getDouble("min_salary");
                double maximumSalary = rs.getDouble("max_salary");

                // Print the results
                System.out.println(gender + " Total Employess: " + totalEmployees);
                System.out.println(gender + " Total Salary: " + totalSalary);
                System.out.println(gender + " Average  Salary: " + averageSalary);
                System.out.println(gender + " Minimum Salary: " + minimumSalary);
                System.out.println(gender + " Maximum Salary: " + maximumSalary);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        public static void main(String[] args) throws EmployeePayRollException {
        normalStatement();
        prepareStatement();
        employeeJoinedInparticularDate();
        sumAvgMinMaxCount();
    }
}
