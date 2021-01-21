package kr.co.kw.edu.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BaseComponent {

    @Autowired
    protected MessageSourceAccessor messageSourceAccessor;

    @Autowired
    protected ApplicationContext applicationContext;

    protected Map<String, Object> convertToMap(Object fromValue){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(fromValue, HashMap.class);
    }

    protected String getMessage(String code, String...args) {
        return messageSourceAccessor.getMessage(code, args, Locale.KOREA);
    }

    protected String getMessage(String code) {
        return messageSourceAccessor.getMessage(code, Locale.KOREA);
    }
}
