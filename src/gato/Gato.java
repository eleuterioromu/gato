package gato;


public class Gato {
	private int[][] board; 
	private int[] choice = new int[2];  
	
	public Gato(){
		
		board = createGameBoard();
	}
	
	public int[][] createGameBoard(){
		
		
		int[][] newBoard = new int[3][3];
		
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
				newBoard[i][j] = 0;
			}
		}
		
		return newBoard;	
	}
	
	public int[][] getBoard(){
		return board;
	}
	
	public void resetBoard(){
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public void recordUserChoice(int i, int j, int player){
		
		board[i][j] = player; 
	}
	
	public int checkGameState(int[][] board){
		
		
		if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1){ return 1;}
		if(board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1){return 1;}
		if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1){return 1;}
		
		if(board[0][0] == -1 && board[0][1] == -1 && board[0][2] == -1){ return -1;}
		if(board[1][0] == -1 && board[1][1] == -1 && board[1][2] == -1){return -1;}
		if(board[2][0] == -1 && board[2][1] == -1 && board[2][2] == -1){return -1;}
				
	
		if(board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1){ return 1;}
		if(board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1){ return 1;}
		if(board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1){ return 1;}
		
		if(board[0][0] == -1 && board[1][0] == -1 && board[2][0] == -1){ return -1;}
		if(board[0][1] == -1 && board[1][1] == -1 && board[2][1] == -1){ return -1;}
		if(board[0][2] == -1 && board[1][2] == -1 && board[2][2] == -1){ return -1;}
		
	
		
		if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){ return 1;}
		if(board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1){ return 1;}
		
		if(board[0][0] == -1 && board[1][1] == -1 && board[2][2] == -1){ return -1;}
		if(board[2][0] == -1 && board[1][1] == -1 && board[0][2] == -1){ return -1;}
		
		
	
		int contador = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == 0){
					break;
				}
				else{
					contador++;
				}
			}  
		} 
		
		
		if(contador == 9){
			return 0;  
		}
		
		return 2; 
	}
	
	public int[] convertButtonToIndex(int buttonNum){
		
		
		int i = 0, j = 0;
		
		switch (buttonNum){
			case 1: i = 0; j = 0; break;
			case 2: i = 0; j = 1; break;
			case 3: i = 0; j = 2; break;
			case 4: i = 1; j = 0; break;
			case 5: i = 1; j = 1; break;
			case 6: i = 1; j = 2; break;
			case 7: i = 2; j = 0; break;
			case 8: i = 2; j = 1; break;
			case 9: i = 2; j = 2; break;
		}
		
		choice[0] = i;
		choice[1] = j;
		
		return choice;
		
	}
	
	public int convertIndexToButtonNum(int i, int j){
		
		

		if (i == 0){
			if (j == 0){ return 0; }
			else if (j == 1){ return 1; }
			else { return 2; }
		}
		else if (i == 1){
			if (j == 0){ return 3; }
			else if (j == 1){ return 4; }
			else { return 5;	}
		}
		else {
			if (j == 0){	return 6; }
			else if (j == 1){ return 7; }
			else { return 8;	}
		}

	} 
	
} 