package ua.simpleproject.dao;

public class DaoFactoryOld {
    private DaoFactoryOld(){};
    private static ClientDao clientDao = new ClientDao();
    private static DaoFactoryOld daoFactory = new DaoFactoryOld();
    public static DaoFactoryOld getInstance(){
        return daoFactory;
    }

    public static ClientDao getClientDao(){
        return clientDao;
    }
}
