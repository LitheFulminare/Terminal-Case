// still have to think more about it, but I think everything will be an Interactable, from people to objects
// Then they override interact(), or something like that

public abstract class Interactable
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
