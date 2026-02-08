package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {

    private static DatabaseManager instance;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/fitness",
                    "postgres",
                    "password"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
