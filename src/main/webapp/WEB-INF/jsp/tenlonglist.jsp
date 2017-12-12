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

    <script>
        $().ready(function(){
            //滑鼠經過書讓字變大
            $('#bookcontent a').mouseover(function(){
               $(this).addClass('h2');
            });

            //滑鼠離開後恢復字體
            $('#bookcontent a').mouseout(function(){
                $(this).removeClass('h2');
            });

            //輸入框值設到隱藏框
            $('#queryForm').submit(function(){
                $('input[name=qs]').attr('value',$('input[name=qq]').val());
            });

            //當按分頁連結,如果隱藏框有值就加上參數
            $('.page-link').click(function(){
                var tag = $('input[name=qs]').val();
                var hreftag = $(this).attr('href');
                if(tag != null && '' != tag){
                    $(this).attr('href',hreftag + '&qs=' + tag);
                }
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a href="${urlpath}/tenlong/zhtop" class="nav-link">圖列模式</a>
            </li>
            <li class="nav-item">
                <a href="${urlpath}/tenlonglist/zh" class="nav-link">繁體書</a>
            </li>
            <li class="nav-item">
                <a href="${urlpath}/tenlonglist/zhtop" class="nav-link">繁體書TOP</a>
            </li>
            <li class="nav-item">
                <a href="${urlpath}/tenlonglist/cn" class="nav-link">簡體書</a>
            </li>
            <li class="nav-item">
                <a href="${urlpath}/tenlonglist/cntop" class="nav-link">簡體書Top</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    分頁
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach var="p" items="${tenlongs.navigatepageNums}">
                        <a class="dropdown-item" href="${urlpath}/tenlonglist/${hotalias}?pg=${p}">
                            <c:if test="${p > 0 && p <=9}">00</c:if><c:if test="${p > 9 && p <=99}">0</c:if>${p}
                        </a>
                    </c:forEach>

                    <div class="dropdown-divider"></div>
                    <c:if test="${tenlongs.navigateFirstPage != 0 && tenlongs.isFirstPage == false}">
                        <a class="dropdown-item" href="${urlpath}/tenlonglist/${hotalias}?pg=1">First</a>
                    </c:if>
                    <c:if test="${tenlongs.navigateLastPage != 0 && tenlongs.isLastPage == false}">
                        <a class="dropdown-item" href="${urlpath}/tenlonglist/${hotalias}?pg=${tenlongs.pages}">Last</a>
                    </c:if>
                </div>
            </li>
        </ul>
    </div>
</nav>

<main class="container">
    <h1 class="text-center m-3">偽!天瓏圖書查詢</h1>

    <form id="queryForm" class="form my-2 my-lg-0" method="post" action="${urlpath}/tenlonglist/${hotalias}">
        <input class="form-control form-control-lg my-3" type="search" name="qq" placeholder="簡易關鍵字">
        <input type="hidden" name="qs" value="${qs}">
    </form>

    <section>
        <table class="table table-hover table-sm table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th scope="col">售價</th>
                    <th scope="col" class="text-center">書名</th>
                </tr>
            </thead>
            <tbody id="bookcontent">
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
