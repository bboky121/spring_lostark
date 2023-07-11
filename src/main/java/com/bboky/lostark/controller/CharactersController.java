package com.bboky.lostark.controller;


import com.bboky.lostark.config.LostarkProperties;
import com.bboky.lostark.service.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/characters")
public class CharactersController {

    @Autowired
    LostarkProperties lostarkProperties;

    @Autowired
    Characters characters;
    
    @GetMapping("")
    public String index(Model model) {
        System.out.println("index");
        return "characters/index";
    }

    @GetMapping("/siblings")
    public String getCharacters(@RequestParam("name") String characterName, Model model) {
        HashMap sliblings = characters.getCharacters(characterName);

        model.addAttribute("title", characterName);
        model.addAttribute("name", characterName);
        model.addAttribute("siblings", sliblings);

        return "characters/index";
    }

    @GetMapping("/info")
    public String getCharacter(@RequestParam("name") String characterName, Model model) {

        return "characters/info";
    }
}