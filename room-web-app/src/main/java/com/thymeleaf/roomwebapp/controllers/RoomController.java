/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.controllers;

import com.thymeleaf.roomwebapp.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

   @GetMapping
    public String getAllRooms(Model model){
        model.addAttribute("rooms",roomService.getAllRooms());
        return "rooms";
   }





}
