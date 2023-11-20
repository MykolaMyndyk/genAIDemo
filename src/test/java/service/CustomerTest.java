package service;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private OrderLine orderLine1;
    private OrderLine orderLine2;

    @Before
    public void setUp() {
        List<OrderLine> orderLines = new ArrayList<>();
        orderLine1 = new OrderLine();
        orderLine1.setName("Product1");
        orderLine1.setCode("Code1");
        orderLine1.setQuantity(1);
        orderLine1.setPrice(100);

        orderLine2 = new OrderLine();
        orderLine2.setName("Product2");
        orderLine2.setCode("Code2");
        orderLine2.setQuantity(2);
        orderLine2.setPrice(200);

        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        customer = new Customer(orderLines);
    }

    @Test
    public void testAddProduct_NewProduct() {
        OrderLine newOrderLine = new OrderLine();
        newOrderLine.setName("Product3");
        newOrderLine.setCode("Code3");
        newOrderLine.setQuantity(1);
        newOrderLine.setPrice(300);

        customer.addProduct(newOrderLine);
        assertEquals(3, customer.getCount());
    }

    @Test
    public void testAddProduct_ExistingProduct() {
        OrderLine existingOrderLine = new OrderLine();
        existingOrderLine.setName("Product1");
        existingOrderLine.setCode("Code1");

        customer.addProduct(existingOrderLine);
        assertEquals(2, orderLine1.getQuantity());
    }

    @Test
    public void testCalculateSum_AllProducts() {
        int sum = customer.calculateSum("");
        assertEquals(500, sum);
    }

    @Test
    public void testCalculateSum_ExcludeOneProduct() {
        int sum = customer.calculateSum("Product1");
        assertEquals(400, sum);
    }

//    @Test
//    public void testCalculateSum_ExcludeAllProducts() {
//        int sum = customer.calculateSum("Product1");
//        sum += customer.calculateSum("Product2");
//        assertEquals(0, sum);
//    }
}