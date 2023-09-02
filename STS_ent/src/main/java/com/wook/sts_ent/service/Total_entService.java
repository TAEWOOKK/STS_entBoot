package com.wook.sts_ent.service;

import com.wook.sts_ent.dto.Total_entDTO;
import com.wook.sts_ent.entity.Total_entEntity;
import com.wook.sts_ent.repository.Total_entRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Total_entService {

    private final Total_entRepository total_entRepository;

    public List<Total_entDTO> findByCategory(int category){
        List<Total_entEntity> total_entEntityList = total_entRepository.findByCategory(category);
        List<Total_entDTO> total_entDTOList = new ArrayList<>();
        for (Total_entEntity total_entEntity : total_entEntityList){
            Total_entDTO total_entDTO = Total_entDTO.tototal_entDTO(total_entEntity);
            total_entDTOList.add(total_entDTO);
        }
        return total_entDTOList;
    }


    public Total_entDTO findByTseq(int tseq) {
        Optional<Total_entEntity> total_entEntity = total_entRepository.findByTseq(tseq);

        if(total_entEntity.isPresent()){
            Total_entEntity totalEntEntity = total_entEntity.get();
            System.out.println(Total_entDTO.tototal_entDTO(totalEntEntity));
            return Total_entDTO.tototal_entDTO(totalEntEntity);
        }
        else{
            return null;
        }
    }
}
