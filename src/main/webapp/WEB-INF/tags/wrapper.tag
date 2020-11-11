<%@tag description="Page Wrapper Tag" pageEncoding="UTF-8"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${title}</title>
    <link rel="stylesheet" href="/styles.css" />
    <link rel="shortcut icon" href="view/asset/favicon.ico" type="image/x-icon" />
  </head>
  <body>
    <jsp:doBody />
    <footer>
      <p>Copyleft C Lucas &amp; Wallace</p>
    </footer>
  </body>
</html>
