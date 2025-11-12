import java.util.ArrayList;
import java.util.List;

public class EventManager
{
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber)
    {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber)
    {
        subscribers.remove(subscriber);
    }

    public void publish(GameEvent gameEvent)
    {
        for (Subscriber s : subscribers)
        {
            s.onEvent(gameEvent);
        }
    }
}