package by.zapolski.week02;

import by.zapolski.week02.task1.BracketService;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketServiceTest {

    BracketService bracketService = new BracketService();

    @Test
    public void checkStringWithBrackets01(){
        String source = "()";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets02(){
        String source = "(){}[]";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets03(){
        String source = "{[]}";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets04(){
        String source = "([)]";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets05(){
        String source = "(]";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets06(){
        String source = "(({{[[()";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }
}
