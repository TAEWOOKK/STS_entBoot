package com.wook.sts_ent.repository;

import com.wook.sts_ent.dto.Total_entDTO;
import com.wook.sts_ent.entity.Total_entEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Total_entRepository extends JpaRepository<Total_entEntity, Integer> {

    Optional<Total_entEntity> findByTseq(int tseq);
}
