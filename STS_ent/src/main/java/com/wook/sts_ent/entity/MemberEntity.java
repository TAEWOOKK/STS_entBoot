package com.wook.sts_ent.entity;

import com.wook.sts_ent.dto.MemberDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity implements UserDetails {
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

    @Builder
    public MemberEntity(String id,String password){
        this.id = id;
        this.password = password;
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
