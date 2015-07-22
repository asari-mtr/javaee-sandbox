package decorate;

import example.Greeter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class EditDecoratorTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Editable.class)
                .addClass(SampleEditor.class)
                .addClass(ExampleEditor.class)
                .addClass(EditDecorator.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @Inject
    private SampleEditor sampleEditor;
    @Inject
    private ExampleEditor exampleEditor;

    @Test
    public void testSave() throws Exception {
        assertThat(sampleEditor.save(), is("[Sample save!]"));
        assertThat(exampleEditor.save(), is("[Example save!]"));
    }

    @Test
    public void testDelete() throws Exception {
        assertThat(sampleEditor.delete(), is("[Sample delete!]"));
        assertThat(exampleEditor.delete(), is("[Example delete!]"));
    }
}