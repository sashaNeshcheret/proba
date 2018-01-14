package ua.simpleproject.dao;


import ua.simpleproject.entity.User;
import ua.simpleproject.exception.DAOException;
import ua.simpleproject.transactions.ConnectionWrapper;
import ua.simpleproject.transactions.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsers {
    private static  final String sqlSelect = "SELECT * FROM cash_register.users where login = ?";
    private static  final String sqlInsert = "INSERT INTO cash_register.users (position, name, login, password, " +
            "check_word) VALUES(?,?,?,?,?)";

    DAOUsers(){
    }
    public void addToUsers(Connection connection,
                           String position, String name, String login,
                           String password, String checkWord) throws DAOException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, position);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, checkWord);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        }
    }

    public User getFromUsersByLogin(Connection connection, String login) throws DAOException{
        System.out.println("getFromUsersByLogin start");
        //ConnectionWrapper con = TransactionManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setPosition(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setLogin(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                user.setCheckWord(resultSet.getString(6));
                user.setSalary(resultSet.getInt(7));
                user.setNumberMastake(resultSet.getInt(8));
                user.setExperience(resultSet.getInt(9));
                return user;
            }
        } catch (SQLException e){
            throw  new DAOException();
        } finally {
            try {
                connection.close();//
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public void deleteFromUsers(Connection connection, String login){
        String sqlDelete = "DELETE from cash_register.users WHERE login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
