package com.codecool.src.Model;

public class RandomWordsGenerator {


String[] wordsWith6Letters = {"avenue", "killer", "random", "member", "unlike", "fickle", "choose", "retain", "shiver",
        "bomber", "bitter", "strong", "ribbon", "pants", "deadly", "resign", "deport", "reject", "create", "banana"};

String[] wordsWith10Letters = {"repetition", "occupation", "gregarious", "revolution", "engagement", "multimedia",
        "atmosphere", "correspond", "confidence", "experiment", "dependence", "appearance", "obligation", "hypothesis",
        "conference", "deficiency", "generation", "appreciate", "retirement", "compliance"};

String[] wordsWith12Letters = {"constituency", "reproduction", "interference", "headquarters", "conversation",
        "jurisdiction", "refrigerator", "discriminate", "circumstance", "architecture", "conventional", "intervention",
        "accumulation", "satisfaction", "manufacturer", "intelligence", "contribution", "disagreement", "presentation",
        "registration"};

        public String chooseDifficulty(String difficulty) {

                switch (difficulty) {
                        case "easy":
                                return getWord(wordsWith6Letters);
                        case "medium":
                                return getWord(wordsWith10Letters);
                        case "hard":
                                return getWord(wordsWith12Letters);
                        default:
                                return "";
                }
        }

        public String getWord(String[] listOfWords) {
                String randomWord = listOfWords[(int) (Math.random() * listOfWords.length)];
                System.out.println(randomWord);
                return randomWord;
        }

}

