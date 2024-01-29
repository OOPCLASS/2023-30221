package demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

// AbstractEntity este entitatea/clasa de baza pt toate celelalte entitati/clase.
// Aceasta ajuta la metode comune pentru toate clasele derivate.

public abstract class AbstractEntity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}

