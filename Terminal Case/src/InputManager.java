import java.util.Scanner;

public class InputManager
{
    public static void checkForInput()
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        switch (input)
        {
            case "1":
                System.out.println("1 pressed");
                break;
            case "2":
                System.out.println("2 pressed");
                break;
            case "3":
                System.out.println("3 pressed");
                break;
            case "4":
                System.out.println("4 pressed");
                break;
            case "i":
                System.out.println("Inventory pressed");
                break;
        }
    }
}
