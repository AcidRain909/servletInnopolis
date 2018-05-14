<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Логин/пароль</title>
    <link href="../resources/style.css" rel="stylesheet">
</head>
<body>


<div class="login-page">
    <div class="login-error">
    <%=("authErr".equals(request.getParameter("errorMsg"))) ? "Неверное имя пользователя/пароль" : ""%>
    <%=("noAuth".equals(request.getParameter("errorMsg"))) ? "Вам необходимо авторизоваться" : ""%>
    </div>
        <div class="form">
        <form class="login-form" action="${pageContext.request.contextPath}/login" method="post">
            <input type="text" placeholder="login" name="userName"><BR>
            <input type="text" placeholder="password" name="userPassword"><BR>
            <button>Войти</button>
        </form>
    </div>
</div>


</body>
</html>
