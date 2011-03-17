/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.techingen.twentyatmailhandlerservice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import net.sf.json.JSONObject;

/**
 * REST Web Service
 *
 * @author root
 */

@Path("MailHandlerService")
public class MailHandlerServiceResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of MailHandlerServiceResource */
    public MailHandlerServiceResource() {
    }

    /**
     * Retrieves representation of an instance of com.techingen.twentyatmailhandlerservice.MailHandlerServiceResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "{message:ok}";
    }

    /**
     * PUT method for updating or creating an instance of MailHandlerServiceResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }


    @POST
    @Consumes("application/*")
    @Produces("application/json")
    public String handleMail(@FormParam("from")String from,@FormParam("sender")String sender,@FormParam("recipient")String recipient,@FormParam("subject")String subject,@FormParam("body-plain")String bodyPlain,@FormParam("body-html")String bodyHtml){
        Email email=new Email(from,sender,recipient,subject,bodyPlain,bodyHtml);
        JSONObject obj=JSONObject.fromObject(email);
        try{
        File file =new File("MailHandlerServiceResource.log");
        PrintWriter out=new PrintWriter(file);
        out.print(obj.toString());


        out.print("Before sending msg to XMPP");
        MailHandler mailHandler=new MailHandler();
        mailHandler.forwardMail(email);
        out.print("After sending msg to XMPP");
        out.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return obj.toString();



    }
}
