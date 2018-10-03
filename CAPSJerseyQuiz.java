import java.util.*;
import java.io.*;

	public class CAPSJerseyQuiz{
		//fields
		private int points;
		private boolean yourResponse;
		private ArrayList<Jersey> players;
		private Jersey currentPlayer;
		private int questionNum;
		private BufferedReader readNumber;
		
		//constructor
		public CAPSJerseyQuiz(){
			players = new ArrayList<Jersey>();
			setReadNumber();
			setPlayers();
			playGame();
		}
		
		//setters
		public void setPoints(boolean b){
			points = (b==true) ? ++points : points;
		}
		
		public void setYourResponse(){
			try{
				System.out.print("Enter Jersey Number: ");
				Integer userNumber = Integer.parseInt(readNumber.readLine());	
				yourResponse = (userNumber.equals(currentPlayer.getJerseyNumber())==true) ? true : false;
			}
			catch(Exception e){
				System.out.println("oh noz, there is an Exception: " + e + "\nTry again!");
			}	
		}
		
		public void setPlayers(){
			players.add(new Jersey("Backstrom", 19));
			players.add(new Jersey("Boyd", 72));
			players.add(new Jersey("Burakovsky", 65));
			players.add(new Jersey("Connolly", 10));
			players.add(new Jersey("Dowd", 26));
			players.add(new Jersey("Eller", 20));
			players.add(new Jersey("Gersich", 63));
			players.add(new Jersey("Jaskin", 23));
			players.add(new Jersey("Kuznetsov", 92));
			players.add(new Jersey("Megna", 15));
			players.add(new Jersey("Oshie", 77));
			players.add(new Jersey("Ovechkin", 8));
			players.add(new Jersey("Smith-Pelly", 25));
			players.add(new Jersey("Stephenson", 18));
			players.add(new Jersey("Vrana", 13));
			players.add(new Jersey("Walker", 79));
			players.add(new Jersey("Wilson", 43));
			players.add(new Jersey("Bowey", 22));
			players.add(new Jersey("Carlson", 74));
			players.add(new Jersey("Djoos", 29));
			players.add(new Jersey("Kempny", 6));
			players.add(new Jersey("Niskanen", 2));
			players.add(new Jersey("Orlov", 9));
			players.add(new Jersey("Orpik", 44));
			players.add(new Jersey("Siegenthaler", 34));
			players.add(new Jersey("Copley", 1));
			players.add(new Jersey("Holtby", 70));
		}
		
		public void setCurrentPlayer(){
			//sets the current player as a randomly-picked player from the players ArrayList
			currentPlayer= players.get((int)Math.floor(Math.random() * players.size()));					
		}
		
		public void setQuestionNumber(){
			questionNum++;
			System.out.println(getQuestionNumber() + ".) What is " + currentPlayer.getLastName() + "'s jersey number?");	
		}
		
		public void setReadNumber(){
			readNumber = new BufferedReader(new InputStreamReader(System.in)); 
		}
		
		
		//getters
		public int getPoints(){
			return points;	
		}
		
		public boolean getYourResponse(){
			return yourResponse;	
		}
		
		public ArrayList<Jersey> getPlayers(){
			return players;	
		}
		
		public Jersey getCurrentPlayer(){
			return currentPlayer;	
		}
		
		public int getQuestionNumber(){
			return questionNum;	
		}
		
		public BufferedReader getReadNumber(){
			return readNumber;	
		}
		
		//method to quiz user on jersey number of 10 randomly-selected players
		public void playGame(){
			System.out.println("**********************\nPlay CAPS Jersey Quiz!\n**********************");
			System.out.println("Test your knowledge of the jersey numbers of 10 randomly-selected Washington Capitals players.");
			do{
				setCurrentPlayer();
				setQuestionNumber();
				setYourResponse();
				setPoints(yourResponse);	
			}
			while(questionNum<10);
			System.out.println("********************************\nYOUR SCORE: " + getPoints() + "/10");
		}
		
		
		//main method
		public static void main(String[] args){
			CAPSJerseyQuiz startQuiz = new CAPSJerseyQuiz();
		}
	}
	
	class Jersey{
		//fields
		private String lastName;
		private Integer jerseyNumber;
		
		//constructor
		public Jersey(String ln, Integer jn){
			lastName = 	ln;
			jerseyNumber = jn;
		}
		
		//setters
		public void setJerseyNumber(Integer jn){
			jerseyNumber = jn;	
		}
		
		public void setLastName(String ln){
			lastName = ln;	
		}
		
		//getters
		public Integer getJerseyNumber(){
			return jerseyNumber;	
		}
		
		public String getLastName(){
			return lastName;	
		}
	}