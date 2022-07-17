package com.its.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private  MemberRepository mr;


    public void save(MemberDTO memberDTO) {
        String memberPw = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(memberPw);
        mr.save(MemberEntity.toSaveEntity(memberDTO));
    }

}
