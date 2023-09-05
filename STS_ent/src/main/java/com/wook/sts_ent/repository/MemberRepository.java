package com.wook.sts_ent.repository;

import com.wook.sts_ent.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    Optional<MemberEntity> findByEmail(String email);
    Optional<MemberEntity> findById(String id);
}
