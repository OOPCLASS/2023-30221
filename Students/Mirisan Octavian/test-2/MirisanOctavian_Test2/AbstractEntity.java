public abstract class AbstractEntity<ID>
{

    protected ID id;

    public AbstractEntity(ID id)
    {
        this.id = id;
    }


    public ID getId()
    {
        return id;
    }

    public void setId(ID id)
    {
        this.id = id;
    }
}
