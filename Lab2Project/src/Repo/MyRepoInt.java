package Repo;
import Model.*;

import java.util.List;

/**
 * Created by teo on 10/28/2016.
 */
public interface MyRepoInt {
    void add(ProgState prg) throws RepoException;
    void pop(ProgState prg) throws RepoException;
    void logProgState(ProgState state);
    List<ProgState> get_all();
    void set_list(List<ProgState> list);
    void serialize(String filePath);
    void deserialize(String filePath);
    ProgState getCurrent();
}
