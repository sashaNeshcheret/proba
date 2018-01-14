package ua.simpleproject.servlets;

import ua.simpleproject.ConnectorDB;
import ua.simpleproject.dao.DAOFactory;
import ua.simpleproject.exception.DAOException;

import java.sql.Connection;

public class OpenCheckLogin {
    public static boolean openCheck(){
        try{
            DAOFactory.getDaoFactory().getDaoCurrentCheck().openCheck(ConnectorDB.getConnection());
        } catch (DAOException e) {
            return false;
        }
        return true;
    }
}
