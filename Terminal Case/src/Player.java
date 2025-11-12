import events.GetHammerEvent;
import publisherSubscriber.GameEvent;
import publisherSubscriber.Subscriber;

public class Player implements Subscriber
{
    Inventory inventory = new Inventory();

    String name;

    public Player()
    {
        GameEvent.BUS.subscribe(this);
    }

    @Override
    public void onEvent(GameEvent gameEvent)
    {
        if (gameEvent instanceof GetHammerEvent getHammerEvent)
        {
            addItem(new Hammer());
        }
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public boolean hasItem(String item)
    {
        for (Item i : inventory.items)
        {
            if (i.getName().equalsIgnoreCase(item))
                return true;
        }
        return false;
    }

    public void addItem(Item item)
    {
        inventory.items.add(item);
    }
}
