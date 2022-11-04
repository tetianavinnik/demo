import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ucu.edu.apps.demo.delivery.DHLDeliveryStrategy;
import ua.ucu.edu.apps.demo.delivery.Delivery;
import ua.ucu.edu.apps.demo.delivery.PostDeliveryStrategy;
import ua.ucu.edu.apps.demo.flower.Flower;
import ua.ucu.edu.apps.demo.flower.FlowerBucket;
import ua.ucu.edu.apps.demo.flower.FlowerColor;
import ua.ucu.edu.apps.demo.flower.FlowerPack;
import ua.ucu.edu.apps.demo.order.Order;
import ua.ucu.edu.apps.demo.payment.CreditCardPaymentStrategy;
import ua.ucu.edu.apps.demo.payment.Payment;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryTest {
    private Delivery firstDelivery;
    private Delivery secondDelivery;
    private Order firstOrder;
    private Order secondOrder;

    @BeforeEach
    public void init() {
        firstDelivery =  new DHLDeliveryStrategy();
        secondDelivery = new PostDeliveryStrategy();
        Flower item = new Flower(12.5, FlowerColor.RED, 12);
        FlowerBucket flowerBucket = new FlowerBucket();
        FlowerPack flowerPack = new FlowerPack(item, 12);
        flowerBucket.add(flowerPack);
        flowerBucket.add(flowerPack);
        Payment payment = new CreditCardPaymentStrategy("James", "");
        firstOrder = new Order(payment, firstDelivery);
        secondOrder = new Order(payment, secondDelivery);
        firstOrder.addItem(flowerBucket);
        secondOrder.addItem(flowerBucket);
    }

    @Test
    public void testPrice() {
        assertEquals("Your order: " + firstDelivery.getOrderNumber()
                + " will be delivered by DHL",
                firstDelivery.deliver(firstOrder.getItems()));
        assertEquals("Your order: " + secondDelivery.getOrderNumber()
                + " will be delivered by post",
                secondDelivery.deliver(secondOrder.getItems()));
    }
}