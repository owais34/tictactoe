package ticTacToe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener,MouseMotionListener,KeyListener, ActionListener {

	
	/**
	 * 
	 */
	boolean menustate=true;boolean playstate=false;boolean pturn=true;
	int matrix[][]= {{0,0,0},{0,0,0},{0,0,0}};boolean stop=false;int count=0;
	String bord[][]= {{"plainbox.png","plainbox.png","plainbox.png"},{"plainbox.png","plainbox.png","plainbox.png"},{"plainbox.png","plainbox.png","plainbox.png"}};
	private static final long serialVersionUID = 1L;int ranr;int ranc;
	String chosen;String cpu;
	Panel()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void paint(Graphics g)
	{
		Toolkit t=Toolkit.getDefaultToolkit();
		Image menu=t.getImage("TTT.png");
		Image play=t.getImage("board.png");
	    
		if(menustate)
		{
			g.drawImage(menu,0,0,this);
		}
		else if(playstate)
		{
			g.drawImage(play,0,0,this);
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					Image render=t.getImage(bord[i][j]);
					g.drawImage(render,j*240,i*240,this);
				}
			}
		}
		if(matrix[0][0]==1&&matrix[0][1]==1&&matrix[0][2]==1)
		{   g.setColor(Color.black);
			g.drawLine(0, 120, 720, 120);
			g.drawString("You won", 360, 360);
			stop=true;
		}
		else if(matrix[0][0]==1&&matrix[1][0]==1&&matrix[2][0]==1)
		{
			g.setColor(Color.black);
			g.drawLine(120, 0, 120, 720);
			g.drawString("You won", 360, 360);
			stop=true;
		}
		else if(matrix[2][0]==1&&matrix[2][1]==1&&matrix[2][2]==1) {
			g.setColor(Color.black);
			g.drawLine(0, 600, 720, 600);
			g.drawString("You won", 360, 360);
			stop=true;
		}
		else if(matrix[0][2]==1&&matrix[1][2]==1&&matrix[2][2]==1)
		{
			g.setColor(Color.black);
			g.drawLine(600, 0, 600, 720);
			g.drawString("You won", 360, 360);
			stop=true;
		}
		else if(matrix[0][0]==1&&matrix[1][1]==1&&matrix[2][2]==1)
        {
        	g.setColor(Color.black);
			g.drawLine(0, 0, 720, 720);
			g.drawString("You won", 360, 360);
			stop=true;
        }
		else if(matrix[0][2]==1&&matrix[1][1]==1&&matrix[2][0]==1)
		{
			g.setColor(Color.black);
			g.drawLine(720, 0, 0, 720);
			g.drawString("You won", 360, 360);
			stop=true;
		}
		//cpu wins
		if(matrix[0][0]==2&&matrix[0][1]==2&&matrix[0][2]==2)
		{   g.setColor(Color.black);
			g.drawLine(0, 120, 720, 120);
			g.drawString("You lost", 360, 360);
			stop=true;
		}
		else if(matrix[0][0]==2&&matrix[1][0]==2&&matrix[2][0]==2)
		{
			g.setColor(Color.black);
			g.drawLine(120, 0, 120, 720);
			g.drawString("You Lost", 360, 360);
			stop=true;
		}
		else if(matrix[2][0]==2&&matrix[2][1]==2&&matrix[2][2]==2) {
			g.setColor(Color.black);
			g.drawLine(0, 600, 720, 600);
			g.drawString("You Lost", 360, 360);
			stop=true;
		}
		else if(matrix[0][2]==2&&matrix[1][2]==2&&matrix[2][2]==2)
		{
			g.setColor(Color.black);
			g.drawLine(600, 0, 600, 720);
			g.drawString("You Lost", 360, 360);
			stop=true;
		}
		else if(matrix[0][0]==2&&matrix[1][1]==2&&matrix[2][2]==2)
        {
        	g.setColor(Color.black);
			g.drawLine(0, 0, 720, 720);
			g.drawString("You Lost", 360, 360);
			stop=true;
        }
		else if(matrix[0][2]==2&&matrix[1][1]==2&&matrix[2][0]==2)
		{
			g.setColor(Color.black);
			g.drawLine(720, 0, 0, 720);
			g.drawString("You Lost", 360, 360);
			stop=true;
		}
		
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!stop||count==9)
		{if(menustate)
		{
			if(e.getX()>=28&&e.getX()<=185&&e.getY()>=352&&e.getY()<=480)
				{chosen="x.png";cpu="o.png";}
			if(e.getX()>=459&&e.getX()<=625&&e.getY()>=346&&e.getY()<=480)
				{chosen="o.png";cpu="x.png";}
			menustate=false;playstate=true;
			repaint();
			return;
		}
		
	
		if(playstate&&pturn)
		{
			int c=e.getX()/240;int r=e.getY()/240;
			if(matrix[r][c]==0)
			{
				bord[r][c]=chosen;matrix[r][c]=1;
			pturn=false;count++;
		}
		repaint();
		
		if(!pturn&&count<=8)
		{
			Random random=new Random();
			ranr=random.nextInt(3);ranc=random.nextInt(3);
			while(matrix[ranr][ranc]==1||matrix[ranr][ranc]==2)
			{
				ranr=random.nextInt(3);ranc=random.nextInt(3);
			}
			bord[ranr][ranc]=cpu;matrix[ranr][ranc]=2;
		}
		repaint();
		pturn=true;count++;
		repaint();
		}}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
