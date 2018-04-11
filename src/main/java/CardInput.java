import java.util.Scanner;

public class CardInput
{
    public static void main(String[] args)
    {
        PokerHandChecker checker = new PokerHandChecker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cards in the format of rank then suit ie. 10C = 10 of clubs");
        System.out.println("Enter your cards separated by a comma: ");
        String[]cards = scanner.nextLine().replaceAll("\\s*","").split(",");
        checker.checkHand(cards);
        System.out.println(checker.getHand());
    }
}
