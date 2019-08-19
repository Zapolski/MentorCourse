package by.zapolski.week02;

import by.zapolski.week02.task1.BracketService;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketServiceTest {

    BracketService bracketService = new BracketService();

    @Test
    public void checkStringWithBrackets01_correct(){
        String source = "()";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets02_correct(){
        String source = "(){}[]";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets03_correct(){
        String source = "{[]}";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets04_incorrect(){
        String source = "([)]";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets05_incorrect(){
        String source = "(]";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithBrackets06_incorrect(){
        String source = "(({{[[()";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringWithEmptyString_correct(){
        String source = "";
        assertTrue(bracketService.checkStringWithBrackets(source));
    }

    @Test
    public void checkStringStartWithClosingBracket_incorrect(){
        String source = ")(){}[()]";
        assertFalse(bracketService.checkStringWithBrackets(source));
    }
}
