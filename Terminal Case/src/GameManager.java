public class GameManager
{
    static boolean awaitingName = false;

     Player player = new Player();
     TerminalManager terminalManager = new TerminalManager();

     IntroRoom introRoom = new IntroRoom(this);

     public void waitMillis(long waitTime)
     {
         try
         {
             wait(waitTime);
         }
         catch (InterruptedException e)
         {
             throw new RuntimeException(e);
         }
     }

    public void start()
    {
        introRoom.enter();
    }

    public void update()
    {
        InputManager.checkForInput();
    }

    public void setPlayerName(String name)
    {
        player.setName(name);
    }
}
