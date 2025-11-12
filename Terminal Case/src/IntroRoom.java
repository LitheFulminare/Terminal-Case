import events.InputEvent;
import events.PrintMessageEvent;
import publisherSubscriber.GameEvent;

public class IntroRoom extends AbstractRoom
{
    enum states
    {
        choosingName,
        introMessage,
        chooseInteraction
    }

    states currentState = states.choosingName;

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
        GameEvent.BUS.publish(new PrintMessageEvent(message));
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof InputEvent inputEvent)
        {
            if (currentState == states.choosingName)
            {
                gameManager.setPlayerName(inputEvent.key);
                currentState = states.introMessage;

                introMessage();
            }
            if (currentState == states.chooseInteraction)
            {
                showChoices();
            }
        }
    }

    private void introMessage()
    {
        GameEvent.BUS.publish(new PrintMessageEvent("\nCerto, senhor " + gameManager.player.name + ", o caso é o seguinte…"));

        GameEvent.BUS.publish(new PrintMessageEvent("\nOntem de madrugada, foi feita uma ligação de emergência " +
                "diretamente desse apartamento. Ninguém falou nada, só ouve uma batida forte no fundo, então a ligação caiu."));

        GameEvent.BUS.publish(new PrintMessageEvent("O despachante acionou uma viatura e quando os policiais chegaram," +
                " encontraram o corpo dessa mulher."));

        GameEvent.BUS.publish(new PrintMessageEvent("Procuraram a casa inteira, mas não encontraram nenhum " +
                "sinal de identidade ou algum jeito de identificar a vítima. É aí que você entra."));

        GameEvent.BUS.publish(new PrintMessageEvent("Precisamos ques você vasculhe o apartamento e investigue " +
                "o corpo da vítima para descobrir sua identidade e a causa da morte"));

        GameEvent.BUS.publish(new PrintMessageEvent("Tenho outros assuntos a tratar, então vou te deixar " +
                "fazer o seu trabalho. Boa sorte, " + gameManager.player.name + "."));

        currentState = states.chooseInteraction;
    }

    private void showChoices()
    {
        GameEvent.BUS.publish(new PrintMessageEvent("\n 1 - Verificar o corpo da vítima"));

        GameEvent.BUS.publish(new PrintMessageEvent("\n 2 - Verificar a sala de estar"));

        GameEvent.BUS.publish(new PrintMessageEvent("\n 3 - Verificar a cozinha"));

        GameEvent.BUS.publish(new PrintMessageEvent("\n 4 - Verificar o quarto"));
    }
}
