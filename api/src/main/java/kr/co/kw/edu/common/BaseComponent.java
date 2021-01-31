package kr.co.kw.edu.common;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * 공통 컴포넌트로 controller , service, 기능 component 에 class 에서 상속받아쓰시면 됩니다.
 * 구지 상속 받지 않아도 상관은 없습니다.
 *
 * @author lyjoon@gmail.com
 */
public class BaseComponent {

    private ObjectMapper objectMapper = null;

    protected ObjectMapper getObjectMapper(){
        this.objectMapper = new ObjectMapper();
        return this.objectMapper;
    }

    @Autowired
    protected MessageSourceAccessor messageSourceAccessor;

    @Autowired
    protected ApplicationContext applicationContext;

    protected Map<String, Object> convertToMap(Object fromValue){
        return this.getObjectMapper().convertValue(fromValue, HashMap.class);
    }

    protected String stringify(Object fromValue){
        try {
            return this.getObjectMapper().writeValueAsString(fromValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getMessage(String code, String...args) {
        return messageSourceAccessor.getMessage(code, args, Locale.KOREA);
    }

    protected String getMessage(String code) {
        return messageSourceAccessor.getMessage(code, Locale.KOREA);
    }
}
