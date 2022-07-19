package com.its.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="mem_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 70)
    private String password;

    @Column(length = 20)
    private String subname;

    @Column(length = 20)
    private String email;

    @Column(length = 20)
    private String rolename;

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUsername(memberDTO.getUsername());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setSubname(memberDTO.getSubname());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setRolename("ROLE_USER");
        return memberEntity;
    }
}
