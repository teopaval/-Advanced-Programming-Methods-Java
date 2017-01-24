package Model;

/**
 * Created by teo on 10/20/2016.
 */
public class ExpressionArithmetic extends Exp{
    Exp e1;
    Exp e2;
    int op;

    public ExpressionArithmetic(String op, Exp e1, Exp e2) throws EvalException {
        this.e1 = e1;
        this.e2 = e2;
        if(op == "+")
            this.op = 1;
        else if (op == "-")
            this.op = 0;
        else throw new EvalException("Invalid arithmetic exception");
    }

    @Override
    public int eval(IMyDictionary<String, Integer> tbl, IHeap heap) {
        if(op == 1) //if op = 1 it's addition, else it's subtraction
            return (e1.eval(tbl, heap) + e2.eval(tbl, heap));
        else
            return (e1.eval(tbl, heap) - e2.eval(tbl, heap));
    }

    @Override
    public String toString() {

        if (op == 1)
            return e1.toString() + " " + "+" + " " + e2.toString();
        else
            return e1.toString() + " " + "-" + " " + e2.toString();
    }
}
