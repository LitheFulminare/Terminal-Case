public class Main
{
    static Player player = new Player();
    static TerminalManager terminalManager = new TerminalManager();

    static boolean isGameRunning = true;

    static Room room = new Room("Sala 1");

    public static void main(String[] args)
    {
        start();

        while(isGameRunning)
        {
            update();
        }
    }

    public static void start()
    {
        room.enter();
    }

    public static void update()
    {
        InputManager.checkForInput();
    }
}