package kr.co.kw.edu.service;

import kr.co.kw.edu.properties.ServiceMailProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("local")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class TestMailService {

    @Autowired
    private MailService mailService;

    @Autowired
    private ServiceMailProperties serviceMailProperties;

    @Test
    public void testSendMail(){
        this.mailService.sendSimpleMessage(serviceMailProperties.getSendFrom(), serviceMailProperties.getSendToList(), "test-subject", "단위테스트");
    }
}
