package Model;

/**
 * Created by teo on 12/16/2016.
 */
public class ExpressionBoolean extends Exp {

    String operator;
    Exp exp1, exp2;

    public ExpressionBoolean(String operator, Exp exp1, Exp exp2) {
        this.operator = operator;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public int eval(IMyDictionary<String, Integer> tbl, IHeap heap){
        boolean result;
        if (operator == "<")
            result = exp1.eval(tbl, heap) < exp2.eval(tbl, heap);
        else if (operator == "<=")
            result = exp1.eval(tbl, heap) <= exp2.eval(tbl, heap);
        else if (operator == "==")
            result = exp1.eval(tbl, heap) == exp2.eval(tbl, heap);
        else if (operator == "!=")
            result = exp1.eval(tbl, heap) != exp2.eval(tbl, heap);
        else if (operator == ">=")
            result = exp1.eval(tbl, heap) >= exp2.eval(tbl, heap);
        else if (operator == ">")
            result = exp1.eval(tbl, heap) > exp2.eval(tbl, heap);
        else return -1; //this should never happen
        if (result == false)
            return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return exp1.toString() + operator + exp2.toString();
    }
}
