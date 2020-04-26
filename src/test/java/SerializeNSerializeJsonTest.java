import com.SerializeNSerializeSimpleJson;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SerializeNSerializeJsonTest {
    @BeforeTest
    public void SerializeNDeserialize() {
        SerializeNSerializeSimpleJson.SerializeUserSimple();
        SerializeNSerializeSimpleJson.DeSerializeUserSimple();
    }

    @Test
    public void SerializeTest() {
        Assert.assertTrue(SerializeNSerializeSimpleJson.SerializedJson.contains("Sunil"), "Sunil found in SerializedJson");
        Assert.assertTrue(SerializeNSerializeSimpleJson.DeserailizedUSerSimple.getName().equals("Sunil"), "Sunil found in De-SerializedJson");

    }
}
