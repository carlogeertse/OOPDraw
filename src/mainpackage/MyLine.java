package mainpackage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *  Class MyLine for drawing lines is
 *  derived from our 'base' class AbstractShape
 */
public class MyLine extends AbstractShape {
	private Line2D.Double line;
	
	public MyLine()
	{
		line = new Line2D.Double();
	}

	// Drawing routine
	@Override
	public void Draw(Graphics2D g) {
		line.setLine(startPos, endPos);
		g.setColor(Color.RED);
		g.draw(line);
	}
}

// Class cLine ends
