package by.zapolski.week03;

import by.zapolski.week03.task1.CountNodeService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatNodesBfsServiceTest extends BaseAbstractTest{

    private CountNodeService countNodeService = new CountNodeService();

    @Test
    public void getCountNodeLoopImplTest(){
        assertEquals(9,countNodeService.getCountNodeLoopImpl(binaryTree));
    }

    @Test
    public void getCountNodeRecImplTest(){
        assertEquals(9,countNodeService.getCountNodeRecImpl(binaryTree));
    }
}
