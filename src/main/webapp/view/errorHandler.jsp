<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SEAL - Ooops</title>
  </head>
  <body>
    <h1>Deu erro! Oops! :(</h1>
    <p>${pageContext.exception.message}</p>
    <a href=".">Voltar ao index.</a>
  </body>
</html>
