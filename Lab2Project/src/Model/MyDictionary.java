package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by teo on 10/28/2016.
 */
public class MyDictionary<K, V> implements IMyDictionary<K, V> {
    HashMap<K, V> data;

    public MyDictionary() {
        this.data = new HashMap<K, V>();
    }

    public MyDictionary(MyDictionary<K, V> another){
        this.data = new HashMap<K, V>();
        this.data = (HashMap) another.data.clone();
    }

    @Override
    public V get(K key) {
        return data.get(key);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        return data.put(key, value);
    }

    @Override
    public V remove(K key) {
        return data.remove(key);
    }

    @Override
    public Set<Map.Entry<K,V>> getAll() {
        return data.entrySet();
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
