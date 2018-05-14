package ru.innopolis.stc9.lesson20ee2.db.connection;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {
    private static Logger logger = Logger.getLogger(ConnectionManagerImpl.class);

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university",
                    "postgres",
                    "innopolis");
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException. DB Conn. Message = " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            logger.error("SQLException. DB Conn. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
