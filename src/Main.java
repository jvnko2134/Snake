public class Main {

    public static void main(String[] args)   {

        Window window = new Window(DEFINITIONS.SCREEN_WIDTH, DEFINITIONS.SCREEN_HEIGHT, DEFINITIONS.WINDOW_TITLE);
        Thread thread = new Thread(window);

        thread.start();

    }

}
