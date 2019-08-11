package by.zapolski.week01;

import by.zapolski.week01.task4.MergeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MergeServiceTest {

    private List<Integer> listA;
    private List<Integer> listB;
    private List<Integer> listC;
    private List<Integer> listD;
    private List<Integer> resultTwoLists, resultManyLists;

    @Before
    public void before(){
        listA = Arrays.asList(1,5,6);
        listB = Arrays.asList(2,6,8);
        listC = Arrays.asList(-9,0,4);
        listD = Arrays.asList(-7,5,11);

        resultTwoLists = Arrays.asList(1,2,5,6,6,8);
        resultManyLists = Arrays.asList(-9,-7,0,1,2,4,5,5,6,6,8,11);
    }

    @Test
    public void mergeTwoLists(){
        Assert.assertEquals(resultTwoLists,MergeService.mergeTwoLists(listA,listB));
    }

    @Test
    public void mergeManyLists(){
        Assert.assertEquals(resultManyLists,MergeService.mergeManyLists(listA,listB,listC,listD));
    }
}
