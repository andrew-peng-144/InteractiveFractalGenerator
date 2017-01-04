package canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import fractalclasses.FractalTree;

public class FracPanel extends JPanel {

	static ChosenFractal cf;
	
	public FractalTree ft;
	
	public static int width;
	public static int height;

	public FracPanel() {
		
		width = 1000;
		height = 600;
		setPreferredSize(new Dimension(width, height));

		cf = ChosenFractal.FRACTAL_TREE;

		switch (cf) {
		case FRACTAL_TREE:
			ft = new FractalTree();

			
			
			break;
		default:
			break;

		}
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("SANS_SERIF", Font.PLAIN, 20));
		switch (cf) {
		case FRACTAL_TREE:
			//System.out.println("test");
			// ft.setTestValues();
			ft.draw(g2d, ft.h, ft.k, 90, 0, ft.u);

			break;

		default:
			break;
		}

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();

	}

}
