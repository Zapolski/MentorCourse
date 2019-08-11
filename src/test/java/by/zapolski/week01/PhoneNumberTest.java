package by.zapolski.week01;

import by.zapolski.week01.task1.PhoneNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumberTest {

    private List<Integer> numbers;
    private String expectedPhone;

    @Before
    public void before(){
        numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        expectedPhone = "(123) 456-7890";
    }

    @Test
    public void getPhoneNumberFromListWithoutRegExpTest(){
        String actual = PhoneNumber.getPhoneNumberFromListWithoutRegExp(numbers);
        Assert.assertEquals(expectedPhone,actual);
    }

    @Test
    public void getPhoneNumberFromListWithRegExpTest(){
        String actual = PhoneNumber.getPhoneNumberFromListWithRegExp(numbers);
        Assert.assertEquals(expectedPhone,actual);
    }
}
