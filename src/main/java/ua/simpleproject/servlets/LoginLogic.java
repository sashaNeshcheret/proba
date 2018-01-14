package ua.simpleproject.servlets;

import ua.simpleproject.ConnectorDB;
import ua.simpleproject.dao.DAOFactory;
import ua.simpleproject.entity.User;
import ua.simpleproject.exception.DAOException;

public class LoginLogic {
   public static boolean checkLogin(String enterLogin, String enterPass) {
       User user = null;
       try {
           if(enterLogin == null){
               return false;
           }
           user = DAOFactory.getDaoFactory().daoUsers.getFromUsersByLogin(ConnectorDB.getConnection(), enterLogin);
           if(enterPass == null || user == null){
               return false;
           }
           if(enterLogin.equals(user.getLogin()) && enterPass.equals(user.getPassword())){
               return true;
           }
       } catch (DAOException e) {
          e.printStackTrace();// log4j
       }
       return false;
   }
   public static User getUserByLogin(String login){
       User user = null;
       try {
           if(login == null){
               //return false;
           }
           user = DAOFactory.getDaoFactory().daoUsers.getFromUsersByLogin(ConnectorDB.getConnection(), login);
           return user;
       } catch (DAOException e) {
           e.printStackTrace();// log4j
       }
       return user;
   }
}