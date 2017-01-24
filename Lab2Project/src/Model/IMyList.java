package Model;

import java.io.Serializable;

/**
 * Created by teo on 10/16/2016.
 */
public interface IMyList<T> extends Serializable {
    void add(T object);
    void remove(int pos);
    T get(int pos);
}
