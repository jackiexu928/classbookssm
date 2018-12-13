package com.jackie.classbook.util;

import com.jackie.classbook.common.ClassbookException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
* 邮件发送
*
*/
public class EmailSender {
     private JavaMailSenderImpl javaMailSender;

     public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
          this.javaMailSender = javaMailSender;
     }

     /**
     * 发送纯文本格式的邮件
     *
     * @param to 收信人
     * @param title 主题
      * content 内容
     */
     public void sendText(String to, String title, String content) {

          MimeMessage message = javaMailSender.createMimeMessage();
          try {
               MimeMessageHelper helper = new MimeMessageHelper(message, true,
                         "UTF-8");
               helper.setFrom(javaMailSender.getUsername());
               helper.setTo(to);
               helper.setSubject(title);
               helper.setText(content, false);
               javaMailSender.send(message);
          } catch (Exception e) {
               //CollectionLog.getMessageLogger().error("发送纯文本邮件异常",e);
               throw new ClassbookException(e);
          }
     }

     /**
      * 发送Html格式邮件
      */
     public void sendHtmlMail(String to, String title, String content){
          MimeMessage msg = javaMailSender.createMimeMessage();
          try{
               MimeMessageHelper helper = new MimeMessageHelper(msg,"utf-8" );
               helper.setFrom(javaMailSender.getUsername());
               helper.setTo(to);

               helper.setSubject(title);
               helper.setText(content, true); // 邮件内容，参数true表示是html代码
               javaMailSender.send(msg);
          }catch (Exception e){
               //CollectionLog.getMessageLogger().error("发送Html格式邮件异常",e);
               throw new ClassbookException(e);
          }
     }
}
