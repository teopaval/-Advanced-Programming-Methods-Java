package Model;

/**
 * Created by teo on 10/28/2016.
 */
public class StatementPrint implements IStatement {
    Exp exp;

    public StatementPrint(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "print(" + exp.toString() + ")";
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyList<Integer> lst = state.getOut();
        lst.add(exp.eval(state.getSymTable(), state.getHeap()));
        return null;
    }
}
