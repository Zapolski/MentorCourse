import by.zapolski.week01.task2.Clerk;
import by.zapolski.week01.task2.Customer;
import by.zapolski.week01.task2.NominalBancnoteType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClerkTest {

    private Clerk clerk;
    private List<Customer> queue;

    @Before
    public void before(){
        clerk = new Clerk();

        queue = new ArrayList<>();
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.FIFTY));
        queue.add(new Customer(NominalBancnoteType.FIFTY));
        queue.add(new Customer(NominalBancnoteType.FIFTY));
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.HUNDRED));
        queue.add(new Customer(NominalBancnoteType.TWENTY_FIFE));
        queue.add(new Customer(NominalBancnoteType.FIFTY));
    }

    @Test
    public void clerkProcessQueueTest(){
        Assert.assertTrue(clerk.processQueue(queue));
    }
}
