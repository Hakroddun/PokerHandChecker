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
        assertEquals("High Card",ch.getHand());
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
        assertEquals("Pair",ch.getHand());
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
        assertEquals("Two Pair",ch.getHand());
    }

    @Test
    public void ThreeOfAKind()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="AH";
        cards[3]="3C";
        cards[4]="8S";
        ch.checkHand(cards);
        assertEquals("Three Of A Kind",ch.getHand());
    }

    @Test
    public void Straight()
    {
        cards[0]="AS";
        cards[1]="2C";
        cards[2]="3H";
        cards[3]="4C";
        cards[4]="5S";
        ch.checkHand(cards);
        assertEquals("Straight",ch.getHand());
    }

    @Test
    public void RoyalStraight()
    {
        cards[0]="AS";
        cards[1]="10C";
        cards[2]="QH";
        cards[3]="JC";
        cards[4]="KS";
        ch.checkHand(cards);
        assertEquals("Straight",ch.getHand());
    }

    @Test
    public void Flush()
    {
        cards[0]="AS";
        cards[1]="5S";
        cards[2]="7S";
        cards[3]="8S";
        cards[4]="JS";
        ch.checkHand(cards);
        assertEquals("Flush",ch.getHand());
    }

    @Test
    public void FullHouse()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="AH";
        cards[3]="3C";
        cards[4]="3S";
        ch.checkHand(cards);
        assertEquals("Full House",ch.getHand());
    }

    @Test
    public void FourOfAKind()
    {
        cards[0]="AS";
        cards[1]="AC";
        cards[2]="AH";
        cards[3]="AD";
        cards[4]="8S";
        ch.checkHand(cards);
        assertEquals("Four Of A Kind",ch.getHand());
    }

    @Test
    public void StraightFlush()
    {
        cards[0]="AS";
        cards[1]="2S";
        cards[2]="3S";
        cards[3]="4S";
        cards[4]="5S";
        ch.checkHand(cards);
        assertEquals("Straight Flush",ch.getHand());
    }

    @Test
    public void RoyalFlush()
    {
        cards[0]="AS";
        cards[1]="QS";
        cards[2]="JS";
        cards[3]="KS";
        cards[4]="10S";
        ch.checkHand(cards);
        assertEquals("Royal Flush",ch.getHand());
    }

}
