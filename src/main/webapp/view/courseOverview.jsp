<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SEAL - Notas de ${classNumber} - ${courseName}</title>
    <link rel="shortcut icon" href="view/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="view/courseOverview.css" />
  </head>
  <body>
    <c:forEach items="${studentList}" var="el">
      <li>
        ${el.getId()} - ${el.getName()}
        <c:set var="grade" value="${el.getGrades().get(0)}" />
        <c:import url="gradeTable.jsp">
          <c:param name="examAv1" value="${grade.getExamAv1()}" />
          <c:param name="examAv2" value="${grade.getExamAv2()}" />
          <c:param name="examAv3" value="${grade.getExamAv3()}" />
          <c:param name="assignmentAv1" value="${grade.getAssignmentAv1()}" />
          <c:param name="assignmentAv2" value="${grade.getAssignmentAv2()}" />
          <c:param name="finalGrade" value="${grade.getFinalGrade()}" />
          <c:param name="isApproved" value="${grade.getIsApproved()}" />
          <c:param name="updateTimestamp" value="${grade.getUpdateTimestamp().toString()}" />
        </c:import>
      </li>
    </c:forEach>
  </body>
</html>
