<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="SEAL - Home Professor">
  <jsp:include page="fragment/teacherHeader.jsp"></jsp:include>
  <div id="course-list">
    <h1>Minhas turmas <i class="fas fa-university"></i></h1>
    <ul>
      <c:forEach items="${teacher.getCourses()}" var="el">
        <li>
          <a
            href="${pageContext.request.contextPath}/courseOverview?courseId=${el.getId()}&classNumber=${el.getClassNumber()}&name=${el.getName()}"
            >${el.getClassNumber()} - ${el.getName()}</a
          >
        </li>
      </c:forEach>
    </ul>
  </div>
</t:wrapper>
