<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>黃金存摺</title>
    <c:set var="urlpath" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" type="text/css" href="${urlpath}/css/bootstrap.min.css">

    <script src="${urlpath}/js/jquery-3.2.1.min.js"></script>
    <script src="${urlpath}/js/popper.min.js"></script>
    <script src="${urlpath}/js/bootstrap.js"></script>

    <style>
        .customer-header{
            min-height: 100vh;
        }
    </style>
</head>
<body>
<header class="container-fluid">
    <div class="row">
        <div class="col-12 customer-header d-flex justify-content-center align-items-center">
            <div class="text-center">
                <h1 class="h1">Job Admin</h1>
                <div class="btn-group" role="button" aria-label="JOB ADMIN">
                    <a class="btn btn-info btn-lg" href="gold">黃金存摺</a>
                    <a class="btn btn-info btn-lg" href="rate">外幣排行</a>
                    <a class="btn btn-info btn-lg" href="rate">股票監控</a>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
</html>
