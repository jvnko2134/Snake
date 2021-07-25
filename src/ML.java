import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ML implements MouseMotionListener, MouseListener {

    public boolean isPressed = false;

    public double x = 0.0f, y = 0.0f;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    public double getX()        { return this.x; }
    public double getY()        { return this.y; }
    public boolean isPressed()  { return this.isPressed; }

}
