<%--
  Created by IntelliJ IDEA.
  User: muhammadqodir
  Date: 02/08/22
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/profile/teacher"> ${user.fullname.firstName} </a>
    <button
            class="navbar-toggler"
            type="button"
            data-mdb-toggle="collapse"
            data-mdb-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/profile/my_courses"> My courses </a>
        <a class="nav-link" href="/online/courses"> All courses </a>
        <a class="nav-link" href="/profile/teacher/settings"> Settings </a>
      </div>
    </div>
  </div>
</nav>
