package kr.co.kw.edu.util;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

    public static String defaultString(String string, String defaultString) {
        return isEmpty(string) ? defaultString : string;
    }
}
