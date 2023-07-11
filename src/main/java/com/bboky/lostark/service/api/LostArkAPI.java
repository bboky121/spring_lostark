package com.bboky.lostark.service.api;


import com.bboky.lostark.config.LostarkProperties;
import com.bboky.lostark.model.CharactersDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class LostArkAPI {
    @Autowired
    private LostarkProperties lostarkProperties;

    public LostArkAPI() {
    }

    public List<CharactersDTO> getCharacter(String characterName) {
        String uri = lostarkProperties.getBaseurl() + String.format("/characters/%s/siblings", characterName);
        // Api call
        RestTemplate restTemplate = new RestTemplate();
        // header 설정을 위해 HttpHeader 클래스를 생성한 후 HttpEntity 객체에 넣어줍니다.
        HttpHeaders header = new HttpHeaders();
        header.set("accept", "application/json");
        header.set("authorization", String.format("bearer %s", lostarkProperties.getToken()));

        HttpEntity<String> entity = new HttpEntity<>(header);

        // exchange() 메소드로 api를 호출합니다.
        ResponseEntity<String> response = restTemplate.exchange(
            uri,
            HttpMethod.GET,
            entity,
            String.class
        );

        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<CharactersDTO>>(){}.getType();
        List<CharactersDTO> res = gson.fromJson(response.getBody(), collectionType);


        return !CollectionUtils.isEmpty(res) ? res : new ArrayList<>();
    }
}

