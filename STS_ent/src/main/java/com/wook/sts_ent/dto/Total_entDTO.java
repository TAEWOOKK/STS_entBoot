package com.wook.sts_ent.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Total_entDTO {
    private int tseq;
    private int category;
    private String tname;
    private String place;
    private String time;
    private Date sdate;
    private Date edate;
    private int price;
    private String seat;
    private String pimg;
    private String cimg;


}
