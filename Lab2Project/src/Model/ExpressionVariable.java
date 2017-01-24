package Model;

/**
 * Created by teo on 10/20/2016.
 */
public class ExpressionVariable extends Exp {
    String id;

    public ExpressionVariable(String id) {
        this.id = id;
    }

    @Override
    public int eval(IMyDictionary<String, Integer> tbl, IHeap heap) {
        return tbl.get(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
