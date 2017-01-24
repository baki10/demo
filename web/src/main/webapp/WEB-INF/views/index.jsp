<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--css--%>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" />
    <%--js--%>
    <script src="<c:url value="/resources/js/angular.min.js" />"></script>
    <script src="<c:url value="/resources/js/app.js" />"></script>
</head>
<body ng-app="LunchCheck">
<div class="container" ng-controller="LunchCheckController">
    <h1>Lunch Checker</h1>

    <div class="form-group">
        <label for="lunch-menu">I do NOT consider an EMPTY item as an item towards to the count</label>
        <input id="lunch-menu" type="text" ng-model="menuList" ng-style="messageStyle"
               placeholder="list comma separated dishes you usually have for lunch"
               class="form-control">
    </div>
    <div class="form-group">
        <button class="btn btn-default" ng-click="check()">Check If Too Much</button>
    </div>
    <div class="form-group message">
        {{message}}
    </div>
</div>

</body>
</html>
