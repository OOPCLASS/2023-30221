public class AbstractEntityLong extends AbstractEntity<Long> {
    private static Long nextId = 1L;

    public AbstractEntityLong() {
        super(nextId++);
    }
}
