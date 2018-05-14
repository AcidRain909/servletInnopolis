<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="header.jsp" %>
<div class="dashbord-container">
<main class="content">

    <c1:if test="${fn:length(gradesList) lt 1}">
        <p>Оценки отсутствуют</p>
    </c1:if>

    <c1:if test="${fn:length(gradesList) gt 0}">

    <strong>Оценки </strong>
    <table class="grades">
    <tr>
    <td>ID записи</td>
    <td>Профессор</td>
    <td>Студент</td>
    <td>Предмет</td>
    <td>Оценка</td>
    </tr>

    <c1:forEach var="num" items="${gradesList}">
        <tr>
            <td>
                <p> ${num.getId()}</p>
            </td>
            <td>
                <p> ${num.getProfessorName()}</p>
            </td>
            <td>
                <p> ${num.getStudentName()}</p>
            </td>
            <td>
                <p> ${num.getSubjectName()}</p>
            </td>
            <td>
                <p> ${num.getRating()}</p>
            </td>
        </tr>
    </c1:forEach>
    </table>
</c1:if>

    <div class="breakline"></div>

    <div>Добавьте новую оценку</div>

    <form action="${pageContext.request.contextPath}/professor/dashboard" method="post">

        <select class="add-rating-field" required name="studentName">
            <c1:forEach var="stud" items="${studentsList}">
                <option value="${stud.getId()}">${stud.getName()}</option>
            </c1:forEach>
        </select><BR>

        <select class="add-rating-field" required name="subjectName">
        <c1:forEach var="subj" items="${subjectsList}">
            <option value="${subj.getId()}">${subj.getSubjectName()}</option>
        </c1:forEach>
        </select><BR>

        <select class="add-rating-field" required name="rating">
            <option value="1">Кол</option>
            <option value="2">Двойка</option>
            <option value="3">Тройка</option>
            <option value="4">Четвёрка</option>
            <option value="5">Пятёрка</option>
        </select><BR>

        <button>Поставить оценку</button>
    </form>

    </main><!-- .content -->
    </div>
    <!-- .container-->
    <%@ include file="footer.jsp" %>