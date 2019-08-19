package by.zapolski.week03;

import by.zapolski.week03.task1.CountNodeService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountNodeServiceTest extends BaseAbstractTest {

    private CountNodeService countNodeService = new CountNodeService();

    @Test
    public void get() {
        assertEquals(9, countNodeService.getCountNodeRecImpl(binaryTree));
    }

}
