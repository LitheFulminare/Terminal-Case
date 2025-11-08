public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player();

        boolean isGameRunning = true;

        while(isGameRunning)
        {
            update();
        }
    }

    public static void update()
    {
        InputManager.checkForInput();
    }
}