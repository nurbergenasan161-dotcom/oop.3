package fitnessclub.reporting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection implements Database {
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();

    // TODO: вставь свои данные
    private static final String URL  = "jdbc:postgresql://localhost:5432/fitnessclub";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() { return INSTANCE; }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
