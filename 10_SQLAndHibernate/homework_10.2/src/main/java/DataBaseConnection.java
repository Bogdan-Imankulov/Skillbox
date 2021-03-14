import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;

public class DataBaseConnection {
    private String urlForConnection;
    private String userName;
    private String userPassword;
    private Connection connection;
    private Statement statement;


    public DataBaseConnection(String urlForConnection, String userName, String userPassword) {
        try {
            connection = DriverManager.getConnection(urlForConnection, userName, userPassword);
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

   public SessionFactory factory(String path ){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(path).build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

    public String getUrlForConnection() {
        return urlForConnection;
    }

    public void setUrlForConnection(String urlForConnection) {
        this.urlForConnection = urlForConnection;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
