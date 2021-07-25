import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class GameScene extends Scene {

    Rect background, foreground;
    Snake snake;
    KL keyListener;

    public Food food;

    public GameScene(KL keyListener)  {

        background = new Rect(0,0,DEFINITIONS.SCREEN_WIDTH,DEFINITIONS.SCREEN_HEIGHT);

        foreground = new Rect(24,48,DEFINITIONS.TILE_WIDTH * 51,24 * 27);

        snake = new Snake(5,48,48+DEFINITIONS.TILE_WIDTH,24,24);

        this.keyListener = keyListener;

        food = new Food(foreground,snake,13,13,Color.GREEN);

        food.spawn();

    }

    @Override
    public void update(double dt) {

        if(keyListener.isKeyPressed(KeyEvent.VK_UP))    {

            snake.changeDirection(Direction.UP);

        } else if(keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {

            snake.changeDirection(Direction.DOWN);

        } else if(keyListener.isKeyPressed(KeyEvent.VK_RIGHT)) {

            snake.changeDirection(Direction.RIGHT);

        } else if(keyListener.isKeyPressed(KeyEvent.VK_LEFT)) {

            snake.changeDirection(Direction.LEFT);

        }

        if(!food.isSpawned) food.spawn();

        snake.update(dt);
        food.update(dt);

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle2D.Double(background.x,background.y,background.width,background.height));

        g2.setColor(Color.white);
        g2.fill(new Rectangle2D.Double(foreground.x,foreground.y,foreground.width,foreground.height));

        snake.Draw(g2);
        food.draw(g2);

    }
}
