package org.koreait.global.libs;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Utils {
    private final HttpServletRequest request;

    public boolean isMobile(){
    String ua=request.getHeader("User-Agent");
    String pattern=".*(iPhone|iPod|iPad|BlackBerry|Android|Windows CE|LG|MOT|SAMSUNG|SonyEricsson).*";
        return ua.matches(pattern);
    }
    public String tpl(String path){
        String prefix=isMobile()?"mobile":"front";
        return String.format("%s/%s",prefix,path);
    }
}
