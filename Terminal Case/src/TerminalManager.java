import events.RoomEnteredEvent;
import publisherSubscriber.GameEvent;
import publisherSubscriber.Subscriber;

public class TerminalManager implements Subscriber
{

    public TerminalManager()
    {
        GameEvent.BUS.subscribe(this);
    }

    @Override
    public void onEvent(GameEvent event)
    {
        if (event instanceof RoomEnteredEvent e)
        {
            printMessage(e.roomName);
        }
    }

    public void printMessage(String message)
    {
        System.out.println(message);
    }

    public void printInteraction(String interaction)
    {
        System.out.println(interaction);
    }
}
