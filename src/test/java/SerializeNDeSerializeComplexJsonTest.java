import com.SerializeNSerializeComplexJson;
import com.SerializeNSerializeSimpleJson;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SerializeNDeSerializeComplexJsonTest {
    @BeforeTest
    public void SerializeNDeserialize() throws FileNotFoundException, InterruptedException, IOException {
        SerializeNSerializeComplexJson.SerializeUserComplex();
        SerializeNSerializeComplexJson.DeSerializeUserComplex();
        SerializeNSerializeComplexJson.SerializeUserComplexnWriteToFile();
        SerializeNSerializeComplexJson.DeSerializeUserSimplenfromFile();
    }

    @Test
    public void TestSerialize() {
        Assert.assertTrue(SerializeNSerializeComplexJson.SerializedJson.contains("Sunil"), "Sunil found in SerializedJson");
    }

    @Test
    public void TestDeSerialize() {
        Assert.assertTrue(SerializeNSerializeComplexJson.DeserailizedUSerComplex.getUserAddress().getCity().equals("Magdeburg"), "Magdeburg found in De-SerializedJson");
    }

    @Test
    public void TestSerializeAndFileWrite() throws IOException, InterruptedException {
        Thread.sleep(100);
        File f = new File(System.getProperty("user.dir") + "/src/test/resources/UserComplex.json");
        Assert.assertTrue(f.exists(), "File: UserComplex.json, Exists");
    }

    @Test
    public void TestDeSerializeFromFileRead() throws IOException, InterruptedException {
        Assert.assertTrue(SerializeNSerializeComplexJson.DeserailizedUSerComplexfromFile.getUserAddress().getHouseNumber().equals("41A"), "41A found in De-SerializedJson");
    }
}