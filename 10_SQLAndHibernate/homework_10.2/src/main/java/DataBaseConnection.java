import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;

public class DataBaseConnection {
    private static String urlForConnection = "jdbc:mysql://localhost:3306/skillbox";
    private static String userName = "root";
    private static String password = "asdf0FDSA";
    private Connection connection;
    private Statement statement;
    private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private static Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    private static SessionFactory sessionFactory = metadata.buildSessionFactory();

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(urlForConnection, userName, password);
            statement = connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sqlQuery) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    
    @Override
    public String toString() {
        return "DataBaseConnection{" +
                "connection=" + connection +
                ", statement=" + statement +
                '}';
    }

    public static StandardServiceRegistry getRegistry() {
        return registry;
    }

    public static Metadata getMetadata() {
        return metadata;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public static String getUrlForConnection() {
        return urlForConnection;
    }

    public static void setUrlForConnection(String urlForConnection) {
        DataBaseConnection.urlForConnection = urlForConnection;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DataBaseConnection.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataBaseConnection.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
