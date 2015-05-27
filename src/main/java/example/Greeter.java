package example;

import javax.inject.Named;

/**
 * Created by asari on 2015/05/25.
 */
@Named
public class Greeter {
    public String say() {
        return "Hello";
    }
}
