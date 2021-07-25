import java.awt.Color;
import java.awt.Graphics;

public class MainMenu extends Scene{

    @Override
    public void update(double dt) {

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.red);

        g.fillRect(0,0,DEFINITIONS.SCREEN_WIDTH,DEFINITIONS.SCREEN_HEIGHT);

    }
}
