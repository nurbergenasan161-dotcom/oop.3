package fitnessclub;

import java.util.List;
import java.util.stream.Collectors;

public class business {
    public static class MemberService {

        private final persistence.MemberRepositoryImpl repo;

        public MemberService(persistence.MemberRepositoryImpl repo) {
            this.repo = repo;
        }
        public List<domain.Member> findMembersByEmailDomain(String domain) {
            return repo.findAll().stream()
                    .filter(m -> m.getEmail().endsWith(domain))
                    .collect(Collectors.toList());
        }

        public List<domain.Member> filterMembersByEmailDomain(List<domain.Member> members, String domain) {
            return members.stream()
                    .filter(m -> m.getEmail().endsWith(domain))
                    .collect(Collectors.toList());
        }
    }
}
