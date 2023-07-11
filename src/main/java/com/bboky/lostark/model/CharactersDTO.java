package com.bboky.lostark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CharactersDTO {
    String ServerName;
    String CharacterName;
    int CharacterLevel;
    String CharacterClassName;
    String ItemAvgLevel;
    String ItemMaxLevel;
    String Image;

}
