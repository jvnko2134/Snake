import java.awt.Graphics;
import java.awt.Color;

public class GameScene extends Scene {
    @Override
    public void update(double dt) {

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.pink);
        g.fillRect(0,0,DEFINITIONS.SCREEN_WIDTH,DEFINITIONS.SCREEN_HEIGHT);

    }
}
