package repositories;

import database.IDB;
import entities.Member;
import exceptions.NotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository {

    private final IDB db;

    public MemberRepositoryImpl(IDB db) {
        this.db = db;
    }

    @Override
    public Member create(Member member) {
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
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";

        try (Connection con = db.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                members.add(new Member(
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
    public Member findById(int id) {
        String sql = "SELECT * FROM members WHERE id=?";

        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new NotFoundException("Member not found");
            }

            return new Member(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
