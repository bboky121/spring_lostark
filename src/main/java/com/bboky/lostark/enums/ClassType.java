package com.bboky.lostark.enums;

import java.util.Arrays;

public enum ClassType {
    /* 전사 */
    WARRIOR("전사(남)", "warrior.png"),
    DESTROYER("디스트로이어", "destroyer.png"),
    WARLOAD("워로드", "warlord.png"),
    BERSERKER("버서커", "berserker.png"),
    HOLYKNIGHT("홀리나이트", "holyknight.png"),

    /* 전사(여) */
    WARRIOR_FEMAIL("전사(여)", "warrior_female.png"),
    SLAYER("슬레이어", "berserker_female.png"),

    /* 무도가 */
    FIGHTER("무도가", "fighter.png"),
    BATTLE_MASTER("배틀마스터", "battle_master.png"),
    INFIGHTER("인파이터", "infighter.png"),
    LANCE_MASTER("창술사", "lance_master.png"),
    FORCE_MASTER("기공사", "force_master.png"),
    FIGHTER_MALE("무도가(남)", "fighter_male.png"),
    STRIKER("스트라이커", "striker.png"),

    /* 헌터 */
    HUNTER("헌터(남)", "hunter.png"),
    DEVIL_HUNTER("데빌헌터", "devil_hunter.png"),
    BLASTER("블래스터", "blaster.png"),
    HAWK_EYE("호크아이", "hawk_eye.png"),
    SCOUTER("스카우터", "scouter.png"),

    /* 헌터 (여) */
    HUNTER_FEMAIL("헌터(여)", "hunter_female.png"),
    GUNSLINGER("건슬링어", "devil_hunter_female.png"),

    /* 마법사 */
    MAGICIAN("마법사", "magician.png"),
    BARD("바드", "bard.png"),
    ARCANA("아르카나", "arcana.png"),
    SORCERESS("소서리스", "elemental_master.png"),
    SUMMONER("서머너", "summoner.png"),

    /* 암살자 */
    ASSASSIN("암살자", "assassin.png"),
    BLADE("블레이드", "blade.png"),
    DEMONIC("데모닉", "demonic.png"),
    REAPER("리퍼", "reaper.png"),

    /* 스페셜리스트 */
    SPECIAL_LIST("스페셜리스트", "special_list.png"),
    ARTIST("도화가", "yinyangshi.png"),
    AEROMANCER("기상술사", "weather_artist.png");

    private final String className;
    private final String imageName;

    ClassType(String className, String imageName) {
        this.className = className;
        this.imageName = imageName;
    }

    public static ClassType findByClassName(String className) {
        return Arrays.stream(ClassType.values())
                .filter(classType -> className.equals(classType.className))
                .findFirst().get();
    }

    public String getImageName() {
        return this.imageName;
    }

}
