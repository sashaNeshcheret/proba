package ua.simpleproject.dao;

import ua.simpleproject.entity.User;
import ua.simpleproject.exception.DAOException;
import ua.simpleproject.transactions.ConnectionWrapper;
import ua.simpleproject.transactions.TransactionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {

    private static final String SQL = "select * from clients where login = ?";

    ClientDao() {
    }

    public User getByLogin(String login) throws SQLException, DAOException {
        ConnectionWrapper con = TransactionManager.getConnection();
        try {
            PreparedStatement statement = con.preparedStatement(SQL);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e){
            throw  new DAOException();
        } finally {
            con.close();
        }
        return null;
    }

    public void register(String name, String login, String password){}

    public void insert(User user) {
    }
}
