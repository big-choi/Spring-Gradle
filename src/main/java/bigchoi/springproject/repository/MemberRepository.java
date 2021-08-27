package bigchoi.springproject.repository;

import bigchoi.springproject.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장
    Optional<Member> findById(long id); //Optional : JAVA8 기능. FindById가 null값인 경우, null값을 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
