import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class PokerHandChecker
{
    private String hand = "High Card";
    private boolean isStraight = false;
    private boolean isFlush = false;
    private boolean hasThreeOfAKind = false;
    private int numberOfPairs = 0;
    private Map<Integer, Integer> numberOfCardRanks = new TreeMap<>();
    private Map<String, Integer> numberOfCardSuits = new TreeMap<>();

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
        sortCardsIntoRankAndSuitMaps(cards);
        checkAggregatedValuesOfRanks();
        checkIfStraight();

        if(isStraight)
        {
            hand = "Straight";
        }
        else if(hasThreeOfAKind)
        {
            hand = "Three Of A Kind";
        }
        else if(numberOfPairs == 2)
        {
            hand = "Two Pair";
        }
        else if(numberOfPairs == 1)
        {
            hand = "Pair";
        }

    }

    private void checkIfStraight()
    {
        Integer[] arr = numberOfCardRanks.keySet().toArray(new Integer[numberOfCardRanks.size()]);
        int count = 1;
        for(int i=0; i<arr.length-1; i++)
        {
            if((arr[i+1]-1) == arr[i])
            {
                count++;
            }
            else
            {
                count=1;
            }
            if(count == arr.length)
            {
                isStraight = true;
            }
        }
    }

    /**
     * Sorts the cards according to suit and rank into two hashmaps.
     * These hashmaps are used to to extract aggregate values for processing.
     * @param cards - String array filled with the details of 5 cards.
     */
    private void sortCardsIntoRankAndSuitMaps(String[] cards)
    {
        for (String card : cards)
        {
            populateCardRankMap(card);
            populateCardSuitMap(card);
        }
    }

    /**
     * This checks card ranks for levels of aggregation ie. pairs, three of a kind or four of a kind
     */
    private void checkAggregatedValuesOfRanks()
    {
        Collection<Integer> rankCollection = numberOfCardRanks.values();
        for (Integer countOfRank : rankCollection)
        {
            if (countOfRank == 3)
            {
                hasThreeOfAKind = true;
            }
            else if(countOfRank == 2)
            {
                numberOfPairs++;
            }
        }
    }

    private void populateCardSuitMap(String card)
    {
        String cardSuit = card.substring(card.length()-1, card.length());
        numberOfCardSuits.compute(cardSuit, (key, value) -> value == null ? 1 : value + 1);
    }

    private void populateCardRankMap(String card)
    {
        int cardRankValue = getCardRankValue(card);
        numberOfCardRanks.compute(cardRankValue, (key, value) -> value == null ? 1 : value + 1);
    }

    private int getCardRankValue(String card)
    {
        int cardRankValue;
        String cardRank = card.substring(0, card.length()-1).toUpperCase();
        switch (cardRank)
        {
            case "A":
                cardRankValue = 1;
                break;
            case "J":
                cardRankValue = 11;
                break;
            case "Q":
                cardRankValue = 12;
                break;
            case "K":
                cardRankValue = 13;
                break;
            default:
                cardRankValue = Integer.parseInt(cardRank);
                break;
        }
        return cardRankValue;
    }

}
