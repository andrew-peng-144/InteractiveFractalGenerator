package fractalclasses;

import java.awt.Graphics2D;

public class SierpinskiCarpet {
    public static void draw(Graphics2D g2d, int u, int i, int x1, int y1){
    	if(i == 0)
    		return;
    	
    	g2d.drawRect(x1,y1,u,u);
    	
    	draw(g2d, u/(3*i), i-1, x1/3, y1/3);
    }
}
