package shapes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *  Class MyOval for drawing ovals is derived
 *  from our 'base class' AbstratShape
 */
public class MyOval extends AbstractShape {
	private Ellipse2D.Double ellipse;
	
	public MyOval()
	{
		ellipse = new Ellipse2D.Double();
	}

	// Drawing routine
	public void Draw(Graphics2D g) {
		ellipse.setFrameFromDiagonal(startPos, endPos);
		g.setColor(Color.GREEN);
		g.draw(ellipse);
	}

}