import java.util.*;
import java.io.*;

//allow user to play 5 rounds

public class PlayerAlphaGameV2{
	//fields
	private ArrayList<String> players;
	private char randomAlpha;
	private ArrayList<String> alphaPlayers;
	private BufferedReader readInput;
	private Integer userFreqGuess;
	private static int roundCounter = 0;
	
	//constructor
	PlayerAlphaGameV2(){
		setPlayers();
		setRandomAlpha();
		setAlphaPlayers();
		setReadInput();
		setRoundCounter();
	}
	
	//setters (overloaded)
	public void setPlayers(){
		players = new ArrayList<String>();
		setPlayers("Carlson");
		setPlayers("Backstrom");
		setPlayers("Orpik");
		setPlayers("Ovechkin");
		setPlayers("Kuznetsov");
		setPlayers("Oshie");
		setPlayers("Kempny");
		setPlayers("Connolly");
		setPlayers("Jaskin");
		setPlayers("Holtby");
		setPlayers("Copley");
		setPlayers("Niskanen");
		setPlayers("Eller");
		setPlayers("Dowd");
		setPlayers("Vrana");
		setPlayers("Orlov");
		setPlayers("Smith-Pelly");
		setPlayers("Stephenson");
		setPlayers("Djoos");
		setPlayers("Walker");
		setPlayers("Burakovsky");
		setPlayers("Bowey");
		Collections.sort(players);
	}
	
	public void setPlayers(String p){
		players.add(p);	
	}
	
	public void setRandomAlpha(){
		randomAlpha = (char) (int)((Math.random() * ((90 - 65) + 1)) + 65);
	}
	
	public void setAlphaPlayers(){
		alphaPlayers = new ArrayList<String>();
		String randomAlpha = Character.toString(getRandomAlpha()).toUpperCase();
		for(String player : players){
			player = player.toUpperCase();
			if(player.startsWith(randomAlpha) == true){
				alphaPlayers.add(player);
			}
		}
	}
	
	public void setReadInput(){
		readInput = new BufferedReader(new InputStreamReader(System.in)); 
	}
	
	public void setUserFreqGuess(){
		try{
			System.out.print("Enter number of players whose last name begins with " + getRandomAlpha() + ": ");
			userFreqGuess = Integer.parseInt(readInput.readLine());	
		}
		catch(Exception e){
			System.out.println("oh noz, there is an Exception: " + e + ".\nTry again!");
			setUserFreqGuess();
		}	
	}
	
	public void setRoundCounter(){
		roundCounter++;	
	}
	
	//getters
	public ArrayList<String> getPlayers(){
		return players;	
	}
	
	public char getRandomAlpha(){
		return randomAlpha;	
	}
	
	public ArrayList<String> getAlphaPlayers(){
		return alphaPlayers;	
	}
	
	public BufferedReader getReadInput(){
		return readInput;	
	}
	
	public Integer getUserFreqGuess(){
		return userFreqGuess;	
	}
	
	public static int getRoundCounter(){
		return roundCounter;	
	}
	
	//method to format right/wrong feedback to user
	public void correctOutput(PlayerAlphaGameV2 classInst, String rightWrong){
		if(classInst.getAlphaPlayers().size() == 0){
			System.out.println(rightWrong + classInst.getAlphaPlayers().size() + " players have last names that begin with the letter " + classInst.getRandomAlpha() + "!");
		}
		else if(classInst.getAlphaPlayers().size() == 1){
			System.out.println(rightWrong + classInst.getAlphaPlayers().toString() + " has a last name that begins with the letter " + classInst.getRandomAlpha() + "!");
		}
		else{
			System.out.println(rightWrong + classInst.getAlphaPlayers().toString() + " have last names that begin with the letter " + classInst.getRandomAlpha() + "!");				
		}
	}
	
	//main method
	public static void main(String... args){
	PlayGame go = new PlayGame();
	go.playGame();
	}
}	

class PlayGame{
	//field
	private int totalRounds;
	
	//constructor
	PlayGame(){
		totalRounds = 5; //total rounds defaults to five	
	}
	
	PlayGame(int totalRounds){
		this.totalRounds = totalRounds;	
	}
	
	//setter
	public void setTotalRounds(int totalRounds){
		this.totalRounds = totalRounds;	
	}
	
	//getter
	public int getTotalRounds(){
		return totalRounds;	
	}
	
	//method to play alphabet last name game
	public void playGame(){
		System.out.println("\n***********Welcome to Washington Capitals' Last Name Alphabet Game!***********");
		int correct = 0;
		do{
			PlayerAlphaGameV2 play = new PlayerAlphaGameV2();
			System.out.println("\nRound " + play.getRoundCounter() + " of " + getTotalRounds() + ": ");
			System.out.println("How many players from the 2018-2019 regular season roster have a last name that begins with the letter " + play.getRandomAlpha() + "?");
			play.setUserFreqGuess();
			if(play.getUserFreqGuess().equals((Integer)play.getAlphaPlayers().size()) == true){
				play.correctOutput(play, "You are CORRECT!  ");
				correct++;
			}
			else{
				play.correctOutput(play, "Nope!  ");
			}
		}
		while(PlayerAlphaGameV2.getRoundCounter() < getTotalRounds());
		
		System.out.println("\nYou have completed the game.  Your score: " + correct + "/" + PlayerAlphaGameV2.getRoundCounter());
		System.out.println("\nFYI: The 2018-2019 regular season roster is: ");
		PlayerAlphaGameV2 fyi = new PlayerAlphaGameV2();
		System.out.println(fyi.getPlayers().toString());
		}
}	