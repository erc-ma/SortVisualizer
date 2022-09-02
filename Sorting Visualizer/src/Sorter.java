import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;

public class Driver {


	public static void main(String[] args) {

        int goAgain;
		do {
            int volume = 0;

		//ADD USER INPUT set myDirectoryPath
        String path = JOptionPane.showInputDialog("What is the pathname for your directory?");
        String thicknessString = JOptionPane.showInputDialog("How thick are your cross-sections (micrometers)");
        int thickness = Integer.parseInt(thicknessString);
		File dir = new File(path);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				volume+=executeProgram(child)*thickness;
			}
		} 
        JOptionPane.showMessageDialog(null,"Your volume is "+volume+" px by um");

			goAgain = JOptionPane.showConfirmDialog(null, "Do you want to go again?");
		} while (goAgain == JOptionPane.YES_OPTION);

	

	}

	public static int executeProgram(File originalImage) {

		SelectedRegion reg = new SelectedRegion();
		BufferedImage img = null;
		try {
			img = ImageIO.read(originalImage);

			scanImage(img, reg); // IF BUTTON IS PRESSED, scan image for PT
            return reg.getArea();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            return 0;
		}
	}

	public static void scanImage(BufferedImage img, SelectedRegion reg) {
		for (int x = 0; x < img.getWidth(); x++) { // goes through all pixels of the image and
			for (int y = 0; y < img.getHeight(); y++) {
				if (hueDistance(Constants.COLOR_PT, new Color(img.getRGB(x, y))) <= hueDistance(Constants.COLOR_BG,
						new Color(img.getRGB(x, y)))
						&& hueDistance(Constants.COLOR_PT, new Color(img.getRGB(x, y))) <= hueDistance(Constants.COLOR_TH,
								new Color(img.getRGB(x, y)))) { // if PT+
					int[] temp = { x, y }; // insert the coordinates of the pixel
					reg.update(temp);
				}

			}
		}

	}


	public static int getHue(Color a) {

		float min = Math.min(Math.min(a.getRed(), a.getGreen()), a.getBlue());
		float max = Math.max(Math.max(a.getRed(), a.getGreen()), a.getBlue());

		if (min == max) {
			return 0;
		}

		float hue = 0f;
		if (max == a.getRed()) {
			hue = (a.getGreen() - a.getBlue()) / (max - min);

		} else if (max == a.getGreen()) {
			hue = 2f + (a.getBlue() - a.getRed()) / (max - min);

		} else {
			hue = 4f + (a.getRed() - a.getGreen()) / (max - min);
		}

		hue = hue * 60;
		if (hue < 0)
			hue = hue + 360;
		return Math.round(hue);
	}

	public static int hueDistance(Color a, Color b) { // returns the distance of 2 colors based on hue
		float avgHue = (getHue(a) + getHue(b)) / 2;
//		System.out.print(Math.round(Math.abs(getHue(a) - avgHue)));
		return Math.round(Math.abs(getHue(a) - avgHue));
	}

}
