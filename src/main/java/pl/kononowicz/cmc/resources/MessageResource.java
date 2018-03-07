/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kononowicz.cmc.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import pl.kononowicz.cmc.entities.Message;
import pl.kononowicz.cmc.servlet.MessagesContext;

/**
 *
 * @author Tomasz
 */
@Path("/messages")
public class MessageResource {
    public static final String MESSAGES_CONTEXT = "messageContext";
    
    @Context
    ServletContext context;

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;
    
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> listMessages(@DefaultValue("all") @QueryParam("region") String region, @DefaultValue("all") @QueryParam("priority") String priority) {
        List<Message> all = getMessagesContext().getMessages();
        List<Message> result = new ArrayList<>();
        for (Message m : all) {
            if ((region.equals(m.getRegion()) || region.equals("all")) && (priority.equals(m.getPriority().toString()) || priority.equals("all")))
                result.add(m);
        }
        Collections.sort(result);
        return result;
    }
    
        private MessagesContext getMessagesContext() {
        MessagesContext messagesContext = (MessagesContext) context.getAttribute(MESSAGES_CONTEXT);
        if (messagesContext == null) {
            messagesContext = new MessagesContext();
            context.setAttribute(MESSAGES_CONTEXT, messagesContext);
        }
        return messagesContext;
    }
    
}
   
    
