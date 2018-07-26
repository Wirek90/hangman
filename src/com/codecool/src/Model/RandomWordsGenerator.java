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

String[] meme = {"harambe", "grumpy-cat", "doge", "chuck-norris", "angry-german-kid", "achmed-the-dead-terrorist",
        "nonono-cat", "epic-fail", "good-guy-greg", "u-mad-bro", "crying-jordan", "philosoraptor", "this-is-sparta",
        "flex-tape-guy"};

String[] cars = {"ferrari", "seat", "bmw", "toyota", "mazda", "mercedes", "skoda", "fiat", "range-rover", "bentley",
        "jeep", "lamborgini", "tata", "nissan", "audi", "volksvagen", "kia", "saab", "citroen", "peugeot", "alfa-romeo",
        "ssangyong"};

        public String chooseRandomWord(String type) {

                switch (type) {
                        case "easy":
                                return getWord(wordsWith6Letters);
                        case "medium":
                                return getWord(wordsWith10Letters);
                        case "hard":
                                return getWord(wordsWith12Letters);
                        case "meme":
                                return getWord(meme);
                        case "cars":
                                return getWord(cars);
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

