package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by teo on 1/23/2017.
 */
public class StatementOpenRFile implements IStatement {

    String fileID;
    String filename;

    public StatementOpenRFile(String filename) {
        this.filename = filename;
    }

    @Override
    public ProgState execute(ProgState state) {
        IMyStack<IStatement> exeStack = state.getExSt();
        FileTable fileTable = state.getFileTable();
        exeStack.pop();
        if (!fileTable.containsFile(filename)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
                int id = fileTable.add(filename, bufferedReader);
                state.getSymTable().put(fileID, id);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
