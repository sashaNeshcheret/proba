package ua.simpleproject.transactions;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("jdbc:mysql://localhost:3306/cash_register?");//java:comp/env/jdbc/
            connection = dataSource.getConnection();
            //для транзакций,чтобы после каждого запроса делать коммит
            connection.setAutoCommit(false);
            return dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
