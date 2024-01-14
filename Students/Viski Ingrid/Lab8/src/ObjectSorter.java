import java.util.Arrays;

public class ObjectSorter {

    public Comparable[] sort(Comparable[] objects, boolean ascending) {
        Comparable[] sortedArray = objects.clone();
        int lenght = sortedArray.length;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght - i -1; j++) {
                if ((ascending && sortedArray[j].compareTo(sortedArray[j + 1]) > 0) ||
                        (!ascending && sortedArray[j].compareTo(sortedArray[j + 1]) < 0)) {
                    Comparable temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}