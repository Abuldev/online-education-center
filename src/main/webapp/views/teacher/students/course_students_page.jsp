<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Students </title>
  <jsp:include page="../../fragments/head.jsp"></jsp:include>

</head>
<body>

<jsp:include page="../../fragments/navbar.jsp"></jsp:include>
<jsp:include page="../../fragments/teacher_cabinet_navbar.jsp"></jsp:include>


<section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row">
      <div class="col">
        <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
          <ol class="breadcrumb mb-0">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item"><a href="/profile/teacher/my_courses"> My courses </a></li>
            <li class="breadcrumb-item"><a href="/profile/teacher/my_courses"> Course </a></li>
            <li class="breadcrumb-item"><a href="/teacher/course/lessons?courseid=${course.id}"> Lessons </a></li>
            <li class="breadcrumb-item active" aria-current="page"> Lesson </li>
          </ol>
        </nav>
      </div>
    </div>

    <div class="row">
      <div class="col-lg-12">
        <div class="card mb-6">
          <div class="card-body text-center">
            <h1 class="my-6"> ${course.name} </h1>
            <h3 class="my-6"> ${lesson} </h3>
          </div>
        </div>

      </div>
      <div class="list-group list-group-light">

        <c:forEach items="${lessons}" var="lesson">

          <ol>
            <br>
            <br>
            <li>
              <a href="" > ${lesson.name} </a>
            </li>
          </ol>


        </c:forEach>

      </div>
    </div>
  </div>
</section>


<jsp:include page="../../fragments/js.jsp"></jsp:include>



</body>
</html>
