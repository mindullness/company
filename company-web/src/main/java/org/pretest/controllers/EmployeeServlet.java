package org.pretest.controllers;

import org.pretest.entities.Company;
import org.pretest.entities.Country;
import org.pretest.entities.Employee;
import org.pretest.enums.Action;
import org.pretest.services.EntityBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    @EJB
    EntityBean<Employee> employeeBean;
    @EJB
    EntityBean<Company> companyBean;
    @EJB
    EntityBean<Country> countryBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/insert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        employeeBean.setType(Employee.class);
//        companyBean.setType(Company.class);
        try {
            if (Action.SEARCH.toString().equalsIgnoreCase(action)) {
                Employee employee = employeeBean.getEntityById(req.getParameter("searchId"));
                req.setAttribute("result", employee);
                req.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
            } else if (Action.ADD.toString().equalsIgnoreCase(action)) {
                if (employeeBean.addEntity(add(req, resp))) {
                    resp.getWriter().write("Successfully!");
                } else {
                    req.getServletContext().getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
                }
            } else {

            }

        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext().getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
        }
    }

    private Employee add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        String empName = req.getParameter("empName");
        String comId = req.getParameter("comId");
        String comIdNew = req.getParameter("comIdNew");
        String comNameNew = req.getParameter("comNameNew");

        Set<Company> companies = new HashSet<>();

        String countryId = req.getParameter("countryId");
        String countryName = req.getParameter("countryName");
        Country country = new Country();
        country.setCountryId(countryId);
        country.setCountryName(countryName);

        if(!comIdNew.isEmpty() && !comNameNew.isEmpty()){
            Company newCompany = new Company();
            newCompany.setCompanyId(comIdNew);
            newCompany.setCompanyName(comNameNew);
            companyBean.addEntity(newCompany); // Database include company data
            companies.add(newCompany);
        }

        if(!comId.isEmpty()){
            Company company = companyBean.getEntityById(comId);
            companies.add(company);
        }

        Employee employee = new Employee(empId, empName, companies);
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        country.setEmployees(employees);
        countryBean.addEntity(country);

        return employee;
    }
}
