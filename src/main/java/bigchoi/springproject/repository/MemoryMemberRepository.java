package bigchoi.springproject.repository;

import bigchoi.springproject.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository { //인터페이스 상속
    private static Map<Long, Member> store = new HashMap<>(); //domain.member key : long value : member
    private static long sequence = 0L; //key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); //put(key,value)
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id)); //key 값이 null이여도 감쌀 수 있음.
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
               .filter(member -> member.getName().equals(name))
               .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store value값 반환
    }

    public void clearStore(){
        store.clear();
    }
}
