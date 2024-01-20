package com.wook.sts_ent.dto;

import com.wook.sts_ent.entity.Total_entEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//develop
public class Total_entDTO {
    private int tseq;
    private int category;
    private String tname;
    private String place;
    private String time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date edate;
    private int price;
    private String seat;
    private String pimg;
    private String cimg;

    public static Total_entDTO tototal_entDTO(Total_entEntity total_entEntity){
        Total_entDTO total_entDTO = new Total_entDTO();
        total_entDTO.setTseq(total_entEntity.getTseq());
        total_entDTO.setCategory(total_entEntity.getCategory());
        total_entDTO.setTname(total_entEntity.getTname());
        total_entDTO.setPlace(total_entEntity.getPlace());
        total_entDTO.setTime(total_entEntity.getTime());
        total_entDTO.setSdate(total_entEntity.getSdate());
        total_entDTO.setEdate(total_entEntity.getEdate());
        total_entDTO.setPrice(total_entEntity.getPrice());
        total_entDTO.setSeat(total_entEntity.getSeat());
        total_entDTO.setPimg(total_entEntity.getPimg());
        total_entDTO.setCimg(total_entEntity.getCimg());
        return total_entDTO;
    }
}
