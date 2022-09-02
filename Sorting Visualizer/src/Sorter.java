0import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;//

public class Sorter{
	public static void main(String[] args) {

		int goAgain;
		do {
			JFrame JFrame1 = new JFrame();
			Scanner reader = new Scanner(System.in);

			JFrame1.setTitle("My Rectangles");
			JFrame1.setResizable(false);
			JFrame1.setSize(1210, 800);
			JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			CustomPanel cp1;

			String numRects = JOptionPane.showInputDialog("How many rectangles should I draw?");
			int numR = Integer.parseInt(numRects);

			String sortType = JOptionPane.showInputDialog("Bubble(1)\nSelection(2)\nInsertion(3)");
			int TSort = Integer.parseInt(sortType);

			Rectangle[] rects = new Rectangle[numR];
			for (int i = 0; i < rects.length; i++) {
				rects[i] = new Rectangle();// Make random
				rects[i].setHeight((int) (Math.random() * 765));
			}

			cp1 = new CustomPanel(rects, 100, numR);
			if (cp1.getRects().length != 0)
				Rectangle.setWidth((int) (1200 / cp1.getRects().length));// -1

			JFrame1.getContentPane().add(cp1);
			JFrame1.setVisible(true);
			JFrame1.repaint();
			if (TSort == 1) {// BUBBLE
				bubbleSort(cp1, JFrame1);
			} else if (TSort == 2) {// SELECTION
				selectionSort(cp1, JFrame1);
			} else {// INSERTION
				insertionSort(cp1, JFrame1);
			}

			JOptionPane.showMessageDialog(null, "Done Drawing");
			goAgain = JOptionPane.showConfirmDialog(null, "Do you want to go again?");
			JFrame1.setVisible(false);
		} while (goAgain == JOptionPane.YES_OPTION);
		// JFrame1.setVisible(false);
		// JFrame1.repaint();

	}

	public static void bubbleSort(CustomPanel cp1, JFrame JFrame1) {
		Rectangle[] rects = cp1.getRects();
		boolean YSwitch = true;
		while (YSwitch == true) {
			boolean a = false;
			for (int i = 0; i < rects.length - 1; i++) {

				if (rects[i].compareTo(rects[i + 1]) > 0) {
					for (int j = 1; j < 5; j++) {
						cp1.getRects()[i].setColor(j % 2);
						cp1.getRects()[i + 1].setColor(j % 2);
						JFrame1.repaint();
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					Rectangle temp = rects[i];
					rects[i] = rects[i + 1];
					rects[i + 1] = temp;
					a = true;
				}
			}
			if (a == false)
				YSwitch = false;
			JFrame1.repaint();
		}

	}

	public static void selectionSort(CustomPanel cp1, JFrame JFrame1) {
		Rectangle[] rects = cp1.getRects();
		for (int i = 0; i < rects.length - 1; i++) {
			int minIndex = i;
			for (int j = i; j < rects.length; j++)
				if (rects[j].compareTo(rects[minIndex]) < 0)
					minIndex = j;
			for (int j = 1; j < 5; j++) {
				cp1.getRects()[i].setColor(j % 2);
				cp1.getRects()[minIndex].setColor(j % 2);
				JFrame1.repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Rectangle temp = rects[minIndex];
			rects[minIndex] = rects[i];
			rects[i] = temp;

			JFrame1.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void insertionSort(CustomPanel cp1, JFrame JFrame1) {
		Rectangle[] rects = cp1.getRects();
		for (int i = 1; i < rects.length; i++) {
			Rectangle value = rects[i];
			int spot = i - 1;
			while (spot > -1 && value.compareTo(rects[spot]) < 0) {
				for (int j = 1; j < 5; j++) {
					cp1.getRects()[spot].setColor(j % 2);// flash the one moving
					JFrame1.repaint();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				rects[spot + 1] = new Rectangle(rects[spot]);

				spot--;
				JFrame1.repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			for (int j = 1; j < 5; j++) {
				cp1.getRects()[spot+1].setColor(j % 2);// flash the one moving
				JFrame1.repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			rects[spot + 1] = value;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
	// public static void insertionSort1(CustomPanel cp1, JFrame JFrame1) {
	// Rectangle[] rects = cp1.getRects();
	// for (int i = 1; i < rects.length; i++) {
	// Rectangle value = rects[i];
	// int spot = i - 1;
	//
	// while (spot > -1 && value.compareTo(rects[spot]) < 0) {
	// rects[spot + 1] = rects[spot];
	// spot--;
	// rects[spot + 2] = new Rectangle(rects[spot + 2]);
	// for (int j = 1; j < 5; j++) {
	// cp1.getRects()[spot + 1].setColor(j % 2);// flash the one moving
	// JFrame1.repaint();
	// try {
	// Thread.sleep(200);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }
	// rects[spot + 1] = value;
	// JFrame1.repaint();
	// try {
	// Thread.sleep(200);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }

}
