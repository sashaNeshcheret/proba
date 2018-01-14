package ua.simpleproject.services;

import ua.simpleproject.dao.ClientDao;
import ua.simpleproject.dao.DaoFactoryOld;
import ua.simpleproject.entity.User;
import ua.simpleproject.exception.DAOException;

import java.sql.SQLException;
import java.util.Objects;

public class LoginService {

    private static LoginService loginService= new LoginService();

    public static LoginService getLoginService(){
        return loginService;
    }

    private LoginService(){

    }

    public boolean verify(String login, String password) throws SQLException, DAOException {

        ClientDao clientDao = DaoFactoryOld.getClientDao();
        User user = clientDao.getByLogin(login);

        return  (Objects.nonNull(user) && user.getPassword().equals(password));
    }
}
