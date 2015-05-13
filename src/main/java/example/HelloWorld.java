package example;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.io.IOException;

/**
 * Created by asari on 2015/05/12.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    @Inject
    private Counter counter;
    @Resource
    private ManagedExecutorService ms;
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public void getClichedMessage(@Suspended final AsyncResponse ar) {
        // Return some cliched textual content
        final long v = (long) (Math.random() * 1000);
        counter.add();
        final String text = "Hello World " + counter.now() + "(" + v +
                ")";
        System.out.println("[START]" +text + this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(v);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[END  ]" +text + this);
                ar.resume(text);
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
    }
}
