package Controller;

        import Model.ProgState;
        import Repo.RepoException;

        import java.util.List;

/**
 * Created by teo on 10/28/2016.
 */
public interface IMyController {
    void add(ProgState prog) throws RepoException;
    ProgState execStep();
    void allStep();
    List<ProgState> removeCompleted(List<ProgState> prgList);
    //void allStep();
    void oneStepForAll(List<ProgState> prg);

}
