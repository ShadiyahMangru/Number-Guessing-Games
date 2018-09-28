import java.util.*;
import java.io.*;

	class Jersey{
		//fields
		private String name;
		private int jerseyNumber;
		private String team;
		
		//constructor
		public Jersey(String n, int jn, String t){
			name = n;
			jerseyNumber = jn;
			team = t;
		}
		//getters
		public String getName(){
			return name;
		}
		
		public int getJerseyNumber(){
			return jerseyNumber;
		}
		
		public String getTeam(){
			return team;
		}
		//setters
		public void setName(String n){
			name = n;
		}
		
		public void setJerseyNumber(int jn){
			jerseyNumber = jn;
		}
		
		public void setTeam(String t){
			team = t;
		}
	}
	
	public class JerseyQuiz{
		//fields
		private ArrayList<Jersey> players = new ArrayList<Jersey>();
		private Jersey currentPlayer;
		private int guessesLeft;
		
		//constructor
		public JerseyQuiz(){
			setPlayers();	
			setCurrentPlayer();
			setGuessesLeft(5);
		}
		
		//getters
		public ArrayList<Jersey> getPlayers(){
			return players;	
		}
		
		public Jersey getCurrentPlayer(){
			return currentPlayer;	
		}
		
		public int getGuessesLeft(){
			return guessesLeft;	
		}
		
		//setters
		public void setPlayers(){
			players.add(new Jersey("Vladimir Tarasenko", 91, "St. Louis Blues"));
			players.add(new Jersey("Patrick Kane", 88, "Chicago Blackhawks"));
			players.add(new Jersey("Jonathan Toews", 19, "Chicago Blackhawks"));
			players.add(new Jersey("Alex Ovechkin", 8, "Washington Capitals"));
			players.add(new Jersey("P.K. Subban", 76, "Nashville Predators"));
			players.add(new Jersey("Sidney Crosby", 87, "Pittsburgh Penguins"));
			players.add(new Jersey("Jake Guentzel", 59, "Pittsburgh Penguins"));
			players.add(new Jersey("Mats Zuccarello", 36, "New York Rangers"));
			players.add(new Jersey("Carey Price", 31, "Montreal Canadiens"));
			players.add(new Jersey("Victor Hedman", 77, "Tampa Bay Lightning"));
			players.add(new Jersey("Nicklas Backstrom", 19, "Washington Capitals"));
			players.add(new Jersey("Connor Hellebuyck", 37, "Winnipeg Jets"));
			players.add(new Jersey("Jamie Benn", 14, "Dallas Stars"));
			players.add(new Jersey("Shea Weber", 6, "Montreal Canadiens"));
			players.add(new Jersey("Max Pacioretty", 67, "Vegas Golden Knights"));
			players.add(new Jersey("Drew Doughty", 8, "LA Kings"));
			players.add(new Jersey("Pekka Rinne", 35, "Nashville Predators"));
			players.add(new Jersey("Joe Thornton", 19, "San Jose Sharks"));
			players.add(new Jersey("Ryan Getzlaf", 15, "Anaheim Ducks"));
			players.add(new Jersey("Connor McDavid", 97, "Edmonton Oilers"));
			players.add(new Jersey("Pheonix Copley", 1, "Washington Capitals"));
		}
		
		public void setCurrentPlayer(){
			//sets the current player as a randomly-picked player from the players ArrayList
			currentPlayer = players.get((int)Math.floor(Math.random() * players.size()));	
		}
		
		public void setGuessesLeft(int g){
			guessesLeft = g;	
		}
		
		//method to ask and format jersey question
		public String askQuestion(){
			return "What is " + currentPlayer.getName() + "'s " + currentPlayer.getTeam() + " jersey number?";	
		}
		
		//method to get user jersey number guesses
		public void userJerseyNumberGuess(){
		boolean winner = false;
			while(getGuessesLeft() > 0){
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("\nYou have " + getGuessesLeft() + " guesses remaining.");
					System.out.print("Enter a number: ");
					int userNumberInput = Integer.parseInt(reader.readLine().trim());	
						if(userNumberInput == currentPlayer.getJerseyNumber()){
							System.out.println("Correct!  " + currentPlayer.getName() + "'s jersey number is " + currentPlayer.getJerseyNumber() + "\n\n");
							winner = true;
							mainMenu();
						}
						else if(userNumberInput >  currentPlayer.getJerseyNumber()){
							System.out.println("Nope!  " + currentPlayer.getName() + "'s jersey number is LOWER than " + userNumberInput);
							guessesLeft--;
							if(winner == false && guessesLeft==0){
								System.out.println("You are out of guesses.  " + currentPlayer.getName() + "'s " + currentPlayer.getTeam() + " jersey number is " + currentPlayer.getJerseyNumber() + "\n\n");
								mainMenu();
							}
							userJerseyNumberGuess();
						}
						else if(userNumberInput < currentPlayer.getJerseyNumber()){
							System.out.println("Nope!  " + currentPlayer.getName() + "'s jersey number is HIGHER than " + userNumberInput);	
							guessesLeft--;
							if(winner == false && guessesLeft==0){
								System.out.println("You are out of guesses.  " + currentPlayer.getName() + "'s " + currentPlayer.getTeam() + " jersey number is " + currentPlayer.getJerseyNumber() + "\n\n");
								mainMenu();
							}
							userJerseyNumberGuess();
						}
				}
				catch(Exception e){
					System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
					userJerseyNumberGuess();
				}
			}
		}
		
		//main menu method
		public void mainMenu(){
			System.out.println("******************************************************************");
			System.out.println("WELCOME TO JERSEY QUIZ!");
			System.out.println("Guess the NHL player's jersey number in 5 tries or less.");
			System.out.println("\nMAIN MENU:\nEnter 1 to play or 2 to exit.");
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter selection: ");
				int userChoice = Integer.parseInt(reader.readLine());	
					switch(userChoice){
						case 1: System.out.print("You selected: Play!\n\n");
							setCurrentPlayer();
							setGuessesLeft(5);
							System.out.println(askQuestion());
							userJerseyNumberGuess();
							break;
						case 2: System.out.print("You selected: EXIT");
							System.exit(0);
							break;
						default: mainMenu(); //reload menu bc invalid selection
							break;	
					}
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
				mainMenu();
			}
		}
		
		//main method
		public static void main(String[] args){
			JerseyQuiz newInst = new JerseyQuiz();
			newInst.mainMenu();
		}
	}