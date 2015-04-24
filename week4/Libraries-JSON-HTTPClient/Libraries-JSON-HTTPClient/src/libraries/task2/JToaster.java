package libraries.task2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;

public class JToaster {
	private static BufferedImage img = null;
	private static Toaster toaster;
	
	public static void start() {
		try {
			img = ImageIO.read(new File("ko4e.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		toaster = new Toaster();
		toaster.setBackgroundImage(img);
		toaster.setToasterHeight(600);
		toaster.setToasterWidth(900);
		toaster.setMessageColor(Color.RED);
		toaster.setBorderColor(Color.DARK_GRAY);
		
		while(true) {
			try {
				toaster.setStep(3);
				toaster.showToaster("You need to take a few rest!");
				Thread.sleep(3600000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
