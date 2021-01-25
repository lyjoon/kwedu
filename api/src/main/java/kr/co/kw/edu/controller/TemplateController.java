package kr.co.kw.edu.controller;

import kr.co.kw.edu.common.BaseComponent;
import kr.co.kw.edu.dto.EventInquiry;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 템플릿 관련 컨트롤러 (테스트목적, 삭제하여도 무방함)
 * thymeleaf (classpath:template/*) 구성 디자인을 확인하고자 생성함.
 */
@Controller
//@RequestMapping(value = "/template")
public class TemplateController extends BaseComponent {

    /**
     * 빨간펜 교재 문의에 대한 인적정보 메일템플릿 확인용
     * @return
     */
    @GetMapping(value = "/event/inquiry")
    public ModelAndView eventEmailInquiry(){
        EventInquiry eventInquiry = new EventInquiry();
        eventInquiry.setAge("3세");
        eventInquiry.setBaseAddress("서울시 강남구 역삼동 봉은사로4길");
        eventInquiry.setDetailAddress("35, 101");
        eventInquiry.setName("어린이");
        eventInquiry.setParentGender("남자");
        eventInquiry.setParentName("홍길동");
        eventInquiry.setParentPhone("010-5555-1234");
        eventInquiry.setParentBirthday("2020-04-01");
        eventInquiry.setZipCode("06123");

        java.util.Map<String, Object> reMap = convertToMap(eventInquiry);
        reMap.put("inquiry_date", LocalDateTime.now().format(DateTimeFormatter.ofPattern(this.getMessage("pattern.datetime"))));

        return new ModelAndView("event/inquiry", reMap);
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String index (){
        return "index";
    }
}
