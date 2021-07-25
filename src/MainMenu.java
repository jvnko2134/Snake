import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends Scene{

    public KL keyListener;
    public ML mouseListener;
    public BufferedImage title, play, playPressed, exit, exitPressed;

    public Rect playRect, exitRect, titleRect;

    public BufferedImage playCurrentImage, exitCurrentImage;

    public MainMenu(KL keyListener, ML mouseListener) {

        this.keyListener = keyListener;

        this.mouseListener = mouseListener;

        try {

            BufferedImage spriteSheet = ImageIO.read(new File( "assets/menuSprite.png" ));

            title = spriteSheet.getSubimage(0,242,960,240);
            play = spriteSheet.getSubimage(0,121,261,121);
            playPressed = spriteSheet.getSubimage(264,121,261,121);
            exit = spriteSheet.getSubimage(0,0,233,93);
            exitPressed = spriteSheet.getSubimage(264, 0,233,93);

        } catch(Exception e){e.printStackTrace();}

        playCurrentImage = play;
        exitCurrentImage = exit;

        titleRect = new Rect(400,150,480,120);
        playRect = new Rect(580,400,130,60);
        exitRect = new Rect(580,550,120,47);

    }

    @Override
    public void update(double dt) {

        if(mouseListener.getX() >= playRect.x && mouseListener.getX() <= playRect.x + playRect.width &&
                mouseListener.getY() >= playRect.y && mouseListener.getY() <= playRect.y + playRect.height)    {

                    playCurrentImage = playPressed;                                                             /*Controls image swap when moving mouse over a valid option in main menu*/
                    if(mouseListener.isPressed)    {Window.getWindow().changeState(1);}

        } else  {

            playCurrentImage = play;                                                                            //play button

        }

        if(mouseListener.getX() >= exitRect.x && mouseListener.getX() <= exitRect.x + exitRect.width &&
                mouseListener.getY() >= exitRect.y && mouseListener.getY() <= exitRect.y + exitRect.height)    {

            exitCurrentImage = exitPressed;                                                                     //exit button
            if(mouseListener.isPressed)    {Window.getWindow().close();}

        } else  {

            exitCurrentImage = exit;

        }

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(new Color(72, 56, 125));

        g.fillRect(0,0,DEFINITIONS.SCREEN_WIDTH,DEFINITIONS.SCREEN_HEIGHT);

        g.drawImage(title, (int)titleRect.x,(int)titleRect.y,(int)titleRect.width,(int)titleRect.height,null);
        g.drawImage(playCurrentImage, (int)playRect.x, (int)playRect.y, (int)playRect.width,(int)playRect.height,null);
        g.drawImage(exitCurrentImage,(int)exitRect.x,(int)exitRect.y, (int)exitRect.width, (int)exitRect.height,null);

    }
}
