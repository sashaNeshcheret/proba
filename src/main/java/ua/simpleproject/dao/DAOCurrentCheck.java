package ua.simpleproject.dao;


import ua.simpleproject.entity.CheckReports;
import ua.simpleproject.entity.CurrentCheck;
import ua.simpleproject.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOCurrentCheck {
    DAOCurrentCheck(){
    }

    public void add(Connection connection, CurrentCheck currentCheck){
        int id = -1;
        int count = 0;
        try{
            ResultSet resultSet = selectFromCurrentCheck(connection, currentCheck);
            while (resultSet.next()){
                id = resultSet.getInt(1);
                count = resultSet.getInt(4);
            }
            if(id == -1){
                insertToCurrentCheck(connection, currentCheck);
            }else{
                updateCurrentCheck(connection, currentCheck, id, count);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void addToCurrentCheckByCode(Connection connection, int code, int userId, int number){
        int id = -1;
        //int userId = 0;
        int count = 0;
        try{
            ResultSet resultSet = selectFromCurrentCheck(connection, code, userId);
            while (resultSet.next()){
                id = resultSet.getInt(1);
                //userId = resultSet.getInt(2);
                count = resultSet.getInt(4);
            }
            if(id == -1){
                insertToCurrentCheck(connection, userId, code, number);
            }else{
                updateCurrentCheck(connection, id, code, count, number);
            }
        }catch (SQLException sqlEx){
            System.out.println("Mistake in adding");
            sqlEx.printStackTrace();
            return;
        }
    }
    public ResultSet selectFromCurrentCheck(Connection connection, CurrentCheck currentCheck) throws SQLException {
        String sqlSelect = "SELECT * FROM cash_register.current_check WHERE product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setInt(1,currentCheck.getProductID());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public ResultSet selectFromCurrentCheck(Connection connection, int code, int userId) throws SQLException {
        String sqlSelect = "SELECT * FROM cash_register.current_check WHERE " +
                "((product_id = (SELECT id FROM cash_register.products WHERE code_product = ?)) & " +
                "(user_id = ?))";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setInt(1, code);
        preparedStatement.setInt(2, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public void insertToCurrentCheck(Connection connection, CurrentCheck currentCheck){
        try{
            String sqlINSERT = "INSERT INTO cash_register.current_check (id, product_id, user_id, count, price_for_1, result_price) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlINSERT);
            pstatement.setInt(1, CurrentCheck.getId());
            pstatement.setInt(2, currentCheck.getProductID());
            pstatement.setInt(3, currentCheck.getUserId());
            pstatement.setInt(4, currentCheck.getCount());
            pstatement.setInt(5, currentCheck.getPriceForOne());
            pstatement.setInt(6, currentCheck.getResultPrice());
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void insertToCurrentCheck(Connection connection, int userID, int code, int number){
        try{

            //create method select from products in DAOCurrentCheck. Why not?
            int productId = 0;
            int priceForOne = 0;
            String sqlSelect = "SELECT * FROM cash_register.products where code_product = ?";
            PreparedStatement selectPSstatement = connection.prepareStatement(sqlSelect);
            selectPSstatement.setInt(1, code);
            ResultSet resultSet = selectPSstatement.executeQuery();
            while (resultSet.next()){
                productId = resultSet.getInt(1);
                priceForOne = resultSet.getInt(5);
            }


            String sqlINSERT = "INSERT INTO cash_register.current_check (product_id, user_id, count, result_price) VALUES (?,?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sqlINSERT);
            pstatement.setInt(1, productId);
            pstatement.setInt(2, userID);
            pstatement.setInt(3, number);
            pstatement.setInt(4, number*priceForOne);
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in insert to Current Check");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void updateCurrentCheck(Connection connection, CurrentCheck currentCheck, int id, int count){
        try{
            String sqlUpdate = "UPDATE cash_register.current_check SET count = ?, result_price = ?  WHERE product_id = ?";
            PreparedStatement pstatement = connection.prepareStatement(sqlUpdate);
            pstatement.setInt(1, currentCheck.getCount()+count);
            pstatement.setInt(2, (currentCheck.getCount()+count)*currentCheck.getPriceForOne());
            pstatement.setInt(3, id );
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in update");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void updateCurrentCheck(Connection connection, int id, int code, int count, int number){
        try{

            //create method select from products in DAOCurrentCheck. Why not?
            int productId = 0;
            int priceForOne = 0;
            String sqlSelect = "SELECT * FROM cash_register.products where code_products = ?";
            PreparedStatement selectPSstatement = connection.prepareStatement(sqlSelect);
            selectPSstatement.setInt(1, code);
            ResultSet resultSet = selectPSstatement.executeQuery();
            while (resultSet.next()){
                productId = resultSet.getInt(1);
                priceForOne = resultSet.getInt(5);
            }

            String sqlUpdate = "UPDATE cash_register.current_check SET count = ?, result_price = ?  WHERE id = ?";
            PreparedStatement pstatement = connection.prepareStatement(sqlUpdate);
            pstatement.setInt(1, number+count);
            pstatement.setInt(2, ((number)+count)*priceForOne);
            pstatement.setInt(3, id );
            pstatement.executeUpdate();
        }catch (SQLException sqlEx){
            System.out.println("Mistake in update current Check");
            sqlEx.printStackTrace();
            return;
        }
    }
    public List<CurrentCheck> getOpenedCheck(Connection connection) {
        List<CurrentCheck> list = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cash_register.current_check WHERE current_check.id > 0");
            int id=0, productId=0, userId=0, count=0, priceForOne=0,resultPrice=0;
            while (resultSet.next()){
                id = resultSet.getInt(1);
                System.out.print("id = " + id);
                productId = resultSet.getInt(2);
                System.out.print(", product_id = " + productId);
                userId = resultSet.getInt(3);
                System.out.print(", user_id = " + userId);
                count = resultSet.getInt(4);
                System.out.print(", count = " + count);
                priceForOne = resultSet.getInt(5);
                System.out.print(", price for one= " + priceForOne);
                resultPrice = resultSet.getInt(6);
                System.out.print(", result price = " + resultPrice);
                System.out.println();
                CurrentCheck currentCheck = new CurrentCheck(0, userId, productId,  count, priceForOne, resultPrice);
                list.add(currentCheck);
            }
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in show");
            sqlEx.printStackTrace();
        }
        return list;
    }
    public void show(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cash_register.current_check WHERE current_check.id > 0");
            while (resultSet.next()){
                System.out.print("id = " + resultSet.getInt(1));
                System.out.print(", product_id = " + resultSet.getInt(2));
                System.out.print(", user_id = " + resultSet.getInt(3));
                System.out.print(", count = " + resultSet.getInt(4));
                System.out.print(", price for one= " + resultSet.getInt(5));
                System.out.print(", result price = " + resultSet.getInt(6));
                System.out.println();
            }
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in show");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void openCheck(Connection connection) throws DAOException {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM cash_register.current_check WHERE current_check.id > 0");
            System.out.println("open check");
        }catch (SQLException sqlEx){
            System.out.println("Mistake in open check");
            throw new DAOException();
        }
    }
    public void closeCheck(Connection connection, int userId){
        int count = 0;
        int checkAmount = 0;
        try {
            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM cash_register.current_check WHERE current_check.user_id = ?");
            pStatement.setInt(1, userId);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()){
                checkAmount += resultSet.getInt(5);
                count++;
            }

            CheckReports checkReports = new CheckReports(userId, count, checkAmount);
            String sqlInsert = "INSERT INTO cash_register.check_reports (user_id, number_of_product, check_amount, time_close) VALUES (?,?,?,NOW())";
            PreparedStatement prStatement = connection.prepareStatement(sqlInsert);
            prStatement.setInt(1, checkReports.getUserId());// userId
            prStatement.setInt(2, checkReports.getNumberOfProduct());//count
            prStatement.setInt(3, checkReports.getCheckAmount());//checkAmount
            prStatement.executeUpdate();
        } catch (SQLException sqlEx) {
            System.out.println("Mistake in close");
            sqlEx.printStackTrace();
            return;
        }
    }
    public void abolitionCheck(Connection connection) throws SQLException {
        List<CurrentCheck> list = getOpenedCheck(connection);
        int id = -1;
        int number = 0;
        ResultSet resultSet;

        //PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int returnedMoney = 0;
        for(CurrentCheck currentCheck : list){
            CurrentCheck.getId();
            currentCheck.getProductID();
            currentCheck.getUserId();
            currentCheck.getCount();
            currentCheck.getPriceForOne();
            currentCheck.getResultPrice();
            //preparedStatement.setInt();
            //preparedStatement.setInt();

            /*resultSet = selectFromStock(connection,);
            while (resultSet.next()){
                id = resultSet.getInt(1);
                number = resultSet.getInt(4);
            }
            if(id == -1){
                //insertToStock(connection, stock);
            }else{
                //updateStock(connection, stock, id, number);
            }*/
        }

    }
    public void abolitionOneProduct(){

    }
}
