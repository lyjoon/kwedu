package kr.co.kw.edu.controller;

import kr.co.kw.edu.common.BaseComponent;
import kr.co.kw.edu.dto.EventInquiry;
import kr.co.kw.edu.properties.ServiceMailProperties;
import kr.co.kw.edu.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 교원 빨간펜 교재문의 이메일 발송처리 관련 controller
 *
 * @author lyjoon
 * @version 1.0
 *
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/event")
@RestController
public class EventController extends BaseComponent {

    private final MailService mailService;

    private final ServiceMailProperties serviceMailProperties;

    /**
     * 교원 빨간펜 교재문의
     * @param eventInquiry
     * @return
     */
    @PutMapping(value = "/inquiry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> inquiry(@RequestBody EventInquiry eventInquiry) {

        java.util.Map<String, Object> reMap = convertToMap(eventInquiry);
        reMap.put("inquiry_date", LocalDateTime.now().format(DateTimeFormatter.ofPattern(this.getMessage("pattern.datetime"))));

        mailService.sendMimeMessage(this.serviceMailProperties.getSendFrom(),
                this.serviceMailProperties.getSendToList(),
                this.getMessage("event.inquiry.mail.title"), this.mailService.getTemplateText("event/inquiry", reMap));

        return ResponseEntity.ok("ok");
    }
}
