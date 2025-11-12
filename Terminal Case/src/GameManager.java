import events.GoToLivingRoomEvent;
import publisherSubscriber.GameEvent;
import publisherSubscriber.Subscriber;

public class GameManager implements Subscriber
{
    static boolean awaitingName = false;

     Player player = new Player();
     TerminalManager terminalManager = new TerminalManager();

     AbstractRoom currentRoom = new IntroRoom(this);

    public void start()
    {
        GameEvent.BUS.subscribe(this);

        currentRoom.enter();
    }

    public void update()
    {
        InputManager.checkForInput();
    }

    public void setPlayerName(String name)
    {
        player.setName(name);
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof GoToLivingRoomEvent event)
        {
            currentRoom = new LivingRoom();
            currentRoom.enter();
        }
    }
}
