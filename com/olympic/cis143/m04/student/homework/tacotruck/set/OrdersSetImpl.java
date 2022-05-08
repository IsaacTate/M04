package com.olympic.cis143.m04.student.tacotruck.set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

import java.util.HashSet;
import java.util.Set;

public class OrdersSetImpl  implements Orders {

    private Set<TacoImpl> orderSet = new HashSet<>();
    @Override
    public void addOrder(TacoImpl tacoOrder) {orderSet.add(tacoOrder);}

    @Override
    public boolean hasNext() {return orderSet.size() !=0;}

    @Override
    public TacoImpl closeNextOrder() {
        TacoImpl taco = orderSet.iterator().next();
        orderSet.remove(taco);
        return taco;
    }

    @Override
    public int howManyOrders() {
        return orderSet.size();
    }
}
