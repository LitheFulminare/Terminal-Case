public class Main
{
    static GameManager gameManager = new GameManager();

    public static void main(String[] args)
    {
        gameManager.start();

        boolean isGameRunning = true;

        while(isGameRunning)
        {
            gameManager.update();
        }
    }
}