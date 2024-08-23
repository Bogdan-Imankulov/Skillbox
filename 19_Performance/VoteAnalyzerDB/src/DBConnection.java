import java.sql.*;

public class DBConnection {
    private static Connection connection;

    private static final String dbName = "learn";
    private static final String dbUser = "postgres";
    private static final String dbPass = "asdf0FDSA";

    private static final StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, dbUser, dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count_with_duplicates");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id SERIAL, " +
                        "name VARCHAR NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "count INT NOT NULL, " +
                        "PRIMARY KEY(id), " +
                        "UNIQUE (name, birthDate))");
                connection.createStatement().execute("CREATE TABLE voter_count_with_duplicates(" +
                        "name VARCHAR NOT NULL," +
                        "birthDate DATE NOT NULL)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void multiInsert() throws SQLException {
        String insertWithDuplicates = "INSERT INTO voter_count_with_duplicates(name, birthDate) " +
                "VALUES " + insertQuery;
        DBConnection.getConnection().createStatement().execute(insertWithDuplicates);
        String insertFromTable = "INSERT INTO voter_count (name, birthDate, count)" +
                "SELECT name, birthDate, COUNT(*) " +
                "FROM voter_count_with_duplicates " +
                "GROUP BY name, birthDate";
        DBConnection.getConnection().createStatement().execute(insertFromTable);
    }

    public static void countVoter(String name, String birthDay){
        birthDay = birthDay.replaceAll("\\.", "-");
        boolean isStart = insertQuery.length() == 0;
        StringBuilder appendedString = new StringBuilder();
        appendedString.append(isStart ? "" : ", ").append("('" ).append(name).append("', '").append(birthDay).append("')");
        insertQuery.append(appendedString);
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, count FROM voter_count WHERE count > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
