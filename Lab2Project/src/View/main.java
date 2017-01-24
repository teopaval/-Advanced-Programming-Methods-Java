package View;
import Controller.MyController;
import Controller.IMyController;
import Model.*;
import Repo.MyRepo;
import Repo.MyRepoInt;
import Repo.RepoException;

/**
 * Created by teo on 10/28/2016.
 */

public class main {
    public static void main(String[] args) {
        //v = 10; new(v, 20); print(100 + readH(v))
        IStatement ex1 = null;
        try {
            ex1 = new StatementCompound(new StatementAssign("v", new ExpressionConstant(10)), new StatementCompound(new StatementNewH("v", new ExpressionConstant(20)),
                    new StatementPrint(new ExpressionArithmetic("+", new ExpressionConstant(100), new ExpressionReadH("v")))));
        } catch (EvalException e) {
            e.printStackTrace();
        }
        ProgState prg1 = new ProgState(new MyStack<IStatement>(50), new MyDictionary<String, Integer>(), new MyList<Integer>(50),
                ex1, new Heap());
        MyRepoInt repo1 = new MyRepo(10, "log1.txt");
        IMyController ctrl1 = new MyController(repo1);
        //new(a, 10); editH(a, 20); print(readH(a))
        IStatement ex2 = new StatementCompound(new StatementNewH("a", new ExpressionConstant(10)), new StatementFork(new StatementWriteH("a", new ExpressionConstant(20))));
        IStatement ex3 = new StatementCompound(ex2, new StatementPrint(new ExpressionReadH("a")));
        ProgState prg2 = new ProgState(new MyStack<IStatement>(50), new MyDictionary<String, Integer>(), new MyList<Integer>(50),
                ex3, new Heap());
        MyRepoInt repo2 = new MyRepo(10, "log2.txt");
        IMyController ctrl2 = new MyController(repo2);
        //a = 2-2; if a then v = 2 else v = 3; print(v)
        IStatement ex4 = null;
        try {
            ex4 = new StatementAssign("a", new ExpressionArithmetic("-", new ExpressionConstant(2), new ExpressionConstant(2)));
        } catch (EvalException e) {
            e.printStackTrace();
        }
        IStatement ex5 = new StatementConditional(new ExpressionVariable("a"),new StatementAssign("v", new ExpressionConstant(2)), new StatementAssign("v",
                new ExpressionConstant(3)));
        IStatement ex6 = new StatementPrint(new ExpressionVariable("v"));
        IStatement ex7 = new StatementCompound(new StatementCompound(ex4, ex5), ex6);
        ProgState prg3 = new ProgState(new MyStack<IStatement>(50), new MyDictionary<String, Integer>(), new MyList<Integer>(50),
                ex7, new Heap());
        MyRepoInt repo3 = new MyRepo(10, "log3.txt");
        IMyController ctrl3 = new MyController(repo3);
        //v = 10; new(v,20); new(a,22); print(v);
        IStatement ex8 = new StatementCompound(new StatementNewH("v", new ExpressionConstant(10)), new StatementPrint(new ExpressionVariable("v")));
        ProgState prg4 = new ProgState(new MyStack<IStatement>(50), new MyDictionary<String, Integer>(), new MyList<Integer>(50),
                ex8, new Heap());
        MyRepoInt repo4 = new MyRepo(10, "log4.txt");
        IMyController ctrl4 = new MyController(repo4);
        //v=6; while(v) v=v-1;
        IStatement ex9 = null;
        try {
            ex9 = new StatementCompound(new StatementAssign("v", new ExpressionConstant(2)), new StatementWhile(new StatementAssign("v", new ExpressionArithmetic("-",
                    new ExpressionVariable("v"), new ExpressionConstant(1))), new ExpressionVariable("v") ));
        } catch (EvalException e) {
            e.printStackTrace();
        }
        ProgState prg5 = new ProgState(new MyStack<IStatement>(50), new MyDictionary<String, Integer>(), new MyList<Integer>(50), ex9, new Heap());
        MyRepoInt repo5 = new MyRepo(10, "log5.txt");
        IMyController ctrl5 = new MyController(repo5);
        try {
            ctrl1.add(prg1);
            ctrl2.add(prg2);
            ctrl3.add(prg3);
            ctrl4.add(prg4);
            ctrl5.add(prg5);
        } catch (RepoException e) {
            e.printStackTrace();
        }

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunCommand("1", ex1.toString(), ctrl1));
        menu.addCommand(new RunCommand("2", ex3.toString(), ctrl2));
        menu.addCommand(new RunCommand("3", ex7.toString(), ctrl3));
        menu.addCommand(new RunCommand("4", ex8.toString(), ctrl4));
        menu.addCommand(new RunCommand("5", ex9.toString(), ctrl5));

        menu.show();

        /*
        controller.allStep();
        System.out.print(ex1 + "\n");
        System.out.print(stk + "\n");
        System.out.print(dic + "\n");
        System.out.print(lst + "\n");*/
    }
}

