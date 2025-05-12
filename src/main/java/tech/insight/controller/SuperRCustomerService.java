package tech.insight.controller;

import org.springframework.stereotype.Component;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Component
@SupportUserType(UserType.SUPER)
public class SuperRCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        System.out.println("超R玩家客服");
        return "超R玩家客服";
    }
}
