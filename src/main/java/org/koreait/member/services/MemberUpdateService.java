package org.koreait.member.services;

import lombok.RequiredArgsConstructor;
import org.koreait.member.constants.Authority;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.entities.Authorities;
import org.koreait.member.entities.Member;
import org.koreait.member.entities.QAuthorities;
import org.koreait.member.repositories.AuthoritiesRepository;
import org.koreait.member.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Lazy
@Service
@RequiredArgsConstructor
public class MemberUpdateService {
    private final MemberRepository memberRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    public void process(RequestJoin form) {
        // 커맨드 객체 -> 엔티티 객체 데이터 옮기기
        Member member = modelMapper.map(form, Member.class);

        List<String> optionalTerms = form.getOptionalTerms();
        if (optionalTerms != null) {
            String _optionalTerms = optionalTerms.stream().collect(Collectors.joining("||"));
            member.setOptionalTerms(_optionalTerms);
        }


        String hash=passwordEncoder.encode(form.getPassword());
        member.setPassword(hash);
        member.setCredentialChangeAt(LocalDateTime.now());
        Authorities auth=new Authorities();
        auth.setMember(member);
        auth.setAuthority(Authority.USER);
        save(member,List.of(auth));
    }

    private void save(Member member, List<Authorities> authorities){

        memberRepository.saveAndFlush(member);
        QAuthorities qAuthorities=QAuthorities.authorities;
        List<Authorities> items=  (List<Authorities>) authoritiesRepository.findAll(qAuthorities.member.eq(member));
        member=memberRepository.findByEmail(member.getEmail()).orElse(null);
        if(authorities != null){
          authoritiesRepository.deleteAll(items);
        }
    authoritiesRepository.saveAllAndFlush(authorities);
    }

}

