import events.InputEvent;
import events.RoomEnteredEvent;
import publisherSubscriber.GameEvent;

public class IntroRoom extends AbstractRoom
{
    GameManager gameManager;

    public IntroRoom(GameManager gameManager)
    {
        this.gameManager = gameManager;
    }

    @Override
    public void enter()
    {
        GameEvent.BUS.subscribe(this);

        // emite o evento
        String message = "Ah, você deve ser o investigador forense. Qual seu nome mesmo?";
        GameManager.awaitingName = true;
        GameEvent.BUS.publish(new RoomEnteredEvent(message));
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof InputEvent inputEvent)
        {
            gameManager.setPlayerName(inputEvent.key);
        }
    }
}
