package fr.mai.ntiers.service.implemente;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mai.ntiers.dto.MessageDto;
import fr.mai.ntiers.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MessageEvent extends TextWebSocketHandler {


    @Autowired
    MessageService messageService;

    Map<String,WebSocketSession> utilisateurs =new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("une connection recu ");
    }


    private static MessageEvent messageEvent=null;

    public static MessageEvent getinstance()
    {
        if(messageEvent==null)
        {
            messageEvent=new MessageEvent();
            return messageEvent;
        }
        else
        {
            return messageEvent;
        }

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("push " +message.getPayload().toString());
       ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> mapMessage = mapper.readValue(message.getPayload().toString(), Map.class);
        boolean isSubscribe=false;
        boolean isMessage=false;
        boolean isImage=false;
        System.out.println("un message recu ");
        if(mapMessage.get("isSubscribe")!=null) {
            isSubscribe = (boolean) mapMessage.get("isSubscribe");
        }

        if(mapMessage.get("isMessage")!=null)
            isMessage= (boolean)mapMessage.get("isMessage");

        if(mapMessage.get("isImage")!=null)
        {
    isImage=true;
        }
        if(isMessage)
        {
            System.out.println("c'est un message  recu ");
            String contenu = ( String) mapMessage.get("contenu");
            String idSource = ( String) mapMessage.get("idSource");
            String idDestination = ( String) mapMessage.get("idDestination");
            MessageDto messageDto=new MessageDto();
            messageDto.setContenu(contenu);
            messageDto.setIdSource(idSource);
            messageDto.setIdDestination(idDestination);
            if(!isImage)
            messageService.envoieMessage(messageDto);
            notifierReceptionMessage(messageDto,isImage);
        }

        if (isSubscribe)
        {
            String idcompte = ( String) mapMessage.get("idCompte");
            log.info("Une inscription recu "+idcompte);

            this.utilisateurs.put(idcompte,session);

        }

    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

    }

    public void notifierReceptionMessage(MessageDto message,boolean isImage) throws IOException {
        log.info("je vais notifier ! " + message.getIdDestination());
        String isImageTrue=isImage?",\"isImage\":true":"";
        TextMessage notification=new TextMessage("{\"isNewMessage\":true,\"idSource\":\""+message.getIdSource()+"\",\"contenu\":\""+message.getContenu()+"\""+isImageTrue+"}");
        if(this.utilisateurs.get(message.getIdDestination())!=null){
                this.utilisateurs.get(message.getIdDestination()).sendMessage(notification);
            log.info("je vais notifier !! 2 ");}
    }

}
