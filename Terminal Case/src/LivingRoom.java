import events.InputEvent;
import events.PrintMessageEvent;
import publisherSubscriber.GameEvent;

public class LivingRoom extends AbstractRoom
{
    @Override
    public void enter()
    {
        GameEvent.BUS.subscribe(this);
        System.out.println("hmm coisas");
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof InputEvent inputEvent)
        {
            System.out.println("Input happened on living room");
        }
    }
}
