package com.example.service;

/**
 * @author runlin.chen
 * @version 1.0 2017-12-15 11:51
 **/
public interface MailService {

    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html格式邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件，邮件中的静态资源一般就是指图片
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    void sendStaticResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
