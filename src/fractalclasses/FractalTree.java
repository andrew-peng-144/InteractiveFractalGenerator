package fractalclasses;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import canvas.FracPanel;

public class FractalTree {

	public JSlider dSlider;
	public JSlider uSlider;
	public JSlider theta1Slider;
	public JSlider theta2Slider;
	public JSlider iSlider;
	// DEFAULT VALUES
	
	public int h;
	public int k;
	int theta1;
	int theta2;
	public int imax;
	public int u;
	public double d;
	
	public FractalTree() {
		
		h = FracPanel.width/2;
		k = FracPanel.height - 100;
		theta1 = 30;
		theta2 = 45;
		imax = 5;
		u = 150;
		d = 0.7;

		// INITIALIZE ALL SLIDERS AND DEM LISTENERS!!!!!!!!!

		dSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, (int) (d * 100)); // actually is divided by 100
		// so it will be divided by 100.0
		
//		JLabel dLabel = new JLabel("Diminishing Factor: " + d);
//		dSlider.add(dLabel);
		
//		Hashtable<Integer, JLabel> labels = new Hashtable();
//		labels.put(new Integer(0), new JLabel("Diminishing Factor"));
//		labels.put(new Integer(5), new JLabel("sdfdaf"));
//		dSlider.setLabelTable(labels);
//		dSlider.setPaintLabels(true);

		dSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				d = slider.getValue() / 100.0;
			}
		});
		

		uSlider = new JSlider(JSlider.HORIZONTAL, 1, 300, u);
		uSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				u = slider.getValue();
			}
		});
		
		//System.out.println(uSlider.getMaximum());

		theta1Slider = new JSlider(JSlider.HORIZONTAL, -180, 180, (int) theta1);
		theta1Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				theta1 = slider.getValue();
			}
		});

		theta2Slider = new JSlider(JSlider.HORIZONTAL, -180, 180, (int) theta2);
		theta2Slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				theta2 = slider.getValue();
			}
		});

		iSlider = new JSlider(JSlider.HORIZONTAL, 0, 15, imax);
		iSlider.setMinorTickSpacing(1);
		//iSlider.setMajorTickSpacing(10);
		iSlider.setPaintTicks(true);

		iSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				imax = slider.getValue();
			}
		});

	}

	// Graphics2D g2d;



	public void setTestValues() {
		h = 300;
		k = 500;
		theta1 = 30;
		theta2 = 45;
		imax = 12;
		u = 150;
		d = 0.7;
	}
	// double mag1, mag2;
	/**
	 * 
	 * @param g2d
	 * @param x1
	 * @param y1
	 * @param theta
	 *            angle in degrees, should be set to 90 for perpendicular trunk
	 * @param i
	 *            current iterations, should be set to 0, exists only for
	 *            recursion
	 * @param mag1
	 *            the magnitude of the first line, should be set to the unit
	 *            length which is constant, exists for recursion
	 * @param u
	 *            unit length
	 * @param i
	 *            iterations
	 */
	public void draw(Graphics2D g2d, int x1, int y1, int theta, int i, double mag1) {

		if (i == this.imax)
			return;
		
		double mag2;

		if (i == 0) {
			mag2 = u;
		} else {
			mag2 = mag1 * d;
		}
		
		int x2 = (int) (x1 + Math.cos(Math.toRadians(theta)) * mag2);
		int y2 = (int) (y1 - Math.sin(Math.toRadians(theta)) * mag2);
		g2d.drawLine(x1, y1, x2, y2);
		
		g2d.drawString("Diminishing Factor (d) : "+d, 50, 50);
		g2d.drawString("Unit Length (u) : "+u, 50, 80);
		g2d.drawString("Theta1 (left) : "+theta1+" degrees", 50, 110);
		g2d.drawString("Theta2 (right) : "+theta2+" degrees", 50, 140);
		g2d.drawString("Iterations: (imax) : "+imax, 50, 170);

		g2d.drawString("BY ANDREW PENG", 50, 250);

		//TWO BRANCHES PER
		
		draw(g2d, x2, y2, theta + theta1, i + 1, mag2); // left arm

		draw(g2d, x2, y2, theta - theta2, i + 1, mag2); // right arm
	}

}
