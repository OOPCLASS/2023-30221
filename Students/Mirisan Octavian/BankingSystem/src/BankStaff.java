public class BankStaff
{
    int id;
    String name;

    String position;

    //constructor
    public BankStaff(int id,String name,String position)
    {
        this.id=id;
        this.name=name;
        this.position=position;
    }

    //setter

    public void setName(String name)
    {
        this.name=name;
    }
    public void setPosition(String position)
    {
        this.position=position;
    }


    //getters

    public String getName()
    {
        return name;
    }

    public String getPosition() {
        return position;
    }


}
