<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>偽!天瓏圖書查詢</title>
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
            ajaxCall("${urlpath}/api/tenlong/lists/${hotalias}",'','get');

            //查詢框按下ENTER事件
            $('input[type=search]').keyup(function(e){
                var code = (e.keyCode ? e.keyCode : e.which);
                if(code == 13){
                    queryBook(this.value);
                }
            })
        })
        function queryBook(queryStr){
            var queryString = $('input[type=search]').val();
            queryString = clearString(queryString);
            if(queryString.length > 0){
                //判斷分頁連結
                $('input[name=querystatus]').val(queryString);
                queryString = 'qs=' + queryString + '&pg=1';
                ajaxCall("${urlpath}/api/tenlong/query/${hotalias}",queryString,'post');
            }
            //查完清空輸入框
            $('input[type=search]').val('');
        }
        //CALL AJAX
        function ajaxCall(apiurl,param,apitype){
            $.ajax({
                type: apitype,
                url:  apiurl,
                data: param,
                success: function(result){
                    if(result.list.length > 0){
                        //清空內容
                        $('#hotlist').empty();
                        //新增內容HTML
                        handleContent(result);

                        //清空分頁並重新新增
                        $('#pagemenu').empty();
                        loadPage(result);
                    }
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
            var ptag = $('input[name=querystatus]').val();
            //透過tag判斷是不是查詢後,是的話就改變ajax呼叫的網址
            if('' != ptag && ptag.length > 0 ){
                ptag = ptag + '&pg=' + nowPage;
                ajaxCall("${urlpath}/api/tenlong/query/${hotalias}",ptag,'post');
            }else{
                ajaxCall("${urlpath}/api/tenlong/lists/${hotalias}",'pg=' + nowPage,'get');
            }
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
                $('<li class="page-item disabled"><a class="page-link" href="#" onclick="chgPage(1)">First</a></li>').appendTo('#pagemenu');
            }else{
                $('<li class="page-item"><a class="page-link" href="#" onclick="chgPage(1)">First</a></li>').appendTo('#pagemenu');
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
                $('<li class="page-item disabled"><a class="page-link" href="#" onclick="chgPage(' + datas.pages + ')">Last</a></li>').appendTo('#pagemenu');
            }else{
                $('<li class="page-item"><a class="page-link" href="#" onclick="chgPage(' + datas.pages + ')">Last</a></li>').appendTo('#pagemenu');
            }
        }
        //過濾字串
        function clearString(s){
            var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）&;|{}【】‘；：”“'。，、？]")
            var rs = "";
            for (var i = 0; i < s.length; i++) {
                rs = rs + s.substr(i, 1).replace(pattern, '');
            }
            return rs.replace(/\s+/g,'');
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
        <a href="${urlpath}/tenlong/zh" class="nav-link text-primary">繁體書</a>
        <a href="${urlpath}/tenlong/zhtop" class="nav-link text-primary">繁體書TOP</a>
        <a href="${urlpath}/tenlong/cn" class="nav-link text-primary">簡體書</a>
        <a href="${urlpath}/tenlong/cntop" class="nav-link text-primary">簡體書Top</a>
        <div class="form-inline my-2 my-lg-0">
            <input class="form-control form-control-sm" type="search" placeholder="簡單關鍵字" aria-label="Search">
            <input type="hidden" name="querystatus">
        </div>
    </div>
</nav>
</body>
</html>