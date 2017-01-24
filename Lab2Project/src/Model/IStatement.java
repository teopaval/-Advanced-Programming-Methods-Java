package Model;

import java.io.Serializable;

/**
 * Created by teo on 10/20/2016.
 */
public interface IStatement extends Serializable{
    ProgState execute(ProgState state);
}
