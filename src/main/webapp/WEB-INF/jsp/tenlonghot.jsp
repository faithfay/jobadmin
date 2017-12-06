<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>天瓏圖書排行榜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <c:set var="urlpath" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" type="text/css" href="${urlpath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${urlpath}/css/style.css">
    <script src="${urlpath}/js/jquery-3.2.1.min.js"></script>
    <script src="${urlpath}/js/popper.min.js"></script>
    <script src="${urlpath}/js/bootstrap.js"></script>

    <script type="text/javascript">
        $().ready(function(){
            $.ajax({
                type: "get",
                url: "${urlpath}/api/tenlong/lists/${hotalias}",
                success: function(result){
                    var res = result.list;
                    $.each(res,function(index,data) {
                        var cardhtml = $(
                        '<div class="card bg-dark">' +
                        '<a href="' + data.bookurl + '" target="tenlong">' +
                        '<img class="card-img-top img-thumbnail" src="' + data.imgurl + '" title="' + data.bookname + '">' +
                        '</a>' +
                        '<div class="card-footer">' +
                        '<h4 class="text-white">$' + data.sell + '</h4>' +
                        '</div>');
                        cardhtml.appendTo('#hotlist');
                    });
                }
            });
        })
    </script>
    <style>
        main{
            margin: 10px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-white sticky-top">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="pagination navbar-nav mr-auto">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main class="container-fluid">
    <div class="card-columns" id="hotlist"></div>
</main>
</body>
</html>
