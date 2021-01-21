package kr.co.kw.edu.service;

import javax.mail.MessagingException;
import java.util.Map;

public interface MailService {

    void sendSimpleMessage(String from, String[] to, String subject, String text);

    void sendMimeMessage(String from, String[] to, String subject, String contents) throws MessagingException;

    String getTemplateText(String templatePath, Map<String, Object> params);
}