package ua.simpleproject.servlets;

import ua.simpleproject.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        System.out.println("login " + login);
        System.out.println("pass " + pass);
// проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            User user = LoginLogic.getUserByLogin(login);
            request.setAttribute("user", user);
// определение пути к general.jsp
System.out.println("next after false");
            page = "/jsp/general.jsp";
            return page;
        } else {
            System.out.println("false");
            request.setAttribute("errorLoginPassMessage", "Your login or pass was entered wrong");//request.setAttribute("errorLoginPassMessage", "error");
System.out.println("next after false");
            page = "/jsp/login.jsp";
System.out.println(request.getAttribute("errorLoginPassMessage"));
        }
        return page;
    }
}
