package Model;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by teo on 10/20/2016.
 */
public interface IMyDictionary<K, V> extends Serializable {
    public V get(K key);
    public boolean isEmpty();
    public V put(K key, V value);
    public V remove(K key);
    public Set<Map.Entry<K,V>> getAll();
    public int size();
}
