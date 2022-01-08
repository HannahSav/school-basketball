package com.example.spring_jpa_gradle.loader;

import com.example.spring_jpa_gradle.data.Team;
import java.util.Random;

public class TeamGenerator {

    private static final int NAME_LENGTH = 10;
    private static final Random random = new Random();
    private static final String cyrillicCharacters = "АБВГДЕЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
    private static final String[] schoolTypes = {"СОШ", "Лицей", "Гимназия", "Церковно-Приходская школа"};

    private static String generateRandomCyrillicCharacter() {
        int randomCharIndex = random.nextInt(cyrillicCharacters.length());
        return String.valueOf(cyrillicCharacters.charAt(randomCharIndex));
    }

    private static String generateRandomString(int targetStringLength) {
        int leftLimit = 97;         // letter 'a'
        int rightLimit = 122;       // letter 'z'

        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private static int generateRandomInteger(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Team generate_team() {
        Team next = new Team();
        next.setName(generateRandomString(NAME_LENGTH));
        next.setSchool(schoolTypes[random.nextInt(schoolTypes.length)] + " " + generateRandomInteger(1, 500));
        next.setClass_group(generateRandomInteger(1, 11) + generateRandomCyrillicCharacter());
        return next;
    }
}
