package Model;

/**
 * Created by teo on 10/20/2016.
 */
public class ExpressionConstant extends Exp {
    int number;

    public ExpressionConstant(int number) {
        this.number = number;
    }

    @Override
    public int eval(IMyDictionary<String, Integer> tbl, IHeap heap) {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
