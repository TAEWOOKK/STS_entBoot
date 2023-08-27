package com.exam.member.repository;

import com.exam.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//entity 클래스 명 , pk의 타입 까지
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //이메일로 회원 정보 조회
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
