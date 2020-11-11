<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="SEAL - Home Aluno">
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
          <jsp:include page="fragment/gradeTable.jsp">
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
</t:wrapper>
