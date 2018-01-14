package ua.simpleproject.services;

import ua.simpleproject.dao.ClientDao;
import ua.simpleproject.dao.DaoFactoryOld;
import ua.simpleproject.entity.User;
import ua.simpleproject.exception.DAOException;
import ua.simpleproject.exception.RegistrationException;
import ua.simpleproject.exception.TransactionException;
import ua.simpleproject.transactions.TransactionManager;

import java.sql.SQLException;
import java.util.Objects;

public class RegisterService {


    private static RegisterService registerService = new RegisterService();

    private RegisterService(){
    }

    public static RegisterService getRegisterService() {
        return registerService;
    }

    public void register(String name, String login, String password) throws RegistrationException, SQLException, DAOException, TransactionException {

        ClientDao clientDao = DaoFactoryOld.getClientDao();
        TransactionManager.beginTransaction();
        if(Objects.isNull(clientDao.getByLogin(login))){
            User user = new User();
            user.setName(name);
            user.setLogin(login);
            user.setPassword(password);

                clientDao.insert(user);


            TransactionManager.endTransaction();
        } else {
            TransactionManager.endTransaction();
            throw new RegistrationException("User already exist");
        }
    }
}
