<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c2" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="header.jsp" %>
<div class="dashbord-container">
    <main class="content">

        <strong><%=(String) request.getSession().getAttribute("name")%>, Ваши оценки</strong>

    <c2:if test="${fn:length(gradesList) lt 1}">
            <p>Оценки отсутствуют</p>
        </c2:if>

        <c2:if test="${fn:length(gradesList) gt 0}">

        <table class="grades">
            <tr>
                <td>ID записи</td>
                <td>Профессор</td>
                <td>Студент</td>
                <td>Предмет</td>
                <td>Оценка</td>
            </tr>

            <c2:forEach var="num" items="${gradesList}">
                <tr>
                    <td>
                        <p>${num.getId()}</p>
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
            </c2:forEach>
        </table>
      </c2:if>

    </main><!-- .content -->
</div>
<!-- .container-->
<%@ include file="footer.jsp" %>


