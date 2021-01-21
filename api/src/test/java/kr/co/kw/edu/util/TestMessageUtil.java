package kr.co.kw.edu.util;

import kr.co.kw.edu.Application;
import kr.co.kw.edu.common.BaseComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Profile("local")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class TestMessageUtil extends BaseComponent {

    @Test
    public void testMessage(){
        System.out.println("msg : " + this.messageSourceAccessor.getMessage("event.inquiry.mail.title"));
    }

}
