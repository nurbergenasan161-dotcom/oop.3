package services;

import entities.Member;
import repositories.MemberRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class MemberService {

    private final MemberRepositoryImpl repo;

    public MemberService(MemberRepositoryImpl repo) {
        this.repo = repo;
    }

    public List<Member> findMembersByEmailDomain(String domain) {
        return repo.findAll().stream()
                .filter(m -> m.getEmail().endsWith(domain))
                .collect(Collectors.toList());
    }
}

