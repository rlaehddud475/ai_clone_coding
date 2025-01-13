package org.koreait.member.social.entities;

import lombok.Data;

@Data
public class SocialConfig {
    private boolean useKakaoLogin;
    private String kakaoRestApiKey;
}
