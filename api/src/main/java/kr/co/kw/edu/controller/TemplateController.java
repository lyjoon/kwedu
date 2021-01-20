package kr.co.kw.edu.controller;

import kr.co.kw.edu.common.BaseComponent;
import kr.co.kw.edu.dto.EventInquiry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/template")
public class TemplateController extends BaseComponent {

    @GetMapping(value = "/event/email/inquiry")
    public ModelAndView eventEmailInquiry(){
        EventInquiry eventInquiry = new EventInquiry();
        eventInquiry.setAge(3);
        eventInquiry.setBaseAddress("서울시 강남구 역삼동 봉은사로4길");
        eventInquiry.setDetailAddress("35, 101");
        eventInquiry.setName("어린이");
        eventInquiry.setParentGender("남자");
        eventInquiry.setParentName("홍길동");
        eventInquiry.setParentPhone("010-5555-1234");
        eventInquiry.setParentBirthday("2020-04-01");
        eventInquiry.setZipCode("06123");
        return new ModelAndView("event/inquiry", this.convertToMap(eventInquiry));
    }
}
