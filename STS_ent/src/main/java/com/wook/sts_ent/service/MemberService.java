package com.wook.sts_ent.service;

import com.exam.member.dto.MemberDTO;
import com.exam.member.entity.MemberEntity;
import com.exam.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //dto --> entity 변환
        //2. repository의 save 메소드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        //repository의 save 메소드 호출(조건. entity 객체를 넘겨줘야함)
    }

    public MemberDTO login(MemberDTO memberDTO){
        System.out.println(memberDTO);
        //1. 회원이 입력한 이메일로 db에서 조회함
        //2. db 에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        System.out.println(byMemberEmail);
        if(byMemberEmail.isPresent()){
            //조회 결과가 있다면
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                //비밀번호 일치
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }else{
                return null;
            }
        }
        else {
            //
            return null;
        }

    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity : memberEntityList){
            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        //1.
        Optional<MemberEntity> memberEntity = memberRepository.findById(id);
        MemberEntity member = memberEntity.get();
        MemberDTO memberDTO = MemberDTO.toMemberDTO(member);
        return memberDTO;

        //2.
        //요약본
        //return MemberDTO.toMemberDTO(memberRepository.findById(id).get());
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(myEmail);
        return MemberDTO.toMemberDTO(byMemberEmail.get());
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));

    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
