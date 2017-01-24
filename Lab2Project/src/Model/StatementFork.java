package Model;

/**
 * Created by teo on 12/16/2016.
 */
public class StatementFork implements IStatement {

    IStatement stmt;

    public StatementFork(IStatement stmt) {
        this.stmt = stmt;
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyStack<IStatement> stack = new MyStack<IStatement>(50);
        stack.push(stmt);
        IMyDictionary<String, Integer> dic = new MyDictionary<String, Integer>((MyDictionary<String, Integer>) state.getSymTable());
        IMyList<Integer> list = state.getOut();
        IHeap heap = state.getHeap();
        return new ProgState(state.getId()*10,stack,dic,list,stmt,heap);
    }


    @Override
    public String toString() {
        return "fork(" + stmt.toString() + ") ";
    }
}
