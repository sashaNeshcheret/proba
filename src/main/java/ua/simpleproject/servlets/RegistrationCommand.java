package ua.simpleproject.servlets;


import ua.simpleproject.command.FactoryCommand;
import ua.simpleproject.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RegistrationCommand implements ActionCommand {

    private static final String PARAM_POSITION = "position";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_CHECK_WORD = "check word";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
// извлечение инфо из запроса
        String position = request.getParameter(PARAM_POSITION);
        String name = request.getParameter(PARAM_NAME);
        String login = request.getParameter(PARAM_LOGIN);
        String pass = request.getParameter(PARAM_PASSWORD);
        String checkWord = request.getParameter(PARAM_CHECK_WORD);
        User user = new User();
        user.setPosition(position);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(pass);
        user.setCheckWord(checkWord);

        User user2 = new User();
        user2.setPosition("tr");
        user2.setName("tre");
        user2.setLogin("jhgfds");
        user2.setPassword("uyt");
        user2.setCheckWord("654");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);

// проверка свободен ли логина
        if (RegistrationLogic.checkLoginForFree(login)) {
// определение пути к general.jsp
            RegistrationLogic.registration(position, name, login, pass, checkWord);
            page = "/jsp/general.jsp";
            //session.setAttribute("login",login);
            request.setAttribute("user", user);
            request.setAttribute("name", name);
            request.setAttribute("list", list);
        } else {

            page = "/jsp/registration.jsp";
        }
        return page;
    }
}