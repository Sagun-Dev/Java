package lab4.Q1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

public class NepalFlag extends JFrame{
	NepalFlag(){
		super("Flag");
		
		setSize(300,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		System.out.println("Printed");
		int xCoordsBorder[] = {20,200,100,200,20};
		int yCoordsBorder[] = {50,200,200,370,370};
		Polygon flagBorder = new Polygon(xCoordsBorder,yCoordsBorder,xCoordsBorder.length);
		g.setColor(Color.BLUE);
		g.fillPolygon(flagBorder);
		
		int xCoordsInner[] = {27,180,85,180,27};
		int yCoordsInner[] = {65,192,192,360,360};
		Polygon flagInner = new Polygon(xCoordsInner,yCoordsInner,xCoordsBorder.length);
		g.setColor(new Color(221,12,57));
		g.fillPolygon(flagInner);
		
		//Moon
		g.setColor(Color.WHITE);
		g.fillOval(38, 120, 60, 60);
		
		g.setColor(new Color(221,12,57));
		g.fillOval(38, 110, 60, 60);
		
		//Sun
		g.setColor(Color.WHITE);
		int xNepalFlagStar[] = {65,70,75,85,80,85,75,70,65,55,60,55};
		int yNepalFlagStar[] = {270,255,270,270,280,290,290,305,290,290,280,270};

		g.fillPolygon(xNepalFlagStar,yNepalFlagStar,xNepalFlagStar.length);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NepalFlag();
	}

}
