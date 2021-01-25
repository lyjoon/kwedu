package kr.co.kw.edu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 메일발송 관련 JavaMailSender 을 context 상에 생성하는 설정입니다.
 *
 * @author lyjoon@gmail.com
 * @see #javaMailSender()  spring-boot 내 JavaMailSender 관련 auto configuration 기능이 있지만 jvm 환경에 따라 생성되지 않을 수 있으니 강제적으로 생성해둡니다.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class MailConfig {

    private static final String MAIL_DEBUG = "mail.debug";
    private static final String MAIL_SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";

    private String host;
    private String protocol;
    private int port;
    private String username;
    private String password;
    private String defaultEncoding;

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(getHost());
        mailSender.setProtocol(getProtocol());
        mailSender.setPort(getPort());
        mailSender.setUsername(getUsername());
        mailSender.setPassword(getPassword());
        mailSender.setDefaultEncoding(getDefaultEncoding());
        Properties properties = mailSender.getJavaMailProperties();
        properties.put(MAIL_SMTP_STARTTLS_REQUIRED, false);
        properties.put(MAIL_SMTP_STARTTLS_ENABLE, true);
        properties.put(MAIL_SMTP_AUTH, true);
        properties.put(MAIL_DEBUG, true);
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
