package com.wook.sts_ent.entity;

import com.wook.sts_ent.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 100)
    private String password;

    @Column(length = 20)
    private String name;

    @Column(length = 15)
    private String phone;

    @Column
    private Date birth;

    @Column(length = 40,unique = true)
    private String email;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setPhone(memberDTO.getPhone());
        memberEntity.setBirth(memberDTO.getBirth());
        memberEntity.setEmail(memberDTO.getEmail());

        return  memberEntity;
    }
}
