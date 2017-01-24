package Model;

/**
 * Created by teo on 12/16/2016.
 */
public class StatementWhile implements IStatement {

    IStatement stmt;
    Exp exp;

    public StatementWhile(IStatement stmt, Exp exp) {
        this.stmt = stmt;
        this.exp = exp;
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyStack<IStatement> stk = state.getExSt();
        IMyDictionary<String, Integer> dic = state.getSymTable();
        IHeap heap = state.getHeap();
        if (exp.eval(dic, heap) == 0)
        {
            return state;
        }
        else
        {
            stk.push(this);
            stk.push(stmt);
        }
        return null;
    }

    public String toString(){
        return "While( " + exp.toString() + ") " + stmt.toString();
    }
}
