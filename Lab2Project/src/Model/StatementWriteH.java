package Model;

/**
 * Created by teo on 12/12/2016.
 */
public class StatementWriteH implements IStatement {
    String var_name;
    Exp exp;

    public StatementWriteH(String var_name, Exp exp) {
        this.var_name = var_name;
        this.exp = exp;
    }

    @Override
    public ProgState execute(ProgState state) {
        IHeap heap = state.getHeap();
        IMyDictionary<String, Integer> dic = state.getSymTable();
        heap.edit(dic.get(var_name), exp.eval(dic, heap));
        return null;
    }

    public String toString(){
        return "WriteH(" + var_name + ", " + exp.toString() + ")";
    }
}
