package main;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import canvas.FracPanel;

/**
 * 
 * @author Andrew
 *
 */
public class Main {
	static Container cp;
	static FracPanel fp;
	
	public static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("Interactive Fractal Demo");
		cp = frame.getContentPane();
		fp = new FracPanel();
		
		init();
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static void init(){

		//Testing absolute layout
		
		/*
		cp.setLayout(null);
		
		cp.add(fp.ft.dSlider);
		
		
		
		cp.add(fp.ft.uSlider);
		cp.add(fp.ft.theta1Slider);
		cp.add(fp.ft.theta2Slider);
		cp.add(fp.ft.iSlider);
		*/
		
		
		//I tried Grid Bag Layout below
		
		
		// /*
	
		cp.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//c.gridheight = 6;
		//c.gridwidth = 1;
		//c.fill = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		
		cp.add(fp.ft.dSlider, c);

		c.gridx = 0;
		c.gridy = 1;
		cp.add(fp.ft.uSlider, c);
		c.gridx = 0;
		c.gridy = 2;
		cp.add(fp.ft.theta1Slider, c);
		c.gridx = 0;
		c.gridy = 3;
		cp.add(fp.ft.theta2Slider, c);
		c.gridx = 0;
		c.gridy = 4;
//		c.anchor = GridBagConstraints.LINE_START;
		cp.add(fp.ft.iSlider, c);
		c.gridx = 0;
		c.gridy = 5;
		cp.add(fp, c);
		
		// */
		
	}
}
