package tests.debugging;

import mobile.helper.Onbording;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class DebugTest extends BaseTest {

    @Test
    public void debug(){
        Onbording onbording = new Onbording();
        onbording.completeIfPresents();
    }
}
