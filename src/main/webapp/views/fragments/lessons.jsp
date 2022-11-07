<div class="row">
  <div class="col-lg-12">
    <div class="card mb-6">
      <div class="card-body text-center">
        <h1 class="my-6"> ${course.name} </h1>
        <h3 class="my-6"> ${num_of_lessons} lessons </h3>
      </div>
    </div>

  </div>
  <div class="list-group list-group-light">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach items="${lessons}" var="lesson">

      <ol>
        <br>
        <br>
        <h3>
        <li>
         <a href="/enter/lesson?lessonid=${lesson.id}" > ${lesson.name} </a>
          tasks: 1  video: 1
        </li>
        </h3>
      </ol>


    </c:forEach>

  </div>
</div>