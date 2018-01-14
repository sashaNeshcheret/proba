package ua.simpleproject.servlets;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/index.jsp";
// уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}