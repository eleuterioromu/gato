package gato;

public class Computadora {
	private int yo = 1;  //se utiliza para el algoritmo Minimax
	private int icordenada; // i final coordino para la opción AI
	private int jcordenada; // j última coordenada donde elegir AI
	
	public int[] determineBestMove(int[][] board){
		/*ya que sólo se necesita un equipo de AI , un constructor es
                    * No es necesario. Sin embargo , si hubiera dos inhibidores de la aromatasa , se podría
                    * Crearlos con diferentes valores
		 */
		
		int[] choice = new int[2];
		if(yo == 1){
			getMax(board, 0);
		}
		/*si hubiera dos inhibidores de la aromatasa , la AI sería buscar el getMin
permitiendo así que dos inhibidores de la aromatasa para jugar uno contra el otro , pero
utilizando el mismo código */
		else {
			getMin(board, 0);
		}
		/*después de conseguir min o max
conseguir elegido i , j de coordenadas para la opción  */
		choice[0] = icordenada;
		choice[1] = jcordenada;
		
		//return i , j elección coordenadas como mejor jugada
		return choice;
	}
	
	public int getMin(int[][] board, int depth){
		
		//comprobar el estado del juego para determinar si al final de la recursividad
		int val = checkGameState(board);
		if (val != 2) { return val;}
		
		int min = Integer.MAX_VALUE; //establecer valor arbitrariamente grande min
		int puntuacion;
		
		//establecer valor arbitrariamente grande min
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				
				//determinar si lugar está abierto
				if(board[i][j] == 0){
					
					//si el lugar está abierto, elija temporalmente
					board[i][j] = -1;
					
					//de forma recursiva obtener puntuación de esa elección
					puntuacion = getMax(board, depth+1);
					
					/*si la puntuación es inferior a la ajustada min actual
min para anota                             */
					if (puntuacion < min){
						min = puntuacion;
						
						/*Si en la parte superior de profundidad en la recursividad obtener i , j
coordina                                         */
						if (depth == 0){
							icordenada = i;
							jcordenada = j;
						}
					}
					
					//reliminar eleccion temporal
					board[i][j] = 0;
				}
			} //Finde bucles internos
		} //Fin de ciclo exterior
		
		//Devuelve puntuacion mas baja
		return min;
	}
	
	public int getMax(int[][] board, int depth){
		
		// comprobar el estado del juego para determinar si al final de la recursividad
		int val = checkGameState(board);
		if (val != 2) { return val; } 
		
		
		int max = Integer.MIN_VALUE; //rear arbitrariamente pequeño max;
		int puntuacion;
		
		// iterar sobre todas las opciones
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				
				//Determinar si lugar esta abierto
				if(board[i][j] == 0){
					
					//si el lugar está abierto, elija temporalmente
					board[i][j] = 1;
					
					//de forma recursiva obtener puntuación de esa elección
					puntuacion = getMin(board, depth+1);
	
					/* si la puntuación es superior a más */
					if (puntuacion > max){
						max = puntuacion;
						
						/* el nivel de recursividad es máxima
                                                * Profundidad , obtener la i , j de coordenadas  */ 
						if (depth == 0){
							icordenada = i;
							jcordenada = j;
						}	
					}
					
					//Eliminar eleccion temporal
					board[i][j] = 0;
				}
			} // fin del bucle interno
		} //fin del bucle exterior
		
		//devuelve la puntuación máxima de opciones disponible
		return max;
	}
		
	public int checkGameState(int[][] board){
		/*estado de comprobación del juego, es decir, si alguien ha ganado  */
		
		// 0 no hay ganador , el juego es dibujar
                // 1 es el ganador equipo
                // -1 Es ganador humana
                // 2 hay un ganador , continúe juego

                //filas // verificación
		
		if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1){ return 1;}
		if(board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1){return 1;}
		if(board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1){return 1;}
		
		if(board[0][0] == -1 && board[0][1] == -1 && board[0][2] == -1){ return -1;}
		if(board[1][0] == -1 && board[1][1] == -1 && board[1][2] == -1){return -1;}
		if(board[2][0] == -1 && board[2][1] == -1 && board[2][2] == -1){return -1;}
				
		//Verificando columnas
		
		if(board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1){ return 1;}
		if(board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1){ return 1;}
		if(board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1){ return 1;}
		
		if(board[0][0] == -1 && board[1][0] == -1 && board[2][0] == -1){ return -1;}
		if(board[0][1] == -1 && board[1][1] == -1 && board[2][1] == -1){ return -1;}
		if(board[0][2] == -1 && board[1][2] == -1 && board[2][2] == -1){ return -1;}
		
		//Verificando casos Diagonales
		
		if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){ return 1;}
		if(board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1){ return 1;}
		
		if(board[0][0] == -1 && board[1][1] == -1 && board[2][2] == -1){ return -1;}
		if(board[2][0] == -1 && board[1][1] == -1 && board[0][2] == -1){ return -1;}
		
		
		//verificar todo el tablero
		int count = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == 0){
					break;
				}
				else{
					count++;
				}
			}  //fin bucle interno
		} // fin bucle externo
		
		// si se toman todas las plazas, juego es dibujar
		if(count == 9){
			return 0;  //cero es el código para dibujar
		}
		
		return 2;  //si no de arriba regresó , devuelva 2 , es decir, el juego sigue en pie, no hay ganador
	}
	
	public int getMe(){
		 // número de vuelta de AI
                // útil cuando más de una AI
		return yo;
	}

} //fin de la clase
