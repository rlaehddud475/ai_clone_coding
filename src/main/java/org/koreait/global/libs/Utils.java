package org.koreait.global.libs;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.security.cert.Extension;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Utils {
    private final HttpServletRequest request;
private final MessageSource messageSource;
    public boolean isMobile(){
    String ua=request.getHeader("User-Agent");
    String pattern=".*(iPhone|iPod|iPad|BlackBerry|Android|Windows CE|LG|MOT|SAMSUNG|SonyEricsson).*";
        return ua.matches(pattern);
    }
    public String tpl(String path){
        String prefix=isMobile()?"mobile":"front";
        return String.format("%s/%s",prefix,path);
    }
    public String getMessage(String code){
        Locale lo = request.getLocale();
        return messageSource.getMessage(code,null,lo);
    }
    public List<String> getMessages(String[] codes){

           return Arrays.stream(codes).map(c-> {
               try {
                   String message = getMessage(c);
                   return message;
               } catch (Exception e) {
                   return "";
               }
           }).filter(s->!s.isBlank()).toList();

       }


    public Map<String,List<String>> getErrorMessages(Errors errors) {
        ResourceBundleMessageSource ms = (ResourceBundleMessageSource) messageSource;
        ms.setUseCodeAsDefaultMessage(false);
        try {




            Map<String, List<String>> messages = errors.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, f -> getMessages(f.getCodes()), (v1, v2) -> v2));
            List<String> gMessages = errors.getGlobalErrors().stream().flatMap(o -> getMessages(o.getCodes()).stream()).toList();
            if (!gMessages.isEmpty()) {
                messages.put("global", gMessages);
            }
            return messages;
        } finally {
            ms.setUseCodeAsDefaultMessage(true);
        }
    }
}
