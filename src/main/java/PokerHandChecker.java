import java.util.HashMap;
import java.util.Map;

public class PokerHandChecker
{
    private String hand = "High Card";
    public void checkHand(String[] cards)
    {
        Boolean isStraight = false;
        Boolean isFlush = false;
        Map numberOfCardRanks = new HashMap();
        Map numberOfCardSuits = new HashMap();
        for(int i=0;i<cards.length;i++)
        {

        }
    }

    public String BestHand()
    {
        return hand;
    }
}
