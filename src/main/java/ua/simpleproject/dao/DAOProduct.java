package ua.simpleproject.dao;


import ua.simpleproject.entity.Product;

import java.sql.*;
import java.util.Objects;

public class DAOProduct {

    public DAOProduct() {
    }
    public void add(Connection connection, Product product) throws SQLException {
        ResultSet resultSet = selectFromProduct(connection, product);

        System.out.println(resultSet);
        if(!resultSet.next()){
            insertToProducts(connection, product);
        }
    }

    public ResultSet selectFromProduct(Connection connection, Product product){
        ResultSet resultSet = null;
        String sqlSelect = "SELECT * FROM cash_register.products WHERE code_product = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1,product.getCodeProduct());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet selectFromProduct(Connection connection, int code){
        ResultSet resultSet = null;
        String sqlSelect = "SELECT * FROM cash_register.products WHERE code_product = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1,code);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet selectFromProduct(Connection connection, String name){
        ResultSet resultSet = null;
        String sqlSelect = "SELECT * FROM cash_register.products WHERE name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void insertToProducts(Connection connection, Product product){
        try{
            String sqlInsert = "INSERT INTO cash_register.products (code_product, name, countable) VALUES (?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlInsert);
            pstatement.setInt(1, product.getCodeProduct());
            pstatement.setString(2, product.getName());
            pstatement.setBoolean(3, product.isCountable());
            boolean d = pstatement.execute();

        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert to products");
            sqlEx.printStackTrace();
            return;
        }
    }
    public boolean delete(Connection connection, Product product){
        String sqlDelete = "DELETE FROM cash_register.products WHERE products.id > 0";
        Statement statement;
        boolean isDelete = false;
        try {
            statement = connection.createStatement();
            isDelete = statement.execute(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    public void show(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cash_register.products WHERE products.id > 0");
            while (resultSet.next()){
                System.out.print("id = " + resultSet.getInt(1));
                System.out.print(", product code = " + resultSet.getInt(2));
                System.out.print(", name = " + resultSet.getString(3));
                System.out.print(", countable = " + resultSet.getBoolean(4));
                System.out.println();
            }
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in show");
            sqlEx.printStackTrace();
            return;
        }
    }
    public String show(Connection connection, int code) {
        String answer = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM cash_register.products WHERE code_product = ?");
            pStatement.setInt(1, code);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                answer = "id = " + resultSet.getInt(1) + ", product code = " + resultSet.getInt(2) +
                        ", name = " + resultSet.getString(3) + "\n";
            }
            System.out.println(answer);
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in show");
            sqlEx.printStackTrace();
            return null;
        }
        return answer;
    }
    public String show(Connection connection, String name) {
        String answer = null;
        try {
            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM cash_register.products WHERE name = ?");
            pStatement.setString(1, name);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                answer = "id = " + resultSet.getInt(1) + ", product code = " + resultSet.getInt(2) +
                        ", name = " + resultSet.getString(3) + "\n";
            }
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in show");
            sqlEx.printStackTrace();
            return null;
        }
        return answer;
    }
}
