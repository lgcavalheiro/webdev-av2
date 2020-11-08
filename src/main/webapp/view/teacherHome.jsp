<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home - Professor</title>
    <link rel="stylesheet" href="view/teacherHome.css" />
    <link rel="shortcut icon" href="view/favicon.ico" type="image/x-icon" />
  </head>
  <body>
    <jsp:include page="teacherHeader.jsp"></jsp:include>
    <div id="course-list">
      <ul>
        <c:forEach items="${teacher.getCourses()}" var="el">
          <li>
            <a
              href="/courseOverview?courseId=${el.getId()}&classNumber=${el.getClassNumber()}&name=${el.getName()}"
              >${el.getClassNumber()} - ${el.getName()}</a
            >
          </li>
        </c:forEach>
      </ul>
    </div>
  </body>
</html>
