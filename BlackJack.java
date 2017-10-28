/*
 * @author Jonathon Thach
 * @date October 29, 2017
 * 
 * Pseudocode: The program will play blackjack with user; user gets to see instructions; program draws the cards for user and dealer; asks user to keep drawing cards or not;
 *	ask uses to give value to ace card; finds total of user and dealer; compares results and figures out which one meets the win requirement; display results; asks user if they want to play again;
 *	if user says yes, program replays; if user says no, program ends;
 */

import java.util.*; // import scanner

public class BlackJack { // start of class
	
	// List of Global Variables 
	
	public static int win = 0; // win ratio
	public static int lost = 0; // lost ratio
	public static int tie = 0; // tie ratio
	public static int total = 0; // user total
	public static int dealerTotal = 0; // dealer total
	public static String answer = "Hit"; // starts or stops the loops
	public static int brain = 0; // biggest loop int
	public static int first2Cards = 0; // first2Cards loop int
	public static Scanner scan = new Scanner(System.in); // global scanner; no need to keep declaring scanners
	// Allows me to store and call variables easily
	
	public static void main(String[] a) { // main method
		// will display instructions
		displayInstructions();
		// displays drawCards and then determine Winner
		determineWinner();
	}

	public static void displayInstructions() { // instruction method

		System.out.println("Bonjour, this is the instructions for Blackjack." // welcome message; vingt-et-un
				+ "\n____________________________________________\n"); // cosmetic effect
		
		System.out.println( // actual instructions
				"> The goal of blackjack is to reach a number that is closer to 21 through the use of your total card amount, while also making sure you don't go over 21.\n"
				+ "\n1) The dealer draws two cards for you and themself."
				+ "\n2) You can choose to Hit (pick a new card) or Stay (stop picking cards), and from there the dealer will choose to do the same until they reach a number greater than 16."
				+ "\n   > Also, if you draw an Ace, you'll be able to decide if they should count as a 1 or 11 and face cards are equal to 10."
				+ "\n3) Next the dealer will compare his hand's total and your tand's total and figure out who is closer to 21 without going over. The winner will be anyone that fits this description.\n"
				+ "\n> The only other outcome than a win or a lost is a tie, a tie is reach when both parties' hand is above 21 or you two get the same number."
				+ "> Now you're ready to play Blackjack, goodluck."
				+ "\n____________________________________________\n"); // cosmetic effect

	} // end of instruction method
	public static void drawCards() { // cards method

		String card = "0"; // stores cards value

		for (; brain < 1;) { // biggest loop; decides if the program should run or not
			for (; first2Cards < 4;) { // Loops 4 times
				double rand = (int) (Math.random() * (13 - 1 + 1) + 1); // random number generator for the cards

				if (first2Cards == 0) { // loop 0
					int draw1 = (int) rand; // sets draw to the random number
					System.out.println("You drew: " + draw1); // prints outcome
					total += rand; // adds the rand number to total
				} else if (first2Cards == 1) { // loop 1
					int draw2 = (int) rand; // sets draw to the random number
					System.out.println("You drew: " + draw2); // prints outcome
					total += rand; // adds the rand number to total
				} else if (first2Cards == 2) { // loop 2
					int draw3 = (int) rand; // sets draw to the random number
					System.out.println("Dealer drew: " + draw3); // prints outcome
					dealerTotal += rand;  // adds the rand number to dealer's total
				} else if (first2Cards == 3) { // loop 3
					int draw4 = (int) rand; // sets draw to the random number
					System.out.println("Dealer drew: " + draw4); // prints outcome
					dealerTotal += rand; // adds the rand number to dealer's total
				} // end of if-statement

				first2Cards++; // increase's it's value; allowing the loop to stop

			} // end of for loop; first2Cards

			++brain; // Ensure the lines 81, 82, 83 doesn't loop; EXTREMELY IMPORTANT!
			Scanner scan = new Scanner(System.in);
			System.out.println("Would you like to Hit or Stay?"); // prompts the user to draw a card or not
			answer = scan.nextLine(); // takes the answer

			for (int draw = 0; draw < 1;) { // drawCard loop;
				double rand = (int) (Math.random() * (13 - 1 + 1) + 1); // random number generator for the cards
				int deckOfCards = (int) rand; // sets the int to the random number

				if (answer.equalsIgnoreCase("Hit")) { // if they continue
					System.out.println("Drawing a card."); // tells them the dealer is drawing a card for them
				} // end of if statement
				
				if (rand == 1) { // if 1
					card = "ace"; // tells user its an ace
				} else if (rand > 1 && rand < 11) { // if 2 - 10
					card = Double.toString(rand); // tells user its value
				} else if (rand == 11) { // if 11
					deckOfCards = 10; // sets its value
					card = "Jack"; // tells user its a Jack

				} else if (rand == 12) { // if 12
					deckOfCards = 10; // sets its value
					card = "Queen"; // tells user its a Queen

				} else if (rand == 13) { // if 13
					deckOfCards = 10; // sets its value
					card = "King"; // tells user its a King
				}// end of if statement
				
				if (answer.equalsIgnoreCase("Hit")) {// if they continue
					System.out.println(card); // tells card 
					System.out.println("Would you like to go again?"); // asks user if they want to Hit again
					answer = scan.nextLine(); // takes input

					if (card == "ace") { // if the card is an ace
						System.out.println("Would you like the ace to represent an 1 or 11?"); // asks user to give it a value of 1 or 11
						int aceInTheHole = scan.nextInt(); // takes input
						if (aceInTheHole == 1) { // if input = 1
							deckOfCards = 1; // sets its value
						} else if (aceInTheHole == 11) { // if input = 11
							deckOfCards = 11; // sets its value
						} else { // else they don't pick 1 or 11
							System.out.println(
									"It seems you didn't enter 1 or 11, the blackjack gods will pick for you!"); // random gen will pick
							double blkJckGods = (int) (Math.random() * (2 - 1 + 1) + 1); // random number generator
							if (blkJckGods == 1) { // if rando = 1
								deckOfCards = 1; // value = 1
							} else { // else
								deckOfCards = 11; // value = 11
							} // end of if-statement in else
						} // end of else statement
					} // end of if-statement
					total += deckOfCards; // sets the total
				} else if (dealerTotal <= 17) { // if dealer's current total is less than or equal to17
					dealerTotal += deckOfCards; // sets dealer total

				} else { // else it's above 17
					++draw; // ends draw loop
				} // ends if-statement

			} // ends for loop; draw

		} // ends for loop; highNoon

	} // end of drawCards method
		
	public static void determineWinner() { // winner method
		while (answer.equalsIgnoreCase("Hit")) { // start of while loop
			drawCards(); // recalls the entire drawCards method in here

			System.out.println("The total: " + total); // displays user cards total
			System.out.println("The dealer total: " + dealerTotal+"\n"); // displays dealer cards total

			if (total < 22 && dealerTotal < 22 && total != dealerTotal) { //  if user and dealer is less than 22
				if (total > dealerTotal) { // but user is greater than dealer
					System.out.println("Incroyable, you won!"); // displays user won
					++win; // increase win
				} else if (dealerTotal > total) { // but dealer is greater than user
					System.out.println("The dealer won this round. . ."); // displays dealer has won
					++lost; // increase losses
				}

			} else if (dealerTotal > 21 && total > 21 || total == dealerTotal) { // if both is greater than 21 or both totals are the same
				System.out.println("It looks like you and the dealer tied! "); // displays a tie
				++tie;  // increase ties
			} else if (total > 21 && dealerTotal <= 21) { // if user get higher than 21
				System.out.println("The dealer won this round. . ."); // displays dealer has won
				++lost; // increase losses
			} else if (dealerTotal > 21 && total <= 21) { // if dealer gets high than 21
				System.out.println("Incroyable, you won!"); // displays user won
				++win; // increase win
			} // end of if-statement

			System.out.println("\nYou have " + win + " win(s)!"); // displays total wins
			System.out.println("The dealer has " + lost + " win(s)!"); // displays total user losses
			System.out.println("You two have tied " + tie + " time(s)!"); // displays total ties

			Scanner scan = new Scanner(System.in);
			System.out.println("\nWould you like to go again (Yes or No)?"); // asks users if they want to play again
			String maybe = scan.nextLine(); // takes input
			if (maybe.equalsIgnoreCase("Yes")) { // if they want to continue
				// resets these variable's values
				dealerTotal = 0;
				total = 0;
				answer = "Hit";
				first2Cards = 0;
			} else if (maybe.equalsIgnoreCase("No")) { // if they don't want to continue
				System.out.println("\nAu Revior!"); // bye
				++brain; // stops the overall loop
			} // end of if statement

		} // end of while loop; answer
	} // end of winner method

} // end of class