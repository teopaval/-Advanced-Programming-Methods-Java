package Model;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by teo on 12/12/2016.
 */
public interface IHeap extends Serializable{
    public int get(int key);
    public int put(int value);
    public int edit(int key, int value);
    public Set<Map.Entry<Integer, Integer>> getAll();
    public boolean isEmpty();
    public int size();
}
