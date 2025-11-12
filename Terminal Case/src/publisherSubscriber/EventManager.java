package publisherSubscriber;

import java.util.ArrayList;
import java.util.List;

// responsável por lidar com a inscrição de desinscrição nos eventos e chamar quando algo é publicado
public class EventManager
{
    private List<Subscriber> subscribers = new ArrayList<>();

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