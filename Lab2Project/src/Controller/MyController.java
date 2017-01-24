package Controller;

import Model.*;
import Repo.MyRepoInt;
import Repo.RepoException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by teo on 10/28/2016.
 */
public class MyController implements IMyController {
    MyRepoInt repo;
    ExecutorService executor;

    public MyController(MyRepoInt repo) {
        this.repo = repo;
    }

    @Override
    public void add(ProgState prog) throws RepoException {
        repo.add(prog);
    }

    @Override
    public ProgState execStep() {
        ProgState prog = repo.getCurrent();
        IMyStack<IStatement> stk = prog.getExSt();
        if (stk.isEmpty())
            return null; //throw exception
        IStatement stmt = stk.pop();
        return stmt.execute(prog);
    }

    @Override
    public void allStep() {/*
        ProgState prg = repo.getCurrent();
        IMyStack<IStatement> stk = prg.getExSt();
        while(!stk.isEmpty()){
            execStep();
            conservativeGarbageCollector(prg.getSymTable(), prg.getHeap());
            repo.logProgState(prg);
        }
        return prg.getOut();*/
        executor = Executors.newFixedThreadPool(2);
        while(true){
            List<ProgState> prgList=removeCompleted(repo.get_all());
            if(prgList.size() ==0)
                break;
            oneStepForAll(prgList);
        }
        executor.shutdownNow();
    }

    @Override
    public List<ProgState> removeCompleted(List<ProgState> prgList) {
        return prgList.stream().filter(p -> !p.isComplete()).collect(Collectors.toList());
    }

    @Override
    public void oneStepForAll(List<ProgState> prgList) {
        prgList.forEach(p->repo.logProgState(p));
        List<Callable<ProgState>> callList = new ArrayList<Callable<ProgState>>();
        for(ProgState state : prgList) {
            callList.add((Callable<ProgState>)()-> state.execStep());
        }
        List<ProgState> newList = new ArrayList<ProgState>();
        try {
            newList = executor.invokeAll(callList).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            })
                    .filter(p->p!=null)
                    .collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prgList.addAll(newList);
        prgList.forEach(p->repo.logProgState(p));
        repo.set_list(prgList);
    }
/*
    @Override
    public void oneStepForAll(List<ProgState> list){
        List<Callable<ProgState>> callList = new ArrayList<Callable<ProgState>>();
        for(ProgState state: list){
            callList.add((Callable<ProgState>)()->state.execStep());
        }
        try {
            List<ProgState> newPrgList =
                    executor.invokeAll(callList).stream().map(future->{
                        //lambda function that does stuff, i can't eli5 it so i'm not sure
                        try {
                            return future.get();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }).filter(p -> p!=null).collect(Collectors.toList());
            this.getRepo().get_all().addAll(newPrgList);
            this.getRepo().get_all().forEach(prg ->{
                    this.getRepo().logProgState(prg);
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
*/
    private Map<Integer,Integer> conservativeGarbageCollector(IMyDictionary<String,Integer> st, IHeap hp){
        List<Integer> vals=st.getAll().stream().map(v->v.getValue()).collect(Collectors.toList());
        return hp.getAll().stream().filter(e->vals.contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public MyRepoInt getRepo() {
        return repo;
    }
}
