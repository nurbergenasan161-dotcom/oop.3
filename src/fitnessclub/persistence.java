package fitnessclub;

import database.IDB;
import exceptions.NotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class persistence {
    public static class DatabaseConnection {
        private static final String URL =
                "jdbc:postgresql://aws-1-ap-south-1.pooler.supabase.com:5432/postgres?sslmode=require";
        private static final String USER = "postgres.ropxfhfllslvwzlapzvh";
        private static final String PASSWORD = "123.Nurbergen"; // ← DATABASE PASSWORD
        private DatabaseConnection() {
            // no instances
        }
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    public static interface MemberRepository {
        domain.Member create(domain.Member member);
        List<domain.Member> findAll();
        domain.Member findById(int id);
    }

    public static class MemberRepositoryImpl implements MemberRepository {

        private final IDB db;

        public MemberRepositoryImpl(IDB db) {
            this.db = db;
        }

        @Override
        public domain.Member create(domain.Member member) {
            String sql = "INSERT INTO members(name, email) VALUES (?, ?)";

            try (Connection con = db.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, member.getName());
                ps.setString(2, member.getEmail());
                ps.execute();
                return member;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public List<domain.Member> findAll() {
            List<domain.Member> members = new ArrayList<>();
            String sql = "SELECT * FROM members";

            try (Connection con = db.getConnection();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {
                    members.add(new domain.Member(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    ));
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return members;
        }

        @Override
        public domain.Member findById(int id) {
            String sql = "SELECT * FROM members WHERE id=?";

            try (Connection con = db.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (!rs.next()) {
                    throw new NotFoundException("Member not found");
                }

                return new domain.Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static interface Repository<T> {
        T create(T item);
        List<T> findAll();
        T findById(int id);
    }
}
