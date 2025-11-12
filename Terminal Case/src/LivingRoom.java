import events.GetHammerEvent;
import events.InputEvent;
import events.PrintMessageEvent;
import publisherSubscriber.GameEvent;

public class LivingRoom extends AbstractRoom
{
    enum states
    {
        introMessage,
        choosingInteraction,
        gettingHammer
    }

    states currentState = states.introMessage;

    GameManager gameManager;

    public LivingRoom(GameManager gameManager)
    {
        this.gameManager = gameManager;
    }

    @Override
    public void enter()
    {
        GameEvent.BUS.subscribe(this);
        System.out.println("\nA sala está majoritariamente limpa");
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof InputEvent inputEvent)
        {
            if (currentState == states.introMessage)
            {
                showChoices();
                currentState = states.choosingInteraction;
            }
            else if (currentState == states.choosingInteraction)
            {
                interaction(inputEvent.key);
            }
            else if (currentState == states.gettingHammer)
            {
                if (inputEvent.key.equals("s"))
                {
                    GameEvent.BUS.publish(new GetHammerEvent());

                    showChoices();
                    currentState = states.choosingInteraction;
                }
                else if (inputEvent.key.equals("n"))
                {
                    showChoices();
                    currentState = states.choosingInteraction;
                }
            }
        }
    }

    private void showChoices()
    {
        GameEvent.BUS.publish(new PrintMessageEvent("\n 1 - Verificar o sofá"));

        GameEvent.BUS.publish(new PrintMessageEvent("\n 2 - Arrastar o sofá"));

        GameEvent.BUS.publish(new PrintMessageEvent("\n 3 - Verificar o hack da TV"));
    }

    private void interaction(String key)
    {
        if (key.equals("1"))
        {
            GameEvent.BUS.publish(new PrintMessageEvent("\n Parece limpo."));
            currentState = states.introMessage;
        }

        else if (key.equals("2"))
        {
            if (gameManager.player.hasItem("Martelo"))
            {
                GameEvent.BUS.publish(new PrintMessageEvent("\nDepois de um bom esforço, consegui serrar os " +
                        "pregos e arrastar o sofá."));
                GameEvent.BUS.publish(new PrintMessageEvent("Atrás do sofá tinha uma seringa com sangue na " +
                        "agulha."));
                GameEvent.BUS.publish(new PrintMessageEvent("Eu acho que é seguro assumir que a vítima morreu " +
                        "por causa de uma overdose."));
            }
            else
            {
                GameEvent.BUS.publish(new PrintMessageEvent("\n O sofá está pregado na parede por algum " +
                        "motivo. Vou precisar de alguma coisa mais forte se eu quiser movê-lo."));
                currentState = states.introMessage;
            }
        }

        else if (key.equals("3"))
        {
            currentState = states.gettingHammer;

            if (gameManager.player.hasItem("Martelo"))
            {
                GameEvent.BUS.publish(new PrintMessageEvent("\n Já peguei o martelo, não parece ter mais " +
                        "nada de útil aqui"));
                showChoices();
                currentState = states.choosingInteraction;
            }

            else
            {
                GameEvent.BUS.publish(new PrintMessageEvent("\nTem alguns acessórios na gaveta. Não há nada " +
                        "muito útil a princípio a não ser um martelo. Devo pegar?"));

                GameEvent.BUS.publish(new PrintMessageEvent("\nS - sim"));
                GameEvent.BUS.publish(new PrintMessageEvent("N - não"));
            }
        }
    }
}
