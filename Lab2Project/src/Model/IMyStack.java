package Model;

import java.io.Serializable;

/**
 * Created by teo on 10/16/2016.
 */
public interface IMyStack<T> extends Serializable{
    boolean isEmpty();
    T pop();
    void push(T object);
}
