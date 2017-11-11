<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>黃金存摺</title>
    <c:set var="urlpath" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" type="text/css" href="${urlpath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${urlpath}/css/c3.min.css">

    <script src="${urlpath}/js/jquery-3.2.1.min.js"></script>
    <script src="${urlpath}/js/popper.min.js"></script>
    <script src="${urlpath}/js/bootstrap.js"></script>

    <script src="${urlpath}/js/d3.min.js"></script>
    <script src="${urlpath}/js/c3.min.js"></script>

    <script type="application/javascript">
        $().ready(function(){
            //頁面載入預設顯示最低買進價
            var chart = c3.generate({
                bindto: '#chart',
                data: {
                    mimeType: 'json',
                    url:"${urlpath}/json/gold/topbuy",
                    keys: {x:'checkDate',value: ['buy']},
                    names:{'buy':'買進黃金'},
                    //顯示點選的點
                    selection: {enabled: true}
                },
                axis: {
                    //X軸下面的分類
                    x: {type: 'category'}
                },
                grid: {
                    //秀格線
                    y: {show: true}
                },
                onresized: function(){
                    //假如瀏覽器縮小又變大時,高度不會恢復成正常大小
                    //增加這個onresized事件可以解決
                    this.selectChart.style('max-height', 'none');
                }
            });

            //月份詳細資料
            $('#month-detail').on('click','button',function(){
                var mm = $(this).text();
                chart.load({
                    mimeType: 'json',
                    url:"${urlpath}/json/gold/month/" + mm,
                    //定義X軸的值,線有兩條,buy,sell
                    keys: {x:'checkDate',value: ['buy','sell']},
                    //定義線的名稱
                    names:{'buy':'黃金買進','sell':'賣出黃金'},
                    unload: ['buy','sell']
                });
            });

            //賣出排行
            $("#a-topsell").click(function(){
                chart.load({
                    mimeType: 'json',
                    url:"${urlpath}/json/gold/topsell",
                    keys: {x:'checkDate',value: ['sell']},
                    names:{'sell':'賣出黃金'},
                    unload: ['buy']
                });
            });

            //選單超連結改變狀態
            $("#ul-menu a").on('click',function(){
                $("#ul-menu a").parent().removeClass('active');
                $(this).parent().addClass('active');
            });

            //當按下年份連結時事件
            $("#ul-menu button").on('click',function(){
                var dynamicID = $(this).text();

                //第一次都沒有HTML進入
                if ($('#month-detail').is(':empty')){
                    //動態產生月份按鈕群組
                    var btsDiv = $('<div role="group" aria-label="Month Detail"></div>');
                    btsDiv.addClass('btn-group');
                    btsDiv.addClass('m-1');
                    btsDiv.attr('id',dynamicID);
                    btsDiv.appendTo($('#month-detail'));
                    //得到月份所有資料
                    $.ajax({
                        type: "post",
                        url: "json/gold/" + dynamicID,
                        success: function(result){
                            $.each(result,function(index,data) {
                                $('<button type="button" class="btn btn-info"></button>').text(data).appendTo(btsDiv);
                            });
                        }
                    });
                }else{
                    //判斷是不是同一個按鈕案的,不是就把按鈕群組清除重新去撈月份
                    if($('#month-detail > div').attr('id') != $(this).text()){
                        //清除HTML
                        $('#month-detail > div').empty();
                        //重置CSS讓HTML顯示
                        $('#month-detail > div').removeAttr('style');
                        //將按鈕群組ID改成現在按的按鈕年份
                        $('#month-detail > div').attr('id',$(this).text());
                        $.ajax({
                            type: "post",
                            url: "json/gold/" + dynamicID,
                            success: function(result){
                                $.each(result,function(index,data) {
                                    $('<button type="button" class="btn btn-info"></button>').text(data).appendTo($('#month-detail > div'));
                                });
                            }
                        });
                    }else{
                        //相同就隱藏或顯示
                        $('#month-detail > div').toggle();
                    }
                }
            });
            //格線顯示/隱藏
            $("#bt-hide-line").click(function(){
                if($('.c3-ygrids').css('display') == 'none'){
                    $('.c3-ygrids').show();
                }else{
                    $('.c3-ygrids').hide();
                }
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${urlpath}">黃金存摺</a>
    <div id="ul-menu" class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${urlpath}/gold">買進排行</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" id="a-topsell">賣出排行</a>
            </li>
            <li class="nav-item">
                <div class="btn-group" role="group" aria-label="年份查詢">
                    <c:forEach items="${dyear}" var="yyyy">
                        <button type="button" class="btn btn-secondary">${yyyy}</button>
                    </c:forEach>
                </div>
            </li>
        </ul>
    </div>
</nav>
<header class="container m-3">
    <div class="row">
        <div class="col-12" id="month-detail"></div>
    </div>
</header>
<section class="container-fluid">
    <article class="row justify-content-center">
        <div class="col-12">
            <div id="chart" class="h-75"></div>
        </div>
    </article>
</section>
<section class="container">
    <div class="row">
        <div class="col-12">
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" id="bt-hide-line" class="btn btn-secondary">隱藏格線</button>
            </div>
        </div>
    </div>
</section>
</body>
</html>
