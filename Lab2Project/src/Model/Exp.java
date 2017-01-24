package Model;

import java.io.Serializable;

/**
 * Created by teo on 10/20/2016.
 */
abstract class Exp implements Serializable {
    public abstract int eval(IMyDictionary<String, Integer> tbl, IHeap heap);
    public abstract String toString();
}
