package Repo;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by teo on 10/28/2016.
 */
public class MyRepo implements MyRepoInt{
    List<ProgState> data;
    int index, size;
    String logFilePath;

    public MyRepo(int size, String logFilePath) {
        data = new ArrayList<ProgState>();
        index = 1;
        this.size = size;
        this.logFilePath = logFilePath;
    }

    @Override
    public void add(ProgState prg) throws RepoException {
        data.add(prg);
    }

    @Override
    public void pop(ProgState prg) throws RepoException {
        if(data.isEmpty())
            throw new RepoException("Repo Empty");
        data.remove(prg);

    }

    @Override
    public void logProgState(ProgState state) {
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));

            IMyStack<IStatement> stk = state.getExSt();
            IMyDictionary<String, Integer> dic = state.getSymTable();
            IMyList<Integer> lst = state.getOut();
            IHeap heap = state.getHeap();
            logFile.println("------------------------------\n");
            logFile.println("ID: ");
            logFile.println(state.getId());
            logFile.println("ExeStack:\n");
            logFile.println(stk.toString());
            logFile.println("\nSymTable:\n");
            logFile.println(dic.toString());
            logFile.println("\nOut:\n");
            logFile.println(lst.toString());
            logFile.println("\nHeap:\n");
            logFile.println(heap.toString());
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ProgState> get_all() {
        return data;
    }

    @Override
    public void set_list(List<ProgState> list) {
        data = list;
    }

    @Override
    public void serialize(String filePath) {

    }

    @Override
    public void deserialize(String filePath) {

    }

    @Override
    public ProgState getCurrent() {
        if(index != 0) {
            return data.get(0);
        }
        return null; //throw exception
    }
}
