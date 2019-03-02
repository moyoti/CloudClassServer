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
        //��ַ
        this.properties.put("mail.smtp.host",host);
        //�˿ں�
        this.properties.put("mail.smtp.post",post);
        //�Ƿ���֤
        this.properties.put("mail.smtp.auth","true");
        this.session=Session.getInstance(properties);
        this.message = new MimeMessage(session);
        this.multipart = new MimeMultipart("mixed");
    }
    /**
     * �����ռ���
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
     * �����ʼ�
     * @param from ��Դ
     * @param title ����
     * @param content ����
     * @throws AddressException
     * @throws MessagingException
     */
    public void setMessage(String from,String title,String content) throws AddressException, MessagingException{
        this.message.setFrom(new InternetAddress(from));
        this.message.setSubject(title);
        //���ı��Ļ���setText()���У������и�������ʾ������������
        MimeBodyPart textBody = new MimeBodyPart();
        textBody.setText(content);
        this.multipart.addBodyPart(textBody);
    }
    /**
     * ��Ӹ���
     * @param filePath �ļ�·��
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
     * �����ʼ�
     * @param host ��ַ
     * @param account �˻���
     * @param pwd ����
     * @throws MessagingException
     */
    public void sendEmail(String host,String account,String pwd) throws MessagingException{
        //����ʱ��
        this.message.setSentDate(new Date());
        //���͵����ݣ��ı��͸���
        this.message.setContent(this.multipart);
        this.message.saveChanges();
        //�����ʼ����Ͷ��󣬲�ָ����ʹ��SMTPЭ�鷢���ʼ�
        Transport transport=session.getTransport("smtp");
        //��¼����
        transport.connect(host,account,pwd);
        //�����ʼ�
        transport.sendMessage(message, message.getAllRecipients());
        //�ر�����
        transport.close();
    }

    public void send(String title,String content,String[] receiver) throws MessagingException {
        //���÷�������ַ�Ͷ˿�
        setProperties("smtp.sohu.com", "25");
        //�ֱ����÷����ˣ��ʼ�������ı�����
        setMessage("cloudclass@sohu.com", title, content);
        //�����ռ���
        setReceiver(receiver);
        //��ý���������
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-Java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);
        //�����ʼ�
        System.out.println("send Email before");
        sendEmail("smtp.sohu.com", "cloudclass@sohu.com", "cloudclass123456");
        System.out.println("send Email after");
    }
//    public static void main(String[] args) throws MessagingException {
//        EmailSender emailSender = new EmailSender();
//        //���÷�������ַ�Ͷ˿�
//        emailSender.setProperties("smtp.sohu.com", "25");
//        //�ֱ����÷����ˣ��ʼ�������ı�����
//        emailSender.setMessage("cloudclass@sohu.com", "Test Message", "test email send");
//        //�����ռ���
//        emailSender.setReceiver(new String[]{"dqh_ql@163.com"});
//        //��ý���������
//        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
//        mc.addMailcap("text/html;; x-Java-content-handler=com.sun.mail.handlers.text_html");
//        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
//        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
//        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
//        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
//        CommandMap.setDefaultCommandMap(mc);
//        //�����ʼ�
//        emailSender.sendEmail("smtp.sohu.com", "cloudclass@sohu.com", "cloudclass123456");
//    }
}

