package events;

import publisherSubscriber.GameEvent;

public class InputEvent implements GameEvent
{
    public String key;

    public InputEvent(String key)
    {
        this.key = key;
    }
}
