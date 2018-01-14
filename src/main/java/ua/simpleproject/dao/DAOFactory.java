package ua.simpleproject.dao;

public class DAOFactory {
    public static DAOFactory daoFactory = new DAOFactory();
    public DAOUsers daoUsers = new DAOUsers();
    public DAOStock daoStock = new DAOStock();
    public DAOProduct daoProduct = new DAOProduct();
    public DAOCheckReports daoCheckReports = new DAOCheckReports();
    public DAOCurrentCheck daoCurrentCheck = new DAOCurrentCheck();

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory() {
        return daoFactory;
    }
    public DAOUsers getDaoUsers() {
        return daoUsers;
    }
    public DAOStock getDaoStock() {
        return daoStock;
    }
    public DAOProduct getDaoProduct() {
        return daoProduct;
    }
    public DAOCheckReports getDaoCheckReports() {
        return daoCheckReports;
    }
    public DAOCurrentCheck getDaoCurrentCheck() {
        return daoCurrentCheck;
    }
}
