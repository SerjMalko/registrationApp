package com.sands.regtest.core.util;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Send email bean
 * Created by mass on 12.08.2016.
 */
@Stateless
public class EmailSenderBean {

    @Resource(name = "java:jboss/mail/gmail")
    private Session session;

    public void send(String addresses, String topic, String textMessage) {
        try {

            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
            message.setSubject(topic);
            message.setContent(textMessage, "text/html");

            Transport.send(message);

        } catch (MessagingException e) {
            Logger.getLogger(EmailSenderBean.class.getName()).log(Level.WARNING, "Cannot send mail", e);
        }
    }

}
