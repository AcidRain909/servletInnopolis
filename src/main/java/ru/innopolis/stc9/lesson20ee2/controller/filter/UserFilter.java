package ru.innopolis.stc9.lesson20ee2.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** Фильтр для студентов
 * @version 1.0
 * @author Acid_Rain909
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     * Проверка логина и роли
     *
     * @param request
     * @param response
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        if ((httpSession.getAttribute("login") != null) &&
                (httpSession.getAttribute("role").equals(1))) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse httpServletRespoonse = (HttpServletResponse) response;
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            httpServletRespoonse.sendRedirect(httpServletRequest.getContextPath() + "/login?errorMsg=noAuth");
        }
    }

    @Override
    public void destroy() {

    }
}
