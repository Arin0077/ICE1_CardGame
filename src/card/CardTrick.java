package card;


import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Arin Sharma
 */

public class CardTrick {
    public static void main(String[] args) {
        // Initialize the magic hand array
        Card[] magicHand = new Card[7];
        
        // Fill the hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            
            // Generate random value (1-13)
            int randomValue = 1 + (int)(Math.random() * 13);
            c.setValue(randomValue);
            
            // Generate random suit (0-3)
            int randomSuit = (int)(Math.random() * 4);
            c.setSuit(Card.SUITS[randomSuit]);
            
            // Important: Store the card in the array
            magicHand[i] = c;
            
            // Print the generated card (for testing)
            System.out.println("Generated card " + (i+1) + ": " + 
                             c.getValue() + " of " + c.getSuit());
        }
        
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nPick a card, any card!");
        System.out.print("Enter a card value (1-13, where 1=Ace, 11=Jack, 12=Queen, 13=King): ");
        int userValue = scanner.nextInt();
        
        System.out.println("Enter a suit:");
        System.out.println("0 = Hearts");
        System.out.println("1 = Diamonds");
        System.out.println("2 = Spades");
        System.out.println("3 = Clubs");
        System.out.print("Your choice: ");
        int userSuit = scanner.nextInt();
        
        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);
        
        // Search for the card
        boolean found = false;
        for (Card card : magicHand) {
            if (card != null && 
                card.getValue() == userCard.getValue() && 
                card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        // Report result
        System.out.println("\nYour card is: " + userCard.getValue() + " of " + userCard.getSuit());
        if (found) {
            System.out.println("Your card was found in the magic hand!");
        } else {
            System.out.println("Sorry, your card wasn't in the magic hand.");
        }
    }
}
