package Model;

/**
 * Created by teo on 10/20/2016.
 */
public class StatementCompound implements IStatement {
    IStatement first;
    IStatement second;

    public StatementCompound(IStatement first, IStatement second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first.toString() + "; " + second.toString();
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyStack<IStatement> stk = state.getExSt();
        stk.push(second);
        stk.push(first);
        return null;
    }
}
