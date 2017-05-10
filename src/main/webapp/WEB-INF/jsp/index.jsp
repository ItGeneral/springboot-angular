<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="flashingBuyApp">
<head>
    <title ng-bind="title">flashingBuy</title>
    <base href="/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="container" ng-view></div>
</body>

    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.6.4/jquery.min.js"></script>

    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.js"></script>
    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
    <script src="https://cdn.bootcss.com/angular.js/1.4.6/angular-route.min.js"></script>

    <script type="text/javascript" src="/static/js/app.js"></script>
    <script type="text/javascript" src="/static/js/service/httpService.js"></script>
    <script type="text/javascript" src="/static/js/controller/TestController.js"></script>

</html>