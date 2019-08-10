import by.zapolski.week01.task3.Customer;
import by.zapolski.week01.task3.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    private Shop shop;
    private List<Customer> customerList;

    @Before
    public void before(){
        customerList = new ArrayList<>();
        customerList.add(new Customer(1));
        customerList.add(new Customer(2));
        customerList.add(new Customer(7));
        customerList.add(new Customer(3));

        shop = new Shop(customerList,2);
    }

    @Test
    public void getTimeForPrecessQueueTest() throws InterruptedException {
        Assert.assertEquals(8,shop.getTimeForProcessQueue());
    }
}
