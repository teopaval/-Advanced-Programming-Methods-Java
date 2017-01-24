package Model;

/**
 * Created by teo on 10/28/2016.
 */
public class StatementAssign implements IStatement {
    String id;
    Exp exp;

    public StatementAssign(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    public String toString() {
        return id + " = " + exp.toString();
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyStack<IStatement> stk = state.getExSt();
        IMyDictionary<String, Integer> dic = state.getSymTable();
        int result = exp.eval(dic, state.getHeap());
        dic.put(id, result);
        return null;
    }
}
