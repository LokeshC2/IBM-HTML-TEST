package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchDepartmentController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String branches = getInitParameter("Branches");
    List<String> branchList = List.of(branches.split(","));
    resp.setContentType("text/html");
    resp.getWriter().println("<select name='branch' hx-post='fetchDepartments' hx-target='#dept' hx-swap='innerHTML'>");
    resp.getWriter().println("<option value='' hidden>Select Branch</option>");
    for (String branch : branchList) {
      resp.getWriter().println("<option>" + branch + "</option>");
    }
    resp.getWriter().println("</select>");
    resp.setStatus(HttpServletResponse.SC_OK);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String branch = req.getParameter("branch");

    String branches = getInitParameter("Branches");
    List<String> branchList = List.of(branches.split(","));
    if (!branchList.contains(branch)) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }

    String departments = getInitParameter(branch);
    List<String> departmentList = List.of(departments.split(","));
    
    resp.setContentType("text/html");
    resp.getWriter().println("<option value='' hidden>Select Department</option>");
    for (String department : departmentList) {
      resp.getWriter().println("<option>" + department + "</option>");
    }
    resp.setStatus(HttpServletResponse.SC_OK);
  }
}
