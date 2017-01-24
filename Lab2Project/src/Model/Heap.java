package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by teo on 12/12/2016.
 */
public class Heap implements IHeap {

    HashMap<Integer, Integer> data;
    int index;

    public Heap() {
        data = new HashMap<Integer, Integer>();
        index = 1;
    }


    @Override
    public int get(int key) {
        return data.get(key);
    }

    @Override
    public int put(int value) {
        data.put(index, value);
        index++;
        return index-1;
    }

    @Override
    public int edit(int key, int value) {
        return data.put(key, value);
    }

    @Override
    public Set<Map.Entry<Integer, Integer>> getAll() {
        return data.entrySet();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
