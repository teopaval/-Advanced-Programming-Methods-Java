package Model;

/**
 * Created by teo on 12/12/2016.
 */
public class ExpressionReadH extends Exp {
    String variable;

    public ExpressionReadH(String variable) {
        this.variable = variable;
    }

    @Override
    public int eval(IMyDictionary<String, Integer> tbl, IHeap heap) {
        return heap.get(tbl.get(variable));
    }

    @Override
    public String toString() {
        return "readH("+ variable + ") ";
    }
}
