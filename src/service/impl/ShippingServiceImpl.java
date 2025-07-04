package service.impl;

import base.Shippable;
import service.ShippingService;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {

    @Override
    public void ship(List<Shippable> items) {
        System.out.println("** Shipment Notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + "kg)");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight + "kg\n");
    }
}
