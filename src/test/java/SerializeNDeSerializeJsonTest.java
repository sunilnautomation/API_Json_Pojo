import com.SerializeNSerializeSimpleJson;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SerializeNDeSerializeJsonTest {
    @BeforeTest
    public void SerializeNDeserialize() throws FileNotFoundException, InterruptedException, IOException {
        SerializeNSerializeSimpleJson.SerializeUserSimple();
        SerializeNSerializeSimpleJson.DeSerializeUserSimple();
        SerializeNSerializeSimpleJson.SerializeUserSimplenWriteToFile();
        SerializeNSerializeSimpleJson.DeSerializeUserSimplenfromFile();
    }

    @Test
    public void TestSerialize() {
        Assert.assertTrue(SerializeNSerializeSimpleJson.SerializedJson.contains("Sunil"), "Sunil found in SerializedJson");
    }

    @Test
    public void TestDeSerialize() {
        Assert.assertTrue(SerializeNSerializeSimpleJson.DeserailizedUSerSimple.getName().equals("Sunil"), "Sunil found in De-SerializedJson");
    }

    @Test
    public void TestSerializeAndFileWrite() throws IOException, InterruptedException {
        Thread.sleep(100);
        File f = new File(System.getProperty("user.dir") + "/src/test/resources/UserSimple.json");
        Assert.assertTrue(f.exists(), "File: UserSimple.json, Exists");
    }

    @Test
    public void TestDeSerializeFromFileRead() throws IOException, InterruptedException {
        Assert.assertTrue(SerializeNSerializeSimpleJson.DeserailizedUSerSimplefromFile.getName().equals("Anil"), "Anil found in De-SerializedJson");
    }
}
