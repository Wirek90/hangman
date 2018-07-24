package Model;

public class RandomWordsGenerator {


String[] wordsWith6Letters = {"avenue", "killer", "harass", "member", "unlike", "mosque", "choose", "retain", "shiver",
        "bomber", "bitter", "strong", "ribbon", "mother", "deadly", "resign", "deport", "reject", "create", "banana"};

String[] wordsWith10Letters = {"repetition", "occupation", "gregarious", "revolution", "engagement", "multimedia",
        "atmosphere", "correspond", "confidence", "experiment", "dependence", "appearance", "obligation", "hypothesis",
        "conference", "deficiency", "generation", "appreciate", "retirement", "compliance"};

String[] wordsWith12Letters = {"constituency", "reproduction", "interference", "headquarters", "conversation",
        "jurisdiction", "refrigerator", "discriminate", "circumstance", "architecture", "conventional", "intervention",
        "accumulation", "satisfaction", "manufacturer", "intelligence", "contribution", "disagreement", "presentation",
        "registration"};

        public String chooseThis(String difficulty) {

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

        public String getWord(String[] list_Of_Words) {
                String randomWord = list_Of_Words[(int) (Math.random() * list_Of_Words.length)];
                System.out.println(randomWord);
                return randomWord;
        }

}

