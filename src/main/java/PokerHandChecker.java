import java.util.HashMap;
import java.util.Map;

public class PokerHandChecker
{
    private String hand = "High Card";

    /**
     * This method is used to return the best hand possible from the cards given.
     * @return hand - the best hand possible with the cards supplied.
     */
    public String BestHand()
    {
        return hand;
    }

    /**
     * This method is used to check a string array of cards given for the best possible hand.
     * @param cards - String array filled with the details of 5 cards.
     */
    public void checkHand(String[] cards)
    {
        Boolean isStraight = false;
        Boolean isFlush = false;
        Map<String, Integer> numberOfCardRanks = new HashMap<String, Integer>();
        Map<String, Integer> numberOfCardSuits = new HashMap<String, Integer>();
        for (String card : cards)
        {
            populateCardRankMap(card, numberOfCardRanks);
            populateCardSuitMap(card, numberOfCardSuits);
        }
        if(numberOfCardRanks.containsValue(2))
        {
            hand = "Pair";
        }

    }

    private void populateCardSuitMap(String card, Map<String, Integer> numberOfCardSuits)
    {
        String cardSuit = card.substring(card.length()-1, card.length());
        populateCardMap(numberOfCardSuits, cardSuit);
    }

    private void populateCardRankMap(String card, Map<String, Integer> numberOfCardRanks)
    {
        String cardRank = card.substring(0, card.length()-1);
        populateCardMap(numberOfCardRanks, cardRank);
    }

    private void populateCardMap(Map<String, Integer> numberOfCard, String keyToCount)
    {
        if(numberOfCard.containsKey(keyToCount))
        {
            int count = numberOfCard.get(keyToCount);
            numberOfCard.put(keyToCount,++count);
        }
        else
        {
            numberOfCard.put(keyToCount,1);
        }
    }

}
