package kr.co.kw.edu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/event")
@RestController
public class EventController {

    @PutMapping(value = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> store(@RequestBody java.util.Map<String, Object> body){
        log.info("body : {}", Optional.ofNullable(body).map(map -> Boolean.toString(map.isEmpty())).orElse("N/A"));
        return ResponseEntity.ok("ok");
    }
}
