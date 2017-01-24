package Model;

import java.io.Serializable;

/**
 * Created by teo on 10/20/2016.
 */
public class ProgState implements Serializable{
    IMyStack<IStatement> exSt;
    IMyDictionary<String, Integer> symTable;
    IMyList<Integer> out;
    IHeap heap;
    FileTable fileTable;
    int id;

    public ProgState(int id, IMyStack<IStatement> exSt, IMyDictionary<String, Integer> symTable, IMyList<Integer> out, IStatement program, IHeap heap) {
        this.id = id;
        this.exSt = exSt;
        this.symTable = symTable;
        this.out = out;
        this.exSt.push(program);
        this.heap = heap;
    }

    public ProgState(int id, IMyStack<IStatement> exSt, IMyDictionary<String, Integer> symTable, IMyList<Integer> out, IStatement program, IHeap heap, FileTable fileTable) {
        this.id = id;
        this.exSt = exSt;
        this.symTable = symTable;
        this.out = out;
        this.exSt.push(program);
        this.heap = heap;
        this.fileTable = fileTable;
    }

    public ProgState(IMyStack<IStatement> exSt, IMyDictionary<String, Integer> symTable, IMyList<Integer> out, IStatement program, IHeap heap) {
        this.id = 1;
        this.exSt = exSt;
        this.symTable = symTable;
        this.out = out;
        this.exSt.push(program);
        this.heap = heap;
    }

    public IMyStack<IStatement> getExSt() {
        return exSt;
    }

    public IMyDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public IMyList<Integer> getOut() {
        return out;
    }

    public IHeap getHeap() { return heap; }

    public Boolean isComplete(){
        return exSt.isEmpty();
    }

    public ProgState execStep() {
        if (exSt.isEmpty())
            return null;
        IStatement stmt = exSt.pop();
        return stmt.execute(this);
    }

    @Override
    public String toString() {
        return "ProgState{" +
                "id=" + id +
                "exSt=" + exSt +
                ", symTable=" + symTable +
                ", out=" + out +
                ", heap="+ heap +
                '}';
    }


    public int getId() {
        return id;
    }

    public FileTable getFileTable() {
        return fileTable;
    }
}
