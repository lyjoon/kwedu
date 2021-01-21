package kr.co.kw.edu.util;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TestDateUtil {

    @Test
    public void testString(){
        System.out.println("date >" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY년 MM월 dd일 hh시 mm분")));
    }
}
