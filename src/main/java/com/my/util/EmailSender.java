package com.my.util;

/**
 * Created by Administrator on 2017/3/27.
 */

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;


public class EmailSender {
    private Properties properties;
    private Session session;
    private Message message;
    private MimeMultipart multipart;

    public EmailSender() {
        super();
        this.properties = new Properties();
    }
    public void setProperties(String host,String post){
        //地址
        this.properties.put("mail.smtp.host",host);
        //端口号
        this.properties.put("mail.smtp.post",post);
        //是否验证
        this.properties.put("mail.smtp.auth","true");
        this.session=Session.getInstance(properties);
        this.message = new MimeMessage(session);
        this.multipart = new MimeMultipart("mixed");
    }
    /**
     * 设置收件人
     * @param receiver
     * @throws MessagingException
     */
    public void setReceiver(String[] receiver) throws MessagingException{
        Address[] address = new InternetAddress[receiver.length];
        for(int i=0;i<receiver.length;i++){
            address[i] = new InternetAddress(receiver[i]);
        }
        this.message.setRecipients(Message.RecipientType.TO, address);
    }
    /**
     * 设置邮件
     * @param from 来源
     * @param title 标题
     * @param content 内容
     * @throws AddressException
     * @throws MessagingException
     */
    public void setMessage(String from,String title,String content) throws AddressException, MessagingException{
        this.message.setFrom(new InternetAddress(from));
        this.message.setSubject(title);
        //纯文本的话用setText()就行，不过有附件就显示不出来内容了
        MimeBodyPart textBody = new MimeBodyPart();
        textBody.setText(content);
        this.multipart.addBodyPart(textBody);
    }
    /**
     * 添加附件
     * @param filePath 文件路径
     * @throws MessagingException
     */
//    public void addAttachment(String filePath) throws MessagingException{
//        FileDataSource fileDataSource = new FileDataSource(new File(filePath));
//        DataHandler dataHandler = new DataHandler(fileDataSource);
//        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        mimeBodyPart.setDataHandler(dataHandler);
//        mimeBodyPart.setFileName(fileDataSource.getName());
//        this.multipart.addBodyPart(mimeBodyPart);
//    }
    /**
     * 发送邮件
     * @param host 地址
     * @param account 账户名
     * @param pwd 密码
     * @throws MessagingException
     */
    public void sendEmail(String host,String account,String pwd) throws MessagingException{
        //发送时间
        this.message.setSentDate(new Date());
        //发送的内容，文本和附件
        this.message.setContent(this.multipart);
        this.message.saveChanges();
        //创建邮件发送对象，并指定其使用SMTP协议发送邮件
        Transport transport=session.getTransport("smtp");
        //登录邮箱
        transport.connect(host,account,pwd);
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //关闭连接
        transport.close();
    }

    public void send(String title,String content,String[] receiver) throws MessagingException {
        //设置服务器地址和端口
        setProperties("smtp.sohu.com", "25");
        //分别设置发件人，邮件标题和文本内容
        setMessage("cloudclass@sohu.com", title, content);
        //设置收件人
        setReceiver(receiver);
        //多媒体相关配置
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-Java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);
        //发送邮件
        System.out.println("send Email before");
        sendEmail("smtp.sohu.com", "cloudclass@sohu.com", "cloudclass123456");
        System.out.println("send Email after");
    }
//    public static void main(String[] args) throws MessagingException {
//        EmailSender emailSender = new EmailSender();
//        //设置服务器地址和端口
//        emailSender.setProperties("smtp.sohu.com", "25");
//        //分别设置发件人，邮件标题和文本内容
//        emailSender.setMessage("cloudclass@sohu.com", "Test Message", "test email send");
//        //设置收件人
//        emailSender.setReceiver(new String[]{"dqh_ql@163.com"});
//        //多媒体相关配置
//        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
//        mc.addMailcap("text/html;; x-Java-content-handler=com.sun.mail.handlers.text_html");
//        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
//        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
//        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
//        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
//        CommandMap.setDefaultCommandMap(mc);
//        //发送邮件
//        emailSender.sendEmail("smtp.sohu.com", "cloudclass@sohu.com", "cloudclass123456");
//    }
}

