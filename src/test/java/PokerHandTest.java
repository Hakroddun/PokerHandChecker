import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandTest
{
    private PokerHandChecker ch;
    private String[] cards;

    @Before
    public void setUp()
    {
        ch = new PokerHandChecker();
        cards = new String[5];
    }

    @Test
    public void canCheckPokerHand()
    {
        cards[0]="AS";
        cards[1]="2C";
        cards[2]="10H";
        cards[3]="6C";
        cards[4]="8S";
        ch.checkHand(cards);
    }

    @Test
    public void HighCard()
    {
        cards[0]="AS";
        cards[1]="2C";
        cards[2]="10H";
        cards[3]="6C";
        cards[4]="8S";
        ch.checkHand(cards);
        assertEquals("High Card",ch.BestHand());
    }

    @Test
    public void Pair()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="3H";
        cards[3]="6C";
        cards[4]="8S";
        ch.checkHand(cards);
        assertEquals("Pair",ch.BestHand());
    }

    @Test
    public void TwoPair()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="3H";
        cards[3]="3C";
        cards[4]="8S";
        ch.checkHand(cards);
        assertEquals("Two Pair",ch.BestHand());
    }

}
