package by.zapolski.week03;

import by.zapolski.week03.task3.ConcatNodesDfsService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConcatNodesDfsServiceTest extends BaseAbstractTest{

    ConcatNodesDfsService concatNodesDfsService = new ConcatNodesDfsService();

    @Test
    public void getConcatNodesStringPreOder() {
        assertEquals("FBADCEGIH",concatNodesDfsService.getConcatNodesStringPreOder(binaryTree));
    }

    @Test
    public void getConcatNodesStringInOder() {
        assertEquals("ABCDEFGHI",concatNodesDfsService.getConcatNodesStringInOder(binaryTree));
    }

    @Test
    public void getConcatNodesStringPostOder() {
        assertEquals("ACEDBHIGF",concatNodesDfsService.getConcatNodesStringPostOder(binaryTree));
    }
}