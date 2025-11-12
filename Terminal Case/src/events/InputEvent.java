package events;

import publishersubscriber.GameEvent;

public class InputEvent implements GameEvent
{
    public String key;

    public InputEvent(String key)
    {
        this.key = key;
    }
}
