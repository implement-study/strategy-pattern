package tech.insight.controller;

import org.springframework.stereotype.Component;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Component
public class DefaultCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        return "找不到客服";
    }
}
