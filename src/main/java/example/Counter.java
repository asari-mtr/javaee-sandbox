package example;

import javax.ejb.Singleton;

/**
 * Created by asari on 2015/05/12.
 */
@Singleton
public class Counter {
    private int i ;
    public void add() {
        i++;
    }

    public int now() {
        return i;
    }
}
