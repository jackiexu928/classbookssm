package com.jackie.classbook.util;

import com.jackie.classbook.entity.MailBean;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/17
 */
public class SendMail {
    private static final String USERNAME = "jackiemagic@sina.com";
    private static final String PASSWORD = "xujinjing514123";
    private static final String HOST = "smtp.sina.com";

    public String toChinese(String text) {
        try {
            text = MimeUtility.encodeText(new String(text.getBytes(), "GB2312"), "GB2312", "B");//转化为中文，防止乱码
            /*text = MimeUtility.encodeText(new String(text.getBytes(), "UTF-8"), "UTF-8", "B");*/
        } catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }

    public  boolean sendMail(MailBean mb) {
        String to = mb.getTo();
        String subject = mb.getSubject();
        String content = mb.getContent();
        String fileName = mb.getFilename();
        Vector<String> file = mb.getFile();

        Properties props = System.getProperties();
        props.put("mail.smtp.host", HOST);//设置SMTP的主机
        props.put("mail.smtp.auth", "true");//需要经过验证

        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(USERNAME));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(toChinese(subject));

            Multipart mp = new MimeMultipart();
            MimeBodyPart mbpContent = new MimeBodyPart();
            mbpContent.setText(content);
            mp.addBodyPart(mbpContent);

            /**
             * 往邮件中添加附件
             */
            if (file != null){
                Enumeration<String> efile = file.elements();
                while (efile.hasMoreElements()){
                    MimeBodyPart mbpFile = new MimeBodyPart();
                    fileName = efile.nextElement().toString();
                    FileDataSource fds = new FileDataSource(fileName);
                    mbpFile.setDataHandler(new DataHandler(fds));
                    mbpFile.setFileName(toChinese(fds.getName()));
                    mp.addBodyPart(mbpFile);
                }
                System.out.println("添加成功");
            }
            msg.setContent(mp);
            msg.setSentDate(new Date());
            Transport.send(msg);
        } catch (MessagingException me){
            me.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MailBean mb = new MailBean();
        /*mb.setHost("smtp.sina.com");
        mb.setUsername("jackiemagic@sina.com");
        mb.setPassword("xujinjing514123");
        mb.setFrom("jackiemagic@sina.com");*/
        mb.setTo("343141195@qq.com");
        mb.setSubject("helloJackie");
        mb.setContent("附件");
        File file = new File("D:/My Documents/我的文档/Chrome下载/2018年3季度原始数据.csv");
        if (file.exists()) {
            mb.attachFile(file.getAbsolutePath()); // 往邮件中添加附件

            SendMail sm = new SendMail();
            System.out.println("正在发送邮件...");
            if (sm.sendMail(mb)) {
                System.out.println("发送成功!");
            } else {
                System.out.println("发送失败!");
            }
        } else {
            System.out.println("文件不存在！");
        }
    }
}
