package org.koreait.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class JSONData {
    private HttpStatus status;
    private boolean success=true;
    private Object message;
    public Object data;
    public JSONData(Object data){
        this.data=data;
    }




}
