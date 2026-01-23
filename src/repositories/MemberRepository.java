package repositories;

import entities.Member;
import java.util.List;

public interface MemberRepository {
    Member create(Member member);
    List<Member> findAll();
    Member findById(int id);
}
