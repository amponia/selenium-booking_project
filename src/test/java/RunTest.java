import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        features = "classpath:features",
        glue = "step"
//, dryRun = true
)
public class RunTest {


}
