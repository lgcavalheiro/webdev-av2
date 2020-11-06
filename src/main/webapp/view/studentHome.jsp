<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SEAL - Home Aluno</title>
    <link rel="shortcut icon" href="view/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="view/studentHome.css" />
  </head>
  <body>
    <nav>
      <span id="user-info"
        >Olá aluno(a) ${student.getName()} - ${student.getId()} - Graduação em
        ${student.getDegree().getName()}
      </span>
      <a href="${pageContext.request.contextPath}/logout">Sair &DoubleRightArrow;</a>
    </nav>
    <div id="container">
      <ul>
        <c:forEach items="${student.getCourses()}" var="el">
          <li>
            ${el.getClassNumber()} - ${el.getName()}
            <c:set var="grade" value="${student.getGradeByCourseId(el.getId())}" />
            <jsp:include page="gradeTable.jsp">
              <jsp:param name="examAv1" value="${grade.getExamAv1()}" />
              <jsp:param name="examAv2" value="${grade.getExamAv2()}" />
              <jsp:param name="examAv3" value="${grade.getExamAv3()}" />
              <jsp:param name="assignmentAv1" value="${grade.getAssignmentAv1()}" />
              <jsp:param name="assignmentAv2" value="${grade.getAssignmentAv2()}" />
              <jsp:param name="finalGrade" value="${grade.getFinalGrade()}" />
              <jsp:param name="isApproved" value="${grade.getIsApproved()}" />
              <jsp:param name="updateTimestamp" value="${grade.getUpdateTimestamp().toString()}" />
            </jsp:include>
          </li>
        </c:forEach>
        <c:remove var="grade" />
      </ul>
    </div>
  </body>
</html>
