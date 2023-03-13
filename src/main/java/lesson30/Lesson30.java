package lesson30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson30 {
    private static Connection connection;

    public static void main(String[] args) {
        connect("jdbc:postgresql://localhost:5432/telran", "postgres", "root");
        System.out.println("Postgresql server connected.");

        // use statement
        try {
            Statement stmt = connection.createStatement();
//            dropTable(stmt);
//            createTable(stmt);
//            System.out.println("Table created.");
//
//            insertInto(stmt);
//            System.out.println("Records added");

            select(stmt);
            System.out.println("***********");
//            findById(1);
//            deleteById(2);
//            updateById(3, "38b");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        disconnect();
        System.out.println("Postgresql server disconnected.");
    }

    static void dropTable(Statement stmt) throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    static void createTable(Statement stmt) throws SQLException {
        stmt.executeUpdate("CREATE TABLE students (\n" +
                "id SERIAL PRIMARY KEY,\n" +
                "name TEXT NOT NULL,\n" +
                "group_name TEXT NOT NULL\n" +
                ");");
    }

    static void insertInto(Statement stmt) throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, group_name) VALUES ('Ivan', '38a'), ('Petr', '38a');");
    }

    static void select(Statement stmt) throws SQLException {
        ResultSet res = stmt.executeQuery("SELECT * FROM students");
        while(res.next()) {
            System.out.printf("id: %d, name: %s, group_name: %s\n",
                    res.getInt(1), res.getString(2), res.getString(3));
        }
    }

    static void findById(Integer id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
        ps.setInt(1, id);
        ResultSet res = ps.executeQuery();
        while(res.next()) {
            System.out.printf("id: %d, name: %s, group_name: %s\n",
                    res.getInt(1), res.getString(2), res.getString(3));
        }
    }

    static void deleteById(Integer id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    static void updateById(Integer id, String group_name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE students SET group_name = ? WHERE id = ?");
        ps.setString(1, group_name);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

    static void connect(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
