import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
@Data
public class DataBaseConnection {
    private static String urlForConnection = "jdbc:mysql://localhost:3306/skillbox";
    private static String userName = "root";
    private static String password = "asdf0FDSA";
    private Connection connection;
    private Statement statement;
    private StandardServiceRegistry registry;
    private Metadata metadata;
    private SessionFactory sessionFactory;

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(urlForConnection, userName, password);
            statement = connection.createStatement();
            initSessionFactory();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void initSessionFactory() {
        try {
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            metadata = new MetadataSources(registry).getMetadataBuilder().build();
            sessionFactory = metadata.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
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

}
