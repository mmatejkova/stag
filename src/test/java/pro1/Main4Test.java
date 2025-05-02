package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main4Test
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test01()
    {
        Main4.printShortestEmails("KIKM",5);
        // TODO 4.2: Oprav test
        assertEquals(
                "jan.vanek@uhk.cz\npetr.bauer@uhk.cz\njan.budina@uhk.cz\nfilip.maly@uhk.cz\nkarel.maly@uhk.cz\n",     //bylo správně, akorát u macu se píše pouze "/n" a ne "/r/n" co tam bylo předtím
                outContent.toString()
        );
    }
}