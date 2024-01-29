public class AbstractEntity {
    private long id;

    public AbstractEntity() {
        this.id = -1;
    }

    public AbstractEntity(long id) {
        this.id = id;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
}
