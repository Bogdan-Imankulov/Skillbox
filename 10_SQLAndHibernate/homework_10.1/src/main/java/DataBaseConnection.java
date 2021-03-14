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
