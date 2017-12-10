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
            $('#queryForm').submit(function(){
                var iqk = $('input[name=qq]').val();
            //     if(iqk != null && iqk != ''){
            //         alert('a')
                    $('input[name=qs]').attr('value',iqk);
            //     }else{
            //         alert('b')
            //         $('input[name=qs]').attr('value','');
            //         alert($('input[name=qs]').attr('value'))
            //     }
            })

            var qstag = $('input[name=qs]').val();
            console.log('>',qstag)

            var pgtag = $('.page-item > a');
            $.each(pgtag,function(index,data) {
                if(qstag != null && qstag != ''){
                    $(data).attr('href',data.href + '&qs=' + qstag)
                }
            });

        });
    </script>
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

                <li class="page-item"><a class="page-link" href="${urlpath}/tenlonglist/${hotalias}?pg=${p}">${p}</a></li>
            </c:forEach>
            <li class="page-item"><a class="page-link" href="#">Last</a></li>
        </ul>
    </div>
</nav>
<main class="container">
    <h1 class="text-center m-3">偽!天瓏圖書查詢</h1>
    <form id="queryForm" class="form my-2 my-lg-0" method="post">
        <div class="input-group my-3">
            <%--分業壞掉 當查詢後結果不正確--%>
            <input class="form-control form-control-lg" type="search" name="qq" placeholder="簡易關鍵字">
            <input type="hidden" name="qs" value="${qs}">
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
