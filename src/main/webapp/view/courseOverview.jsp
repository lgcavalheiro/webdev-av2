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
    <jsp:include page="teacherHeader.jsp"></jsp:include>
    <div id="request-status">
      <c:if test="${rowsAffected != null && header.referer.contains('courseOverview')}">
        <c:choose>
          <c:when test="${rowsAffected > 0}">
            <p><c:out value="Transação concluída (${rowsAffected} registro(s) afetados)." /></p>
          </c:when>
          <c:otherwise>
            <p><c:out value="Transação não concluída (0 registros afetados)." /></p>
          </c:otherwise>
        </c:choose>
      </c:if>
    </div>
    <c:forEach items="${studentList}" var="el">
      <li class="grade-item">
        <c:set var="grade" value="${el.getGrades().get(0)}" />
        <jsp:include page="gradeTableEdit.jsp">
          <jsp:param name="studentId" value="${el.getId()}" />
          <jsp:param name="courseId" value="${courseId}" />
          <jsp:param name="studentName" value="${el.getName()}" />
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
  </body>
</html>
