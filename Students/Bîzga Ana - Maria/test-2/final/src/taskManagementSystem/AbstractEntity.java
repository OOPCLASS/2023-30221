package taskManagementSystem;

abstract class AbstractEntity<ID> {
    private ID id;

    public AbstractEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}
