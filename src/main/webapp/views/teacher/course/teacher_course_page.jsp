<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title> Teacher Course page</title>
  <jsp:include page="../../fragments/head.jsp"></jsp:include>
</head>
<body>

<jsp:include page="../../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../fragments/teacher_course.jsp"></jsp:include>

<section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row">
      <div class="col">
        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
          <ol class="breadcrumb mb-0">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item"><a href="/profile/my_courses"> My courses </a> </li>
            <li class="breadcrumb-item active" aria-current="page"> Course </li>
          </ol>
        </nav>
      </div>
    </div>

   <jsp:include page="../../fragments/course_page.jsp"></jsp:include>

  </div>
</section>

<jsp:include page="../../fragments/js.jsp"></jsp:include>

</body>
</html>
