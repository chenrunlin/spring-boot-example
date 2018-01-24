package com.example;

import com.example.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author runlin.chen
 * @version 1.0 2017-12-15 14:13
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    private String toEmail = "569062838@qq.com";

    @Test
    public void testSimpleMail() {
        String subject = "主题：简单测试邮件";
        String content = " hello this is simple mail";
        mailService.sendSimpleMail(toEmail, subject, content);
    }

    @Test
    public void testHtmlMail() throws Exception {
        String subject = "主题：发送html邮件";
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(toEmail, subject, content);
    }

    @Test
    public void sendAttachmentsMail() {
        String subject = "主题：带附件的邮件";
        String content = "有附件，请查收！";
        String filePath="C:\\Users\\net\\Desktop\\pic\\02a0256b.jpg";
        mailService.sendAttachmentsMail(toEmail, subject, content, filePath);
    }

    @Test
    public void sendStaticResourceMail() {
        String subject = "主题：这是有图片的邮件";
        String rscId = "chenrunlin";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\net\\Desktop\\pic\\02a0256b.jpg";
        mailService.sendStaticResourceMail(toEmail, subject, content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        String subject = "主题：这是模板邮件";
        String templateName = "emailTemplate";
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process(templateName, context);
        mailService.sendHtmlMail(toEmail, subject, emailContent);
    }

}
