/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thymeleaf.roomwebapp.models.Room;
import com.thymeleaf.roomwebapp.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoomCleanerListener {
    private static final Logger LOG= LoggerFactory.getLogger(RoomCleanerListener.class);
    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String messsage){
        try{
            AsyncPayload payload=mapper.readValue(messsage,AsyncPayload.class);
            if("ROOM".equals(payload.getModel())){
                Room room=roomService.getById(payload.getId());
                LOG.info("ROOM {}:{} needs to be cleand",room.getNumber(),room.getName());
            }
            else{
                LOG.warn("Unknown Model type");
            }
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}

