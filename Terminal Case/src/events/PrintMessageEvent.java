package events;

import publisherSubscriber.GameEvent;

public class PrintMessageEvent implements GameEvent
{
    public final String roomName;

    public PrintMessageEvent(String roomName)
    {
        this.roomName = roomName;
    }
}
