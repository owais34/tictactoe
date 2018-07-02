package ticTacToe;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame obj=new JFrame();
		obj.setTitle("TicTacToe");
		Panel panel=new Panel();
		obj.setBounds(0,0,720, 720);
		obj.setBackground(Color.black);
		obj.setResizable(false);
		obj.add(panel);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setVisible(true);

	}

}
