<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello World</title>
</head>
   <body>
   달라졌나???
   김가루를 밥위에 얹어먹는다
   현미밥을 먹는다
   동가스를 먹는다 
    <section class="content">
      <tiles:insertAttribute name="body"/> <!-- body -->

    </section>
  </body>
</html>