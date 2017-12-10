<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>偽!天瓏圖書查詢</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <c:set var="urlpath" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" type="text/css" href="${urlpath}/css/bootstrap.min.css">
    <script src="${urlpath}/js/jquery-3.2.1.min.js"></script>
    <script src="${urlpath}/js/popper.min.js"></script>
    <script src="${urlpath}/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-top bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <a href="${urlpath}/tenlong/zhtop" class="nav-link text-primary">圖列模式</a>
        <a href="${urlpath}/tenlonglist/zh" class="nav-link text-primary">繁體書</a>
        <a href="${urlpath}/tenlonglist/zhtop" class="nav-link text-primary">繁體書TOP</a>
        <a href="${urlpath}/tenlonglist/cn" class="nav-link text-primary">簡體書</a>
        <a href="${urlpath}/tenlonglist/cntop" class="nav-link text-primary">簡體書Top</a>

        <ul class="pagination navbar-nav mr-auto pagination-sm" id="pagemenu">
            <li class="page-item"><a class="page-link" href="#">First</a></li>
            <c:forEach var="p" items="${tenlongs.navigatepageNums}">
                <%--分業壞掉 當查詢後結果不正確--%>
                <li class="page-item"><a class="page-link" href="${urlpath}/tenlonglist/${hotalias}?pg=${p}<c:if test="${qs != null && '' != qa}">&qs=${qs}</c:if>">${p}</a></li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="#">Last</a></li>
        </ul>
    </div>
</nav>
<main class="container">
    <h1 class="text-center m-3">偽!天瓏圖書查詢</h1>
    <form class="form my-2 my-lg-0" method="post">
        <div class="input-group my-3">
            <input class="form-control form-control-lg" type="search" name="qs" placeholder="簡易關鍵字">
        </div>
    </form>
    <section>
        <table class="table table-hover table-sm table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th scope="col">售價</th>
                    <th scope="col" class="text-center">書名</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${tenlongs.list}" var="list">
                <tr>
                    <td>$${list.sell}</td>
                    <td><a class="text-info" href="${list.bookurl}" target="tenlong">${list.bookname}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
