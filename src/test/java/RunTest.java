import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        features = "classpath:features",
        glue = "step",
        tags = "@test2"
//        tags = "@test1 or @test2"
//, dryRun = true

)
public class RunTest {


}
