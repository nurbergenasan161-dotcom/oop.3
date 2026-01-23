package services;

import entities.Member;
import exceptions.InvalidInputException;
import repositories.MemberRepository;

public class MemberService {

    private final MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public Member createMember(String name, String email) {
        if (name == null || email == null) {
            throw new InvalidInputException("Invalid input");
        }
        return repo.create(new Member(name, email));
    }
}
