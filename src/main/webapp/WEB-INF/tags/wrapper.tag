<%@tag description="Page Wrapper Tag" pageEncoding="UTF-8"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${title}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/view/asset/favicon.ico" type="image/x-icon" />
  </head>
  <body>
    <jsp:doBody />
    <footer>
      <p>
        Copyleft (ɔ) Lucas Guimarães Cavalheiro - 2012200347 &amp; Wallace Arruda de Macedo -
        2013101787
      </p>
    </footer>
  </body>
</html>
