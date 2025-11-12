package events;

import publishersubscriber.GameEvent;

public class RoomEnteredEvent implements GameEvent
{
    public final String roomName;

    public RoomEnteredEvent(String roomName)
    {
        this.roomName = roomName;
    }
}
