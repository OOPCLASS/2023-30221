import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractEntity<ID> {
    private static final AtomicLong ID_COUNTER = new AtomicLong(0);

    private ID id;

    public AbstractEntity() {

        this.id = generateUniqueId();
    }

    private ID generateUniqueId() {
        return (ID) (getClass().getSimpleName() + "_" + ID_COUNTER.getAndIncrement());
    }

    public ID getId() {
        return id;
    }
}
