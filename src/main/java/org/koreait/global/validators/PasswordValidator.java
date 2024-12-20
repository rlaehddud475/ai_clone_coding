package org.koreait.global.validators;

public interface PasswordValidator {
default boolean alphaCheck(String password, boolean caseInsensitive){

    if (caseInsensitive){
        return password.matches(".*[a-zA-z]+.*");
    }
    return password.matches(".*[a-z]+.*")&&password.matches(".*[A-z]+.*");
}

default boolean numberCheck(String password){
    return password.matches(".*\\d.*");
}
default boolean specialCharsCheck(String password){
    String pattern=".*[^0-9a-zA-Zㄱ-ㅎ가-힣].*";
    return password.matches(pattern);
}
}
