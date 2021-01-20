package kr.co.kw.edu.controller;

import kr.co.kw.edu.common.BaseComponent;
import kr.co.kw.edu.dto.EventInquiry;
import kr.co.kw.edu.properties.ServiceMailProperties;
import kr.co.kw.edu.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/event")
@RestController
public class EventController extends BaseComponent {

    private final MailService mailService;

    private final ServiceMailProperties serviceMailProperties;

    @PutMapping(value = "/api/inquiry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> inquiry(@RequestBody EventInquiry eventInquiry) {
        mailService.sendSimpleMessage(this.serviceMailProperties.getSendFrom(), this.serviceMailProperties.getSendToList(),
                this.messageSourceAccessor.getMessage("event.inquiry.mail.title"), eventInquiry.toString());
        return ResponseEntity.ok("ok");
    }
}
