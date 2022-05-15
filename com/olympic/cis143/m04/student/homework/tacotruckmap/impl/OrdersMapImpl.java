package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {

    private Map<String,List<TacoImpl>> orderHashMap = new HashMap<>();

    @Override
    public void createOrder(final String orderid) {
        orderHashMap.put(orderid,new ArrayList<>());
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
        if(orderHashMap.get(orderid)==null)
            throw new OrderDoesNotExistException(orderid);
        List<TacoImpl> tacos = orderHashMap.get(orderid);
        tacos.add(taco);
        if(orderHashMap.put(orderid,tacos)==null){
            throw new OrderDoesNotExistException(orderid);
        };
    }

    @Override
    public boolean hasNext() {
        return orderHashMap.size() !=0;
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
        if(orderHashMap.get(orderid)==null)
            throw new OrderDoesNotExistException(orderid);
        return orderHashMap.remove(orderid);
    }

    @Override
    public int howManyOrders() {
        return orderHashMap.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
        if(orderHashMap.get(orderid)==null)
            throw new OrderDoesNotExistException(orderid);
        return orderHashMap.get(orderid);
    }
}
