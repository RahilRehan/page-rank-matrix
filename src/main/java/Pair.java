package main.java;

public class Pair implements Comparable<Pair> {
    public final int index;
    public final Double value;

    public Pair(int index, Double value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return -1 * this.value.compareTo(other.value);
    }
}