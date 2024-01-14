import java.util.Arrays;

class ComparableObjectsSorter<T extends Comparable<T>> {
    public void sort(T[] array) {
        Arrays.sort(array);
    }
}
