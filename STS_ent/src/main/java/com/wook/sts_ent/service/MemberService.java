package com.wook.sts_ent.service;

import com.wook.sts_ent.dto.MemberDTO;
import com.wook.sts_ent.entity.MemberEntity;
import com.wook.sts_ent.entity.Total_entEntity;
import com.wook.sts_ent.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public void insertMember(MemberDTO memberDTO) {

        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);

        memberRepository.save(memberEntity);
    }

    public int findId(String id) {

        Optional<MemberEntity> memberEntity =memberRepository.findById(id);

        if(memberEntity.isPresent()){
            return 1;
        }
        else{
            return 2;
        }
    }

    public String findByEmail(String email) {

        Optional<MemberEntity> memberEntity = memberRepository.findByEmail(email);

        if(memberEntity.isPresent()){
            return "fail";
        }
        else {
            return "success";
        }
    }

}
