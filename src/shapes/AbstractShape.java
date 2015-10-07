package shapes;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * base class AbstractShape
 *
 */
public abstract class AbstractShape {
	protected Point startPos;
	protected Point endPos;
	
	public void setStart(Point pt) {
		startPos = pt;
	}

	public void setEnd(Point pt) {
		endPos = pt;
	}

	public abstract void Draw(Graphics2D g);

}