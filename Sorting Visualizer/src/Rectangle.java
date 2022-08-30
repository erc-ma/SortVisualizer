import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Scanner;
public class Rectangle implements Comparable{
	
	
	private int height;
	private int color;
	private static int width;//STATIC
	//depends on the number of rectangles
	//the screen will be whatever u want\
	public Rectangle() {
		super();
		
		height=0;
		color=0;
	}
	
	public Rectangle(int height, int color) {
		super();

		this.height = height;
		this.color = color;
	}
	public Rectangle(Rectangle r) {
		super();

		height=r.getHeight();
		color=r.getColor();
		
	}


	public int getHeight() {
		return height;}
	public void setHeight(int height) {
		this.height = height;}
	public int getColor() {
		return color;}
	public void setColor(int color) {
		this.color = color;}
	public static int getWidth() {
		return width;}
	public static void setWidth(int width) {
		Rectangle.width = width;}
	
	public int compareTo(Object r) {
		Rectangle r1 = (Rectangle)r;
		return height-r1.getHeight();
	}
	public Color returnColor() {
		if(color==0)
			return Color.red;
		else
			return Color.white;
			
	}

	
	
	
	
	
}
//Rectangle implements Comparable
//x
//height
//Color
//CompareTo-height
//
//
//CustomPanel
//Rectangles[] generate random
//Color2-Background color
//Paint Component:
//for
//draw rectangles
//
//
//
//Driver
//Has sorting algorithms and jFrame
//
//
//
//First build Rectangle and CustomPanel
//Draw random rect
//
//User:
//how many rectangles
//what kind of sort
//go again?
//
//Rect color same except for the two swapping
//have a visual delay
//
//Use option panes
//go 800x600