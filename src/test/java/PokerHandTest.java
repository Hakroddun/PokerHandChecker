import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandTest
{
    private PokerHandChecker checker;
    private String[] cards;

    @Before
    public void setUp()
    {
        checker = new PokerHandChecker();
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
        checker.checkHand(cards);
    }

    @Test
    public void HighCard()
    {
        cards[0]="AS";
        cards[1]="2C";
        cards[2]="10H";
        cards[3]="6C";
        cards[4]="8S";
        checker.checkHand(cards);
        assertEquals("High Card", checker.getHand());
    }

    @Test
    public void Pair()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="3H";
        cards[3]="6C";
        cards[4]="8S";
        checker.checkHand(cards);
        assertEquals("Pair", checker.getHand());
    }

    @Test
    public void TwoPair()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="3H";
        cards[3]="3C";
        cards[4]="8S";
        checker.checkHand(cards);
        assertEquals("Two Pair", checker.getHand());
    }

    @Test
    public void ThreeOfAKind()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="AH";
        cards[3]="3C";
        cards[4]="8S";
        checker.checkHand(cards);
        assertEquals("Three Of A Kind", checker.getHand());
    }

    @Test
    public void Straight()
    {
        cards[0]="AS";
        cards[1]="2C";
        cards[2]="3H";
        cards[3]="4C";
        cards[4]="5S";
        checker.checkHand(cards);
        assertEquals("Straight", checker.getHand());
    }

    @Test
    public void RoyalStraight()
    {
        cards[0]="AS";
        cards[1]="10C";
        cards[2]="QH";
        cards[3]="JC";
        cards[4]="KS";
        checker.checkHand(cards);
        assertEquals("Straight", checker.getHand());
    }

    @Test
    public void Flush()
    {
        cards[0]="AS";
        cards[1]="5S";
        cards[2]="7S";
        cards[3]="8S";
        cards[4]="JS";
        checker.checkHand(cards);
        assertEquals("Flush", checker.getHand());
    }

    @Test
    public void FullHouse()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="AH";
        cards[3]="3C";
        cards[4]="3S";
        checker.checkHand(cards);
        assertEquals("Full House", checker.getHand());
    }

    @Test
    public void FourOfAKind()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="AH";
        cards[3]="AD";
        cards[4]="8S";
        checker.checkHand(cards);
        assertEquals("Four Of A Kind", checker.getHand());
    }

    @Test
    public void StraightFlush()
    {
        cards[0]="AS";
        cards[1]="2S";
        cards[2]="3S";
        cards[3]="4S";
        cards[4]="5S";
        checker.checkHand(cards);
        assertEquals("Straight Flush", checker.getHand());
    }

    @Test
    public void RoyalFlush()
    {
        cards[0]="AS";
        cards[1]="QS";
        cards[2]="JS";
        cards[3]="KS";
        cards[4]="10S";
        checker.checkHand(cards);
        assertEquals("Royal Flush", checker.getHand());
    }

}
