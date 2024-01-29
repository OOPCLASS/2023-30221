package test2oop;

import java.util.HashSet;

public abstract class AbstractEntity<ID> {
    private static long uniqueIdCounter = 0;
    private ID id;

    public AbstractEntity(ID id) {
        if(id instanceof Long) {
            uniqueIdCounter++;
            this.id = (ID) Long.valueOf(uniqueIdCounter);
        } else {
            uniqueIdCounter++;
            this.id = (ID) String.valueOf(uniqueIdCounter);
        }

    }

    public ID getId() {
        return id;
    }



}
