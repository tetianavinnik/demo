package ua.ucu.edu.apps.demo.flower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.ucu.edu.apps.demo.order.Item;

@Setter @AllArgsConstructor
public class Flower extends Item {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private int price;

    public String getColor() {
        return color.toString();
    }
}
