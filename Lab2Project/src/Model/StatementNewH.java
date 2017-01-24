package Model;

/**
 * Created by teo on 12/12/2016.
 */
public class StatementNewH implements IStatement {
    String var_name;
    Exp expression;

    public StatementNewH(String var_name, Exp expression) {
        this.var_name = var_name;
        this.expression = expression;
    }

    @Override
    public ProgState execute(ProgState state) {
        IHeap heap = state.getHeap();
        IMyDictionary<String, Integer> dic = state.getSymTable();
        dic.put(var_name, heap.put(expression.eval(dic, heap)));
        return null;
    }


    @Override
    public String toString() {
        return "new(" + var_name + ", " + expression.toString() + ") ";
    }
}
