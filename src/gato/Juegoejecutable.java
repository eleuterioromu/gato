package gato;


import gato.Computadora;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class Juegoejecutable implements ActionListener {

	
	private JFrame frame;  
	private Gato juego = new Gato();  private Computadora art = new Computadora();  	
	private ArrayList<JButton> blist; 
	private final int USER = -1; 
	
	private int[] choice = new int[2]; 
	private int ganador; 
	
	//TTT buttons
	private JButton juegoButton1;
	private JButton juegoButton2;
	private JButton juegoButton3;
	private JButton juegoButton4;
	private JButton juegoButton5;
	private JButton juegoButton6;
	private JButton juegoButton7;
	private JButton juegoButton8;
	private JButton juegoButton9;
	private JButton breiniciar;
	
	//other juego buttons
	private JLabel resultLabel;
	private JLabel titleLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juegoejecutable window = new Juegoejecutable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Juegoejecutable() {
		initialize();
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == breiniciar){
			
			
			for(int j = 0; j < blist.size(); j++){
				blist.get(j).setEnabled(true);
				blist.get(j).setText("");	
			}
			
			
			resultLabel.setVisible(false);
			breiniciar.setVisible(false);
			
			
			juego.resetBoard();
		}
		
		else {
		
		
			int i = 0;
		    for(; i < blist.size(); i++){
		    		if(e.getSource() == blist.get(i)){
		    			break;
		    		}
		    }
		    

		    if (e.getSource() == blist.get(i)){
		    		

		    		executeUserChoice(i);
		    		
		    		
		    		executeComputerChoice();
		    }
		} 
	    
		   
	} 
	
	private void executeUserChoice(int buttonNum){

		blist.get(buttonNum).setEnabled(false);
	    blist.get(buttonNum).setText("<html><font color='blue'>O</html>");

	    choice = juego.convertButtonToIndex(buttonNum+1);
	    juego.recordUserChoice(choice[0], choice[1], USER);
	    

	    ganador = juego.checkGameState(juego.getBoard());
	    if (ganador != 2){
	    		getGameWinner(ganador);
	    }
		
	}
	
	private void executeComputerChoice(){

	    choice = art.determineBestMove(juego.getBoard());
		juego.recordUserChoice(choice[0], choice[1], art.getMe());

		int buttonNum = 0;
		buttonNum = juego.convertIndexToButtonNum(choice[0], choice[1]);
		

		blist.get(buttonNum).setEnabled(false);
		blist.get(buttonNum).setText("<html><font color='red'>X</html>");
		

		int ganador = juego.checkGameState(juego.getBoard());
	    if (ganador != 2){
	    		getGameWinner(ganador);
	    }
	}
	
	private void getGameWinner(int ganador) {

		for(int i = 0; i < blist.size(); i++){
			blist.get(i).setEnabled(false);
		}
		

		resultLabel.setVisible(true);
		breiniciar.setVisible(true);
		if (ganador == 1){
			resultLabel.setText("Has perdido, Computadora Ganó");
		}
		else if (ganador == -1){
			resultLabel.setText("Felicidades Ganaste!!!");
		}
		else if (ganador == 0){
			resultLabel.setText("Empate");
		}
		else {	
			resultLabel.setText("Error: " + ganador);
		}
		
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		blist = new ArrayList<JButton>();
		
		
		juegoButton1 = new JButton();
		juegoButton1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton1.setBounds(150, 98, 144, 85);
		juegoButton1.addActionListener(this);
		frame.getContentPane().add(juegoButton1);
		blist.add(juegoButton1);
		
		juegoButton2 = new JButton();
		juegoButton2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton2.setBounds(306, 98, 144, 85);
		juegoButton2.addActionListener(this);
		frame.getContentPane().add(juegoButton2);
		blist.add(juegoButton2);
		
		juegoButton3 = new JButton();
		juegoButton3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton3.setBounds(462, 98, 144, 85);
		juegoButton3.addActionListener(this);
		frame.getContentPane().add(juegoButton3);
		blist.add(juegoButton3);
		
		juegoButton4 = new JButton();
		juegoButton4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton4.setBounds(150, 189, 144, 85);
		juegoButton4.addActionListener(this);
		frame.getContentPane().add(juegoButton4);
		blist.add(juegoButton4);
		
		juegoButton5 = new JButton();
		juegoButton5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton5.setBounds(306, 189, 144, 85);
		juegoButton5.addActionListener(this);
		frame.getContentPane().add(juegoButton5);
		blist.add(juegoButton5);
		
		juegoButton6 = new JButton();
		juegoButton6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton6.setBounds(462, 189, 144, 85);
		juegoButton6.addActionListener(this);
		frame.getContentPane().add(juegoButton6);
		blist.add(juegoButton6);
		
		juegoButton7 = new JButton();
		juegoButton7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton7.setBounds(150, 281, 144, 85);
		juegoButton7.addActionListener(this);
		frame.getContentPane().add(juegoButton7);
		blist.add(juegoButton7);
		
		juegoButton8 = new JButton();
		juegoButton8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton8.setBounds(306, 281, 144, 85);
		juegoButton8.addActionListener(this);
		frame.getContentPane().add(juegoButton8);
		blist.add(juegoButton8);
		
		juegoButton9 = new JButton();
		juegoButton9.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		juegoButton9.setBounds(462, 281, 144, 85);
		juegoButton9.addActionListener(this);
		frame.getContentPane().add(juegoButton9);
		blist.add(juegoButton9);
		
	
		
		breiniciar = new JButton("Reiniciar juego");
		breiniciar.setBounds(323, 422, 150, 29);
		breiniciar.addActionListener(this);  
		frame.getContentPane().add(breiniciar);
		breiniciar.setVisible(false);
		
		resultLabel = new JLabel();
		resultLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(150, 368, 458, 50);
		frame.getContentPane().add(resultLabel);
		
		titleLabel = new JLabel("Juego de gato");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		titleLabel.setBounds(176, 36, 410, 50);
		frame.getContentPane().add(titleLabel);
		
	} 
	
} 
