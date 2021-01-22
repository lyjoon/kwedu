package kr.co.kw.edu.service.impl;

import kr.co.kw.edu.common.BaseComponent;
import kr.co.kw.edu.exception.BaseException;
import kr.co.kw.edu.properties.ServiceMailProperties;
import kr.co.kw.edu.service.MailService;
import kr.co.kw.edu.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MailServiceImpl extends BaseComponent implements MailService {

    private final JavaMailSender javaMailSender;

    private final SpringTemplateEngine springTemplateEngine;

    private final ServiceMailProperties serviceMailProperties;

    /**
     * 텍스트 메일
     * @param from
     * @param to
     * @param subject
     * @param text
     */
    @Override
    public void sendSimpleMessage(String from, String[] to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        if(Objects.isNull(to)) throw new BaseException("invalid 'to'");

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(StringUtil.defaultString(subject, serviceMailProperties.getDefaultSubject()));
        simpleMailMessage.setText(text);
        simpleMailMessage.setFrom(from);
        this.javaMailSender.send(simpleMailMessage);
    }

    /**
     * html 서식 메일
     * @param from
     * @param to
     * @param subject
     * @param contents
     * @throws MessagingException
     */
    @Override
    public void sendMimeMessage(String from, String[] to, String subject, String contents) {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage);

        try {
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setText(contents, true);
            this.javaMailSender.send(mimeMailMessage);
        } catch (MessagingException exception) {
            throw new BaseException(exception);
        }
    }

    /**
     * template -> text
     * @param templatePath
     * @param params
     * @return
     */
    @Override
    public String getTemplateText(String templatePath, Map<String, Object> params) {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(params);
        String html = springTemplateEngine.process(templatePath, thymeleafContext);
        return html;
    }
}
