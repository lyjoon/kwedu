package kr.co.kw.edu.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * application-*.yml 에 설정된 메일관련 프로퍼티
 */
@Data
@Component
@ConfigurationProperties(prefix = "service.email")
public class ServiceMailProperties {

    /**
     * 보내는 사람
     */
    private String sendFrom;

    /**
     * 받는 사람 목록(복수)
     */
    private String[] sendToList;

    /**
     * 메일 기본제목
     */
    private String defaultSubject;

}
