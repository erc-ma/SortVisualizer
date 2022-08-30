import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Scanner;
public class CustomPanel extends JPanel {

	private Rectangle[]rects;//WHERE DO I INITIALIZE???
	private int color;
	
	
	public CustomPanel() {
		super();
	}


	public CustomPanel(Rectangle[] rects, int color, int numRects) {//WHY rect[] HERE???
		super();
		this.rects = rects;
		this.color = color;
		this.rects = rects;
	}


	public Rectangle[] getRects() {
		return rects;
	}


	public void setRects(Rectangle[] rects) {
		this.rects = rects;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}
	


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);//set Background
		
		for(int i = 0; i<rects.length;i++) {
			g.setColor(rects[i].returnColor());
			g.fillRect(i*Rectangle.getWidth(), 765-rects[i].getHeight(), Rectangle.getWidth(), rects[i].getHeight());
			g.setColor(Color.black);
			g.drawRect(i*Rectangle.getWidth(), 765-rects[i].getHeight(), Rectangle.getWidth(), rects[i].getHeight());
//			g.fillRect(i*Rectangle.getWidth()+i, 765-rects[i].getHeight(), Rectangle.getWidth(), rects[i].getHeight());
//			g.drawRect(i*Rectangle.getWidth()+i, 765-rects[i].getHeight(), Rectangle.getWidth(), rects[i].getHeight());

		}
//		printRects();

	}
	private void printRects() {
		for(Rectangle r: rects) {
			System.out.println(r.getHeight());
		}
	}
	
}
