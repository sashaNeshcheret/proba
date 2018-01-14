package ua.simpleproject.dao;


import ua.simpleproject.entity.Product;
import ua.simpleproject.entity.Stock;

import java.sql.*;

public class DAOStock {
    DAOStock(){
    }

    public void add(Connection connection, Stock stock){
        int id = -1;
        int number = 0;
        try{
            ResultSet resultSet = selectFromStock(connection,stock);
            while (resultSet.next()){
                id = resultSet.getInt(1);
                number = resultSet.getInt(3);
            }
            if(id == -1){
                insertToStock(connection, stock);
            }else{
                updateStock(connection, stock, id, number);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void addByCode(Connection connection, Product product, int number){
        int productId = -1;
        int productNumber = 0;
        try{
            ResultSet resultSet = selectFromStock(connection, product);
            System.out.println(1);
            while (resultSet.next()){
                System.out.println(2);
                productId = resultSet.getInt(1);
                productNumber = resultSet.getInt(3);
            }
            if(productId == -1){
                insertToStock(connection, product, number);
            }else{
                updateStock(connection, number, productId, productNumber);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void addByCode(Connection connection, int code, int number){
        int productId = -1;
        int productNumber = 0;
        try{
            ResultSet resultSet = selectFromStock(connection, code);
            while (resultSet.next()){
                productId = resultSet.getInt(1);
                productNumber = resultSet.getInt(3);
            }
            if(productId == -1){
                insertToStock(connection, code, number);
            }else{
                updateStock(connection, number, productId, productNumber);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void addByName(Connection connection, Product product, int number){
        int productId = -1;
        int productNumber = 0;
        try{
            ResultSet resultSet = selectFromStock(connection, product);
            while (resultSet.next()){
                productId = resultSet.getInt(1);
                productNumber = resultSet.getInt(3);
            }
            if(productId == -1){
                insertToStock(connection, product, number);
            }else{
                updateStock(connection, number, productId, productNumber);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void addByName(Connection connection, String name, int number){
        int productId = -1;
        int productNumber = 0;
        try{
            ResultSet resultSet = selectFromStock(connection, name);
            while (resultSet.next()){
                productId = resultSet.getInt(1);
                productNumber = resultSet.getInt(3);
            }
            if(productId == -1){
                insertToStock(connection, name, number);
            }else{
                updateStock(connection, number, productId, productNumber);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public ResultSet selectFromStock(Connection connection, Stock stock) throws SQLException {
        String sqlSelect = "SELECT * FROM cash_register.stock WHERE product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setInt(1,stock.getProductId());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public ResultSet selectFromStock(Connection connection, Product product) throws SQLException {
        String sqlSelect = "SELECT * FROM cash_register.stock WHERE product_id = (" +
                "SELECT id FROM cash_register.products WHERE code_product = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setInt(1,product.getCodeProduct());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public ResultSet selectFromStock(Connection connection, int code) throws SQLException {
        String sqlSelect = "SELECT * FROM cash_register.stock WHERE product_id = (" +
                "SELECT id FROM cash_register.products WHERE code_product = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setInt(1,code);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public ResultSet selectFromStock(Connection connection, String name) throws SQLException {
        String sqlSelect = "SELECT * FROM cash_register.stock WHERE product_id = (" +
                "SELECT id FROM cash_register.products WHERE name = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


    public void insertToStock(Connection connection, Stock stock){
        try{
            String sqlINSERT = "INSERT INTO cash_register.stock (product_id, number) VALUES (?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlINSERT);
            pstatement.setInt(1, stock.getProductId());
            pstatement.setInt(2, stock.getNumber());
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void insertToStock(Connection connection, Product product, int number){
        try{
            int id = 0;
            ResultSet resultSet = (new DAOProduct()).selectFromProduct(connection, product);
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            String sqlINSERT = "INSERT INTO cash_register.stock (product_id, number) VALUES (?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlINSERT);
            pstatement.setInt(1, id);
            pstatement.setInt(2, number);
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void insertToStock(Connection connection, int code, int number){
        try{
            int id = 0;
            ResultSet resultSet = (new DAOProduct()).selectFromProduct(connection, code);
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            System.out.println(id);
            String sqlINSERT = "INSERT INTO cash_register.stock (product_id, number) VALUES (?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlINSERT);
            pstatement.setInt(1, id);
            pstatement.setInt(2, number);
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void insertToStock(Connection connection, String name, int number){
        try{
            int id = 0;
            ResultSet resultSet = (new DAOProduct()).selectFromProduct(connection, name);
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
            System.out.println(id);
            String sqlINSERT = "INSERT INTO cash_register.stock (product_id, number) VALUES (?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlINSERT);
            pstatement.setInt(1, id);
            pstatement.setInt(2, number);
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void updateStock(Connection connection, Stock stock, int id, int number){
        try{
            String sqlUpdate = "UPDATE cash_register.stock SET stock.number = ? WHERE id = ?";
            PreparedStatement pstatement = connection.prepareStatement(sqlUpdate);
            pstatement.setInt(1, stock.getNumber()+number);
            pstatement.setInt(2, id );
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in update");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void updateStock(Connection connection, int number,int productId, int productNumber){
        try{
            String sqlUpdate = "UPDATE cash_register.stock SET stock.number = ? WHERE id = ?";
            PreparedStatement pstatement = connection.prepareStatement(sqlUpdate);
            pstatement.setInt(1, number+productNumber);
            pstatement.setInt(2, productId );
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in update");
            sqlEx.printStackTrace();
            return;
        }
    }


    public void show(Connection connection) {
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM cash_register.stock WHERE stock.id > 0");
            while (resultSet.next()){
                System.out.print("id = " + resultSet.getInt(1));
                System.out.print(", product : " + (DAOFactory.getDaoFactory().daoProduct).show(connection, resultSet.getString(2)));;
                System.out.print(", number = " + resultSet.getInt(4));
                System.out.println();
            }
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in show");
            sqlEx.printStackTrace();
            return;
        }
    }
}
