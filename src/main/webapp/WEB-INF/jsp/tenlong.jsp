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
    <script src="${urlpath}/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $().ready(function(){
            //頁面載入後撈資料
            ajaxCall("${urlpath}/api/tenlong/lists/${hotalias}",'');

            //查詢框按下ENTER事件
            $('input[type=search]').keyup(function(e){
                var code = (e.keyCode ? e.keyCode : e.which);
                if(code == 13){
                    queryBook(this.value);
                }
            })
        });

        //CALL AJAX
        function ajaxCall(apiurl,param){
            $.ajax({
                type: 'get',
                url:  apiurl,
                data: param,
                success: function(result){
                    //有資料才顯示內容
                    if(result.list.length > 0){
                        //清空內容
                        $('#hotlist').empty();
                        //新增內容HTML
                        handleContent(result);
                        //清空分頁並重新新增
                        $('#pgmenu').empty();
                        loadPage(result);
                    }
                }
            });
        }

        //CHANGE PAGE
        function chgPage(nowPage){
            var ptag = $('input[name=querystatus]').val();
            var param = '';
            //透過tag判斷是不是查詢後,是的話就改變ajax呼叫的網址
            if('' != ptag && ptag.length > 0 ){
                param = 'qs=' + ptag + '&pg=' + nowPage;
                ajaxCall("${urlpath}/api/tenlong/query/${hotalias}",param);
            }else{
                ajaxCall("${urlpath}/api/tenlong/lists/${hotalias}",'pg=' + nowPage);
            }
        }

        //按下輸入框查詢
        function queryBook(queryStr){
            var queryString = $('input[type=search]').val();
            queryString = clearString(queryString);
            if(queryString.length > 0){
                //判斷分頁連結
                $('input[name=querystatus]').val(queryString);
                queryString = 'qs=' + queryString + '&pg=1';
                //發動查詢
                ajaxCall("${urlpath}/api/tenlong/query/${hotalias}",queryString);
            }
            //查完清空輸入框
            $('input[type=search]').val('');
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

        //HANDLE MENU
        function loadPage(datas){
            staticpg();
            loopPage(datas);
        }

        function staticpg(){
            $('<li class="nav-item"><a href="${urlpath}/tenlonglist/zhtop" class="nav-link">清單模式</a></li>').appendTo('#pgmenu');
            $('<li class="nav-item"><a href="${urlpath}/tenlong/zh" class="nav-link">繁體書</a></li>').appendTo('#pgmenu');
            $('<li class="nav-item"><a href="${urlpath}/tenlong/zhtop" class="nav-link">繁體書TOP</a></li>').appendTo('#pgmenu');
            $('<li class="nav-item"><a href="${urlpath}/tenlong/cn" class="nav-link">簡體書</a></li>').appendTo('#pgmenu');
            $('<li class="nav-item"><a href="${urlpath}/tenlong/cntop" class="nav-link">簡體書Top</a></li>').appendTo('#pgmenu');
        }

        function firstAndLastPage(datas){
            if(datas.navigateFirstPage != 0 && datas.isFirstPage == false){
                $('<a id="firstpg" class="dropdown-item" href="#" onclick="chgPage(1)">First</a>').appendTo('#looppg');
            }

            if(datas.navigateLastPage != 0 && datas.isLastPage == false){
                $('<a id="lastpg" class="dropdown-item" href="#" onclick="chgPage(' + datas.pages + ')">Last</a>').appendTo('#looppg');
            }
        }

        //HANDLE LOOP PAGES
        function loopPage(datas){
            var pgs = datas.navigatepageNums;
            var zero = '';

            if(datas.total > 0){
                $('<li class="nav-item dropdown" id="pgdropdown"></li>').appendTo('#pgmenu');
                $('<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">分頁</a>').appendTo('#pgdropdown');
                $('<div class="dropdown-menu" aria-labelledby="navbarDropdown" id="looppg"></div>').appendTo('#pgdropdown');

                $.each(pgs,function(index,data) {

                    if(data > 0 && data <= 9){
                        zero = '00';
                    }

                    if(data > 9 && data <= 99){
                        zero = '0';
                    }

                    if(datas.pageNum == data){
                        $('<a class="dropdown-item active" href="#" onclick="chgPage(' + data + ')">' + zero + data + '</a>').appendTo('#looppg');
                    }else{
                        $('<a class="dropdown-item" href="#" onclick="chgPage(' + data + ')">' + zero + data + '</a>').appendTo('#looppg');
                    }
                })
                $('<div class="dropdown-divider"></div>').appendTo('#looppg');
                firstAndLastPage(datas);
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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto" id="pgmenu">
            <li class="nav-item"><a href="${urlpath}/tenlonglist/zhtop" class="nav-link">清單模式</a></li>
            <li class="nav-item"><a href="${urlpath}/tenlong/zh" class="nav-link">繁體書</a></li>
            <li class="nav-item"><a href="${urlpath}/tenlong/zhtop" class="nav-link">繁體書TOP</a></li>
            <li class="nav-item"><a href="${urlpath}/tenlong/cn" class="nav-link">簡體書</a></li>
            <li class="nav-item"><a href="${urlpath}/tenlong/cntop" class="nav-link">簡體書Top</a></li>
        </ul>
        <div class="form-inline my-2 my-lg-0">
            <input class="form-control form-control-sm" type="search" placeholder="簡單關鍵字" aria-label="Search">
            <input type="hidden" name="querystatus">
        </div>
    </div>
</nav>

<main class="container-fluid">
    <div class="card-columns" id="hotlist"></div>
</main>
</body>
</html>