package com.bboky.lostark.service;

import com.bboky.lostark.config.LostarkProperties;
import com.bboky.lostark.enums.ClassType;
import com.bboky.lostark.model.CharactersDTO;
import com.bboky.lostark.service.api.LostArkAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Characters {

    @Autowired
    private LostArkAPI lostArkAPI;

    @Autowired
    private LostarkProperties lostarkProperties;

    public HashMap<String, List<CharactersDTO>> getCharacters(String characterName) {
        List<CharactersDTO> characters = lostArkAPI.getCharacter(characterName);
        return sortByLevel(sortByServer(characters));
    }

    //서버별 정렬
    private HashMap<String, List<CharactersDTO>> sortByServer(List<CharactersDTO> characters) {
        HashMap<String, List<CharactersDTO>> result = new HashMap<>();
        for (CharactersDTO characterInfo : characters) {
            List<CharactersDTO> serverCharacters = new ArrayList<>();
            if (result.containsKey(characterInfo.getServerName())) {
                serverCharacters = result.get(characterInfo.getServerName());
            }
            String imagePath = lostarkProperties.getCdnUrl() +
                ClassType.findByClassName(characterInfo.getCharacterClassName()).getImageName();
            characterInfo.setImage(imagePath);

            serverCharacters.add(characterInfo);
            result.put(characterInfo.getServerName(), serverCharacters);
        }
        return result;
    }

    //레벨별 정렬
    private HashMap<String, List<CharactersDTO>> sortByLevel(HashMap<String, List<CharactersDTO>> characters) {
        for (Map.Entry<String, List<CharactersDTO>> entry : characters.entrySet()) {
            List<CharactersDTO> filteredList = entry.getValue().stream().sorted(
                Comparator.comparing(CharactersDTO::getItemMaxLevel).reversed()
            ).collect(Collectors.toList());
            characters.put(entry.getKey(), filteredList);
        }
        return characters;
    }
}
