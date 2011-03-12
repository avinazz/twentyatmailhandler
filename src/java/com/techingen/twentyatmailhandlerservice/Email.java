/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.techingen.twentyatmailhandlerservice;
/**
 *
 * @author root
 */
public class Email {
private String from;
private String sender;
private String recipient;
private String subject;
private String bodyPlain;
private String bodyHtml;

public Email(){
}
public Email(String from,String sender,String recipient,String subject, String bodyPlain,String bodyHtml){
    this.from=from;
    this.sender=sender;
    this.recipient=recipient;
    this.subject=subject;
    this.bodyPlain=bodyPlain;
    this.bodyHtml=bodyHtml;

}

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the recepient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * @param recepient the recepient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the bodyPlain
     */
    public String getBodyPlain() {
        return bodyPlain;
    }

    /**
     * @param bodyPlain the bodyPlain to set
     */
    public void setBodyPlain(String bodyPlain) {
        this.bodyPlain = bodyPlain;
    }

    /**
     * @return the bodyHtml
     */
    public String getBodyHtml() {
        return bodyHtml;
    }

    /**
     * @param bodyHtml the bodyHtml to set
     */
    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

}
