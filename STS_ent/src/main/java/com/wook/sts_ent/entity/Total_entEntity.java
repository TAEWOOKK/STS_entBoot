package com.wook.sts_ent.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "total_ent")
public class Total_entEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tseq;

    @Column(name = "category",length = 1)
    private int category;

    @Column(name = "tname",length = 40)
    private String tname;

    @Column(name = "place",length = 100)
    private String place;

    @Column(name = "time",length = 15)
    private String time;

    @Column(name = "sdate")
    private Date sdate;

    @Column(name = "edate")
    private Date edate;

    @Column(name = "price")
    private int price;

    @Column(name = "seat",length = 30)
    private String seat;

    @Column(name = "pimg",length = 100)
    private String pimg;

    @Column(name = "cimg",length = 100)
    private String cimg;

}
