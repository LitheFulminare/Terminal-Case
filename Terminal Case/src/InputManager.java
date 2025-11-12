import events.InputEvent;
import publisherSubscriber.GameEvent;

import java.util.Scanner;

public class InputManager
{
    public static void checkForInput()
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        GameEvent.BUS.publish(new InputEvent(input));
    }
}
