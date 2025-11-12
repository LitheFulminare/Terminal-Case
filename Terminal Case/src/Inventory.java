import events.InputEvent;
import publisherSubscriber.GameEvent;
import publisherSubscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Subscriber
{
    List<Item> items = new ArrayList<>();

    public Inventory()
    {
        GameEvent.BUS.subscribe(this);
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof InputEvent inputEvent)
        {
            if (inputEvent.key.equals("i"))
            {
                System.out.println("Inventory opened");
            }
        }
    }
}
