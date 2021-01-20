package kr.co.kw.edu.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "service.mail")
public class ServiceMailProperties {

    private String sendFrom;

    private String[] sendToList;

    private String defaultSubject;

}
