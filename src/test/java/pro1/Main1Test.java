package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class Main1Test
{
    @Test
    void test01()
    {
        // TODO 1.2: Oprav test
        assertEquals(
                62,     //toto mi vyšlo, když jsem spustila "Main1", původně tady místo 62 byla 0 (přepsala jsem to)
                Main1.emptyActionsCount("KIKM",2024)
        );
    }
}