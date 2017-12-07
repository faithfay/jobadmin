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
            ajaxCall('');
        })

        //CALL AJAX
        function ajaxCall(param){
            $.ajax({
                type: "get",
                url:  "${urlpath}/api/tenlong/lists/${hotalias}",
                data: param,
                success: function(result){
                    //清空內容
                    $('#hotlist').empty();
                    //新增內容HTML
                    handleContent(result);

                    //清空分頁並重新新增
                    $('#pagemenu').empty();
                    loadPage(result);
                }
            });
        }
        //HANDLE CONTENT
        function handleContent(datas){
            var res = datas.list;
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
        //CHANGE PAGE
        function chgPage(nowPage){
            ajaxCall('pg=' + nowPage);
        }
        //HANDLE FIRST PAGE
        function loadPage(datas){
            firstPage(datas);
            loopPage(datas);
            lastPAge(datas);
        }
        //HANDLE FIRST PAGE
        function firstPage(datas){
            if(datas.isFirstPage){
                $('<li class="page-item disabled"><a class="page-link" href="#" onclick="chgPage(' + datas.navigateFirstPage + ')">First</a></li>').appendTo('#pagemenu');
            }else{
                $('<li class="page-item"><a class="page-link" href="#" onclick="chgPage(' + datas.navigateFirstPage + ')">First</a></li>').appendTo('#pagemenu');
            }
        }
        //HANDLE LOOP PAGES
        function loopPage(datas){
            var pgs = datas.navigatepageNums;
            $.each(pgs,function(index,data) {
                if(datas.pageNum == data){
                    $('<li class="page-item active"><a class="page-link" href="#" onclick="chgPage(' + data + ')">' + data + '</a></li>').appendTo('#pagemenu');
                }else{
                    $('<li class="page-item"><a class="page-link" href="#" onclick="chgPage(' + data + ')">' + data + '</a></li>').appendTo('#pagemenu');
                }
            })
        }
        //HANDLE LAST PAGE
        function lastPAge(datas){
            if(datas.isLastPage){
                $('<li class="page-item disabled"><a class="page-link" href="#" onclick="chgPage(' + datas.navigateLastPage + ')">Last</a></li>').appendTo('#pagemenu');
            }else{
                $('<li class="page-item"><a class="page-link" href="#" onclick="chgPage(' + datas.navigateLastPage + ')">Last</a></li>').appendTo('#pagemenu');
            }
        }
    </script>
</head>
<body>
<main class="container-fluid">
    <div class="card-columns" id="hotlist"></div>
</main>

<nav class="navbar navbar-expand-lg navbar-light bg-white fixed-bottom sticky-top">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="pagination navbar-nav mr-auto pagination-sm" id="pagemenu">
        </ul>
        <a href="${urlpath}/tenlonghot/zhtop" class="nav-link text-primary">繁Top</a>
        <a href="${urlpath}/tenlonghot/cntop" class="nav-link text-primary">簡Top</a>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control form-control-sm" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-info my-2 my-sm-0 btn-sm" type="submit">Search</button>
        </form>
    </div>
</nav>
</body>
</html>