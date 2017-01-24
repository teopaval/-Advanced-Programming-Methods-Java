package Model;

/**
 * Created by teo on 10/28/2016.
 */
public class StatementConditional implements IStatement {
    Exp exp;
    IStatement thn;
    IStatement els;

    public StatementConditional(Exp exp, IStatement thn, IStatement els) {
        this.exp = exp;
        this.thn = thn;
        this.els = els;
    }

    @Override
    public String toString() {
        return "if (" + exp.toString() + ") then " + thn.toString() + " else " + els.toString();
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyStack<IStatement> stk = state.getExSt();
        IMyDictionary<String, Integer> dic = state.getSymTable();
        int result = exp.eval(dic, state.getHeap());
        if(result!=0)
            stk.push(thn);
        else
            stk.push(els);
        return null;
    }
}
