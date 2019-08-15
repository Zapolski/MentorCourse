package by.zapolski.week03;

import by.zapolski.week03.task4.ConcatNodesBfsService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatNodesBfsServiceTest extends BaseAbstractTest {

    private ConcatNodesBfsService concatNodesBfsService = new ConcatNodesBfsService();

    @Test
    public void getCountNodeLoopImplTest() {
        assertEquals("FBGADICEH", concatNodesBfsService.getConcatNodesString(binaryTree));
    }

}
