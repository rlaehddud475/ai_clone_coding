package org.koreait.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.koreait.global.entities.BaseEntity;
import org.koreait.member.constants.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Member extends BaseEntity {
    @Id @GeneratedValue
    private Long seq;

    @Column(length = 65,nullable = false, unique = true)
    private String email;

    @Column(length = 65,nullable = false)
    private String password;
    @Column(length = 40,nullable = false)
    private String name;
    @Column(length = 40,nullable = false)
    private String nickName;

    @Column(nullable = false)
    private LocalDate birthDt;
    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    private Gender gender;
    @Column(length = 10,nullable = false)
    private String zipCode;
    @Column(length = 100,nullable = false)
    private String address;
    @Column(length = 100)
    private String addressSub;

    private boolean requiredTerms1;
    private boolean requiredTerms2;
    private boolean requiredTerms3;

    @Column(length = 50)
    private String optionalTerms;

    @ToString.Exclude
    @OneToMany(mappedBy = "member")
    private List<Authorities> authorities;

    private LocalDateTime credentialChangeAt;


}