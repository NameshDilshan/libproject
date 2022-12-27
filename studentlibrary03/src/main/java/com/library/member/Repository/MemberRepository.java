package com.library.member.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.member.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
