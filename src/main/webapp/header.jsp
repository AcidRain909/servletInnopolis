<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="../resources/style.css" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <header class="header">
        <div class="header-title">
        <H1>Система учёта успеваемости студентов</H1>
        </div>
                <%if (request.getSession().getAttribute("login") != null) {%>
        <div class="header-logout">
            <%=(String) request.getSession().getAttribute("name")%>&nbsp;
            <a href="${pageContext.request.contextPath}/login?action=logout">Выйти</a>
        </div>
        <%}%>
    </header><!-- .header-->
    <div class="middle">
