import events.InputEvent;
import events.PrintMessageEvent;
import publisherSubscriber.GameEvent;


public class LivingRoom extends AbstractRoom
{
    @Override
    public void enter()
    {
        System.out.println("hmm coisas");
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {

    }
}
