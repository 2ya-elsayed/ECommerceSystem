package service;

import model.base.Shippable;

import java.util.List;

public interface ShippingService {
    void ship(List<Shippable> items);
}