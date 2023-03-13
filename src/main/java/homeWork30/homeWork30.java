package homeWork30;

import java.sql.*;

public class homeWork30 {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        connect("jdbc:sqlite:telran.db");
        System.out.println("Connected to sqLite.");

        try {
            stmt = connection.createStatement();

            dropTable();
            createTable();
            insertInto();
            selectTable();
            System.out.println("~~~~~~");
            deleteByName("Dan");
            updateScoreByName("Ben", 160);
            selectTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        disconnect();
        System.out.println("Disconnected from sqLite.");
    }

    static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE students (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name TEXT,\n" +
                "    score INTEGER\n" +
                ");");
    }

    static void dropTable() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    static void insertInto() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Ben', 200), ('John', 170), ('Dan', 90);");
    }

    static void selectTable() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
        while (rs.next()) {
            System.out.printf("id: %d, name: %s, score: %d\n",
                    rs.getInt(1), rs.getString(2), rs.getInt(3));
        }
    }

    static void deleteByName(String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE name = ?;");
        ps.setString(1, name);
        ps.executeUpdate();
    }

    static void updateScoreByName(String name, int score) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE students SET score = ? WHERE name = ?;");
        ps.setInt(1, score);
        ps.setString(2, name);
        ps.executeUpdate();
    }

    static void connect(String url) {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void disconnect() {
        try {
//            if (stmt != null) {
//                stmt.close();
//            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
