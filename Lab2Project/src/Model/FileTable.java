package Model;

import java.io.*;
import java.util.HashMap;

/**
 * Created by teo on 1/23/2017.
 */
public class FileTable {
    HashMap<Integer, Tuple<String, BufferedReader>> fileTable;
    HashMap<String, Integer> myFileDescriptor;
    int index = 0;

    public FileTable() {
        fileTable = new HashMap<Integer, Tuple<String, BufferedReader>>();
        myFileDescriptor = new HashMap<String, Integer>();
    }

    public int add(String filename, BufferedReader bufferedReader) {
        /*BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }*/

        Tuple<String, BufferedReader> tuple = new Tuple(filename, bufferedReader);
        if(!myFileDescriptor.containsKey(filename)) {
            int id = index++;
            fileTable.put(id, tuple);
            myFileDescriptor.put(filename, id);
            return id;
        }
        return -1;
    }

    public boolean containsFile(String filename){
        return myFileDescriptor.containsKey(filename);
    }

    @Override
    public String toString() {

        return myFileDescriptor.toString();
    }
}
