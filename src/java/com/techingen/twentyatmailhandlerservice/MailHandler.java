/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.techingen.twentyatmailhandlerservice;

import com.techingen.twentyatmailhandlerservice.entity.Message;
import com.techingen.twentyatmailhandlerservice.entity.Recipient;
import com.techingen.twentyatmailhandlerservice.entity.TwentyatUser;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jivesoftware.smack.XMPPConnection;

/**
 *
 * @author root
 */
public class MailHandler {
    private Email email;
    public void forwardMail(Email email){
    this.email=email;
    File file=new File("/root/Desktop/MailHandler.log");
    PrintWriter out=null;
    try{
    out=new PrintWriter(file);
    
    HibernateUtil hu=new HibernateUtil();
    SessionFactory sf=hu.getSessionFactory();
    Session session=sf.openSession();
    String hql="from Message message where message.messageId="+email.getSubject().split(":")[1];
    out.print(hql);
    Query query=session.createQuery(hql);
    List<Message>lstMessages=query.list();
    Iterator<Message>iMessages=lstMessages.iterator();
    if(iMessages.hasNext()){
        Message message=iMessages.next();
        TwentyatUser recipient=message.getTwentyatUser();
        TwentyatUser sender;
        Set<Recipient>setSenders=message.getRecipients();
        Iterator<Recipient>iSenders=setSenders.iterator();
        sender=iSenders.next().getTwentyatUser();
        sendMessageToTwentyatUser(sender,recipient,email);
    }
    else{
     if(out!=null)  {
         out.print("Message with Id "+ email.getSubject()+" does not exist");
     } 
    }
  }
  catch(Exception ex){
      if(out!=null)
          ex.printStackTrace(out);
        
    }
    finally{
        if(out!=null){
            out.flush();
            out.close();
        }
    }
    }
    private void sendMessageToTwentyatUser(TwentyatUser sender,TwentyatUser recipient,Email email){
        File file=new File("/root/Desktop/MailHandlerSmack.log");
        PrintWriter out=null;
        try{
        //Login to XMPP using recipient credentials

        out=new PrintWriter(file);
        XMPPClient c = new XMPPClient();
        //XMPPConnection.DEBUG_ENABLED = true;
        String debug="Sender:"+sender.getUsername()+"|Recipient:"+recipient.getUsername()+":Message:"+email.getBodyPlain();
        out.append(debug);
        System.out.println(debug);
        out.append("Before Login");
        c.login(sender.getUsername(), "cloud");
        out.append("After Login");
        out.append("Before Send Message");
        c.sendMessage(recipient.getUsername(),email.getBodyPlain());
        c.sendMessage(recipient.getUsername(),email.getBodyPlain());
        c.sendMessage(recipient.getUsername(),email.getBodyPlain());
        c.sendMessage(recipient.getUsername(),email.getBodyPlain());
        c.sendMessage(recipient.getUsername(),email.getBodyPlain());
        out.append("After Send Message");
        c.disconnect();
        out.append("After Disconnect");
        //Send Message
        //Disconnect /close
        }
        catch(Exception ex){
            if(out!=null)
                ex.printStackTrace(out);
        }
        finally{
            if(out!=null)
                out.close();
        }
    }
}
