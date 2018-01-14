package ua.simpleproject.servlets;

import ua.simpleproject.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OpenCheckCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        if(OpenCheckLogin.openCheck()){
            page = "/jsp/openCheck.jsp";
            return page;
        } else {

            page = "/jsp/error/error.jsp";
        }
        return page;
    }
}
