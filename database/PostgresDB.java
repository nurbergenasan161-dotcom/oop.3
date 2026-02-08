package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresDB implements IDB {

    @Override
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
