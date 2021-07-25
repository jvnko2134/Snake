import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MainMenu extends Scene{

    public KL keyListener;

    public MainMenu(KL keyListener) {

        this.keyListener = keyListener;

    }

    @Override
    public void update(double dt) {

        if(keyListener.isKeyPressed(KeyEvent.VK_UP))    {

            System.out.println("yea");

        }

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.red);

        g.fillRect(0,0,DEFINITIONS.SCREEN_WIDTH,DEFINITIONS.SCREEN_HEIGHT);

    }
}
