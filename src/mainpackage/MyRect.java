package mainpackage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

// Class cRect for drawing Rects is derived
// from our 'base class' cShape

public class MyRect extends AbstractShape {
	private Rectangle2D.Double rectangle;

	public MyRect()
	{
		rectangle = new Rectangle2D.Double();
	}
	// Drawing routine
	public void Draw(Graphics2D g) {
		rectangle.setFrameFromDiagonal(startPos, endPos);
		g.setColor(Color.BLUE); // Set default color
		g.draw(rectangle);
	}

}

// Class cRect ends
