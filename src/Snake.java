import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Snake {

    public Rect[] body = new Rect[100];

    public double bodyWidth, bodyHeight;

    public int size, tail = 0, head = 0;

    public Direction direction = Direction.RIGHT;

    public double ogWaitBetweenUpdate = 0.1f;
    public double waitTimeLeft = ogWaitBetweenUpdate;

    public Snake(int size, double startX, double startY, double bodyWidth, double bodyHeight)   {

        this.size = size;

        this.bodyWidth = bodyWidth;
        this.bodyHeight = bodyHeight;

        for(int i=0;i<=size;i++)   {

            Rect bodyPiece = new Rect(startX + i * bodyWidth,startY,bodyWidth,bodyHeight);

            body[i] = bodyPiece;

            head++;

        }

        head--;

    }

    public void changeDirection(Direction newDirection)   {

        if(newDirection == Direction.RIGHT && direction != Direction.LEFT)    {

            direction = newDirection;

        } else if(newDirection == Direction.LEFT && direction != Direction.RIGHT) {

            direction = newDirection;

        } else if(newDirection == Direction.UP && direction != Direction.DOWN) {

            direction = newDirection;

        } else if(newDirection == Direction.DOWN && direction != Direction.UP) {

            direction = newDirection;

        }

    }

    public void update(double dt)    {

        if(waitTimeLeft > 0)    {

            waitTimeLeft -= dt;
            return;

        }

        if(intersectingSelf())  {

            Window.getWindow().changeState(0);

        }

        waitTimeLeft = ogWaitBetweenUpdate;

        double newX = 0;
        double newY = 0;

        if(direction == direction.RIGHT)    {

            newX = body[head].x + bodyWidth;
            newY = body[head].y;

        } else if(direction == Direction.LEFT) {

            newX = body[head].x - bodyWidth;
            newY = body[head].y;

        } else if(direction == Direction.UP) {

            newX = body[head].x;
            newY = body[head].y - bodyHeight;

        } else if(direction == Direction.DOWN) {

            newX = body[head].x;
            newY = body[head].y + bodyHeight;

        }

        body[(head + 1) % body.length] = body[tail];            //shifting 1 in the array to the next position
        body[tail] = null;
        head = (head + 1) % body.length;
        tail = (tail + 1) % body.length;

        body[head].x = newX;
        body[head].y = newY;

    }

    public boolean intersectingSelf()   {

        Rect headR = body[head];
        for(int i = tail; i != head-1; i = (i+1) % body.length)   {

            if(intersecting(headR,body[i])) return true;

        }

        return false;

    }

    public boolean intersectingWithRect(Rect rect)   {

        for(int i = tail; i != head; i = (i+1) % body.length)   {

            if(intersecting(rect,body[i])) return true;

        }

        return false;

    }

    public boolean intersecting(Rect r1, Rect r2)  {

        return(r1.x >= r2.x && r1.x <= r2.x + r2.width && r1.y >= r2.y && r1.y + r1.height <= r2.y +r2.height);

    }

    public void grow()  {



    }

    public void Draw(Graphics2D g2)  {

        for(int i = tail; i != head ; i = (i+1) % body.length)   {

            Rect piece = body[i];

            double subWidth = (piece.width - 6.0) / 2.0;
            double subHeight = (piece.height - 6.0) / 2.0;

            g2.setColor(Color.black);
            g2.fill(new Rectangle2D.Double(piece.x + 2.0, piece.y + 2.0,subWidth,subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 4.0 + subWidth,piece.y+2.0,subWidth,subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 2.0, piece.y + 4.0 +subWidth, subWidth,subHeight));
            g2.fill(new Rectangle2D.Double(piece.x + 4.0 + subWidth, piece.y + 4.0 + subHeight,subWidth,subHeight));

        }

    }

}
