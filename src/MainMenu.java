import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends Scene{

    public KL keyListener;
    public BufferedImage title, play, playPressed, exit, exitPressed;

    public MainMenu(KL keyListener) {

        this.keyListener = keyListener;

        try {

            BufferedImage spriteSheet = ImageIO.read(new File( "assets/menuSprite.png" ));

            title = spriteSheet.getSubimage(0,242,960,240);
            play = spriteSheet.getSubimage(0,121,261,121);
            playPressed = spriteSheet.getSubimage(264,121,261,121);
            exit = spriteSheet.getSubimage(0,0,233,93);
            exitPressed = spriteSheet.getSubimage(264, 0,233,93);

        } catch(Exception e){e.printStackTrace();}

    }

    @Override
    public void update(double dt) {

        if(keyListener.isKeyPressed(KeyEvent.VK_UP))    {

            System.out.println("yea");

        }

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.white);

        g.fillRect(0,0,DEFINITIONS.SCREEN_WIDTH,DEFINITIONS.SCREEN_HEIGHT);

        g.drawImage(title, 400,150,480,120,null);
        g.drawImage(play, 580, 400, 130,60,null);
        g.drawImage(exit,580,550, 120, 47,null);

    }
}
