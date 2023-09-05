package com.wook.sts_ent.dto;

import com.wook.sts_ent.entity.MemberEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class MemberDTO implements UserDetails {
    private String id;
    private String password;
    private String name;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String email;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setPhone(memberEntity.getPhone());
        memberDTO.setBirth(memberEntity.getBirth());
        memberDTO.setEmail(memberEntity.getEmail());
        return memberDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() { return this.password; }

    @Override
    public String getUsername() { return this.id; }

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
        return true;
    }
}
