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
    <script src="https://kit.fontawesome.com/3e899215ad.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <jsp:doBody />
    <footer>
      <p>
        Copyleft (ɔ) Lucas Guimarães Cavalheiro - 2012200347 <i class="fa fa-graduation-cap" aria-hidden="true"></i> &amp; Wallace Arruda de Macedo -
        2013101787 <i class="fa fa-graduation-cap" aria-hidden="true"></i>
      </p>
    </footer>
  </body>
</html>
