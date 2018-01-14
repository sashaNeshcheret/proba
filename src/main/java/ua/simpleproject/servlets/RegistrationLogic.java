package ua.simpleproject.servlets;

import ua.simpleproject.ConnectorDB;
import ua.simpleproject.dao.DAOFactory;
import ua.simpleproject.entity.User;
import ua.simpleproject.exception.DAOException;

public class RegistrationLogic {
    public static boolean checkLoginForFree(String login) {
        User user = null;
        if(login == null){
            return false;
        }
        try {
            user = DAOFactory.getDaoFactory().daoUsers.getFromUsersByLogin(ConnectorDB.getConnection(), login);
        } catch (DAOException e) {
            e.printStackTrace();// log4j
        }
        if(user != null){
            if(login.equals(user.getLogin())){
                return false;
            }
        }
        return true;
    }
    public static boolean registration(String position, String name, String login, String pass, String checkWord){
        DAOFactory daoFactory = DAOFactory.getDaoFactory();
        try{
            daoFactory.getDaoUsers().addToUsers(ConnectorDB.getConnection(), position, name, login, pass, checkWord);
        }catch(DAOException e){
            return false;
        }
        return true;
    }
}