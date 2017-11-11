<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>外幣匯率</title>
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
            //預設載入日圓
            var chart = c3.generate({
                bindto: '#chart',
                data: {
                    mimeType: 'json',
                    url:"${urlpath}/json/rate/top",
                    keys: {x:'checkdate',value: ['rate']},
                    names:{'rate':'匯率'},
                    selection: {enabled: true},
                    type: 'spline'
                },
                axis: {
                    x: {type: 'category'},
                    y: {
                        tick: {
                            format: d3.format('.5f')
                        }
                    }
                },
                grid: {
                    y: {show: true}
                },
                onresized: function(){
                    this.selectChart.style('max-height', 'none');
                }
            });

            //
            $('.nav-item a').on('click',function(){
                $('#h_title').text($(this).text());
                chart.load({
                    mimeType: 'json',
                    url:"${urlpath}/json/rate/top?rn=" + $(this).text(),
                    keys: {x:'checkdate',value: ['rate']},
                    names:{'rate': $(this).text() + '匯率'},
                    unload: true
                });
            });
        });
    </script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <a class="navbar-brand" href="${urlpath}">外幣匯率</a>
    <div id="ul-menu" class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <c:forEach items="${rname}" var="rate_name">
               <li class="nav-item">
                    <a class="nav-link text-warning" href="#">${rate_name}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</nav>
<section class="container-fluid">
    <div class="row">
        <div class="col">
            <h1 id="h_title" class="text-center">日圓</h1>
        </div>
    </div>
</section>
<section class="container-fluid">
    <article class="row justify-content-center">
        <div class="col-12">
            <div id="chart" class="h-50"></div>
        </div>
    </article>
</section>
</body>
</html>
