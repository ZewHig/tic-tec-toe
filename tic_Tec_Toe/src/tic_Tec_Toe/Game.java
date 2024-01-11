package tic_Tec_Toe;

import java.util.Scanner;

public class Game {

	//TODO realizar um loop para sempre pergunta ao jogador se quer jogar novamente.
	
	private static final  int NUM_CASES = 9;
	

	private Player player1 = new Player("Player", this);
	private Player player2 = new Player("Player", this);
	
	public GameState gameState;
	
	public  String[][] gameMatriz = { 
			{"-","-","-"}, 
			{"-","-","-"},
			{"-","-","-"} };



	
	private void chooseSymbol() {
		System.out.println("Player 1, please type 1 for: X or 2 for: O to choose you Symbol");
		Scanner scanner = new Scanner(System.in);
		int symbolValue = scanner.nextInt();
		if(symbolValue == 1) {
			player1.setPlayerSymbol("X");
			player2.setPlayerSymbol("O");
		}else {
			player1.setPlayerSymbol("O");
			player2.setPlayerSymbol("X");
		}
	}
	
	public void  setSymbolMap(int i, int j, String symbol) {
		
		gameMatriz[i][j] = symbol;
	}
	
	public boolean checkInput(int i, int j) {
		
		if(gameMatriz[i][j] != "-") {
			System.out.println("This Place is already taken, please choose another place.");
			return false;
		}
		
		return true;
	}
	
	
	public void startGame() {
		
		gameState = GameState.IN_GAME;
		
		System.out.println("----------Welcome to Tic Tac Toe----------\n");
		
		chooseSymbol();
		
		while(gameState.equals(GameState.IN_GAME)) {
			
			//TODO colocar um Contador onde so vai iniciar a verificação apos um valor determina
			//TODO BOTAR LOGIA DE VERIFY
			printGame();
			
			player1.inputPlayerLocation();
			System.out.println("\n");
			printGame();
			player1.verifyGameState();

			if(!gameState.equals(GameState.IN_GAME)) {
				break;
			}
			
			player2.inputPlayerLocation();
			player2.verifyGameState();
			
			System.out.println("\n");
			printGame();
						
			if(!gameState.equals(GameState.IN_GAME)) {
				break;
			}
		}
		
		System.out.println(gameState);
		
		if(gameState.equals(GameState.P1_VICTORY)) {
			System.out.println("PLAYER 1 WINS!!");
			player1.addWins();
			player2.addLoses();
		}else if(gameState.equals(GameState.P2_VICTORY)) {
			System.out.println("PLAYER 2 WINS!!");
			player2.addWins();
			player1.addLoses();
		}else if(gameState.equals(GameState.TIE)) {
			System.out.println("IT WAS A TIE!!");
		}
		
		System.out.printf("Wanna Play again?: Type 1 for YES or 2 for NO ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		if(input == 1) {
			resetGame();
			startGame();
		}
		
		System.out.printf("Player 1 Won: %d and Lost: %d\n", player1.getWins(), player1.getLoses());
		System.out.printf("Player 2 Won: %d and Lost: %d\n", player2.getWins(), player2.getLoses());
		System.out.println("BYE : )");
	}
	
	private void printGame() {
		
		System.out.printf("  %s  | %s | %s\n"
		    	+ "-----|---|-----\n"
				 +"  %s  | %s | %s \n"
				 +"-----|---|-----\n"
				 +"  %s  | %s | %s\n",gameMatriz[0][0],gameMatriz[0][1],gameMatriz[0][2],gameMatriz[1][0],gameMatriz[1][1],gameMatriz[1][2],gameMatriz[2][0],gameMatriz[2][1],gameMatriz[2][2]);
		
	}
	
	private void resetGame() {
		
		for (int i = 0; i < gameMatriz.length; i++) {
			for (int j = 0; j < gameMatriz.length; j++) {
				gameMatriz[i][j] = "-";
			}
		}
		
	}
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public static int getNumCases() {
		return NUM_CASES;
	}
	
}
