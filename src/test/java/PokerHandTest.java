
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PokerHandTest
{
    private PokerHandChecker ch;

    @Before
    public void setUp()
    {
        ch = new PokerHandChecker();
    }

    @Test
    public void canCheckPokerHand()
    {
        ch.checkHand("","","","","");
    }

    @Test
    public void HighCard()
    {
        ch.checkHand("AS","2C","3H","6C","8S");
        assertEquals("High Card",ch.BestHand());
    }

    @Test
    public void Pair()
    {
        ch.checkHand("AS","AC","3H","6C","8S");
        assertEquals("Pair",ch.BestHand());
    }

}
