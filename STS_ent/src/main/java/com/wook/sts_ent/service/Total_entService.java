package com.wook.sts_ent.service;

import com.wook.sts_ent.dto.Total_entDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Total_entService {

    private final Total_entRepository total_entRepository;

    public List<Total_entDTO> findAll(int category){

    }
}
