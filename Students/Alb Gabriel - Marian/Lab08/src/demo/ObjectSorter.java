package demo;

public class ObjectSorter {

    public Comparable[] sort(Comparable[] objects, boolean ascending) {
        // your code here
        for(int i = 0; i < objects.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < objects.length; j++) {
                int comparation = objects[j].compareTo(objects[min]);
                if ((ascending && comparation < 0) || (!ascending && comparation > 0)) {
                    min = j;
                }
            }
            Comparable aux = objects[min];
            objects[min] = objects[i];
            objects[i] = aux;
        }
        return objects;
    }
}
