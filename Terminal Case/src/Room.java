import events.RoomEnteredEvent;
import publisherSubscriber.GameEvent;

public class Room
{
    private final String name;

    public Room(String name) {
        this.name = name;
    }

    public void enter()
    {
        // emite o evento
        GameEvent.BUS.publish(new RoomEnteredEvent(name));
    }
}
