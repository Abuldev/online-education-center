<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Objects" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"> SABR </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/"> Home <span class="sr-only">(current)</span></a>
            </li>

            <c:choose>
                <c:when test="${loggedIn}">
                    <li class="nav-item" style="text-align: right">
                        <a class="nav-link" href="/auth/login" style="text-align: center"> Login </a>
                    </li>

                    <li class="nav-item" style="text-align: right">
                        <a class="nav-link" href="/auth/register" style="text-align: center"> Register </a>
                    </li>
                </c:when>
                <c:otherwise>

                    <li class="nav-item" style="text-align: right">
                        <a class="nav-link" href="/my_cabinet" style="text-align: center"> My Cabinet </a>
                    </li>

                    <li class="nav-item" style="text-align: right">
                        <a class="nav-link" href="/auth/logout" style="text-align: center"> Log out </a>
                    </li>
                </c:otherwise>
            </c:choose>

            <div class="btn-group">
                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    More
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/aboutus"> About us </a>
                    <a class="dropdown-item" href="/online/courses"> Online courses </a>
                    <a class="dropdown-item" href="/offline/courses"> Offline courses </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#"> Others </a>
                    </div>

                </div>
            </div>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>




















