package tic_Tec_Toe;

import java.util.Scanner;

public class Player {

	private String name;
	private int wins;
	private int loses;
	private int i;
	private int j;

	private String playerSymbol = "-";

	private Game game;

	// TODO VER ESSA QUESTÃO
	public Player(String name, Game game) {
		this.name = name;
		this.game = game;
	}

	public void inputPlayerLocation() {

		do {
			Scanner scanner = new Scanner(System.in);
			System.out.printf("Please %s Type the location you want to place you symbol: ", name);
			this.i = scanner.nextInt();
			this.j = scanner.nextInt();
		} while (game.checkInput(i, j) == false);

		game.setSymbolMap(i, j, playerSymbol);
	}

	public void verifyGameState() {

		int cont;
		int j;
		int k;

		for (int i = 0; i < Game.getNumCases(); i++) {
			switch (i) {
			case 0:
				cont = 0;
				j = 0;

				for (k = 0; k < 3; k++) {

					if (game.gameMatriz[j][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}

				}
				break;
			case 1:

				cont = 0;
				j = 1;

				for (k = 0; k < 3; k++) {

					if (game.gameMatriz[j][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}

				}
				break;
			case 2:

				cont = 0;
				j = 2;

				for (k = 0; k < 3; k++) {

					if (game.gameMatriz[j][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}

				}

				break;
			case 3:
				cont = 0;

				for (k = 0; k < 3; k++) {

					if (game.gameMatriz[k][3 - 1 - k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}

				}

				break;
			case 4:

				cont = 0;

				for (k = 0; k < 3; k++) {

					if (game.gameMatriz[k][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}

				}

				break;
			case 5:
				cont = 0;
				k = 0;

				for (j = 0; j < 3; j++) {
					if (game.gameMatriz[j][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}
				}
				break;
			case 6:

				cont = 0;
				k = 1;

				for (j = 0; j < 3; j++) {
					if (game.gameMatriz[j][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}
				}

				break;
			case 7:
				cont = 0;
				k = 2;

				for (j = 0; j < 3; j++) {
					if (game.gameMatriz[j][k].equals(playerSymbol)) {
						cont++;
					}

					if (cont == 3) {
						if (playerSymbol == "X") {

							game.gameState = GameState.P1_VICTORY;

						} else if (playerSymbol == "O") {
							game.gameState = GameState.P2_VICTORY;
						}
					}
				}
				break;
			case 8:
				cont = 0;
				for (j = 0; j < 3; j++) {
					for (k = 0; k < 3; k++) {
						if (game.gameMatriz[j][k] == "-") {
							cont++;
							
						}

					}
				}
				
				if (cont == 0) {
					game.gameState =GameState.TIE;
				}

				break;
			}
		}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getWins() {
		return wins;
	}

	public void addWins() {
		this.wins++;
	}

	public int getLoses() {
		return loses;
	}

	public void addLoses() {
		this.loses++;
	}

	public String getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(String playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

}
