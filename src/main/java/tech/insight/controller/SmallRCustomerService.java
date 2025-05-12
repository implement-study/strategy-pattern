package tech.insight.controller;

import org.springframework.stereotype.Component;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Component
@SupportUserType(UserType.SMALL)
public class SmallRCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        System.out.println("小R玩家客服");
        return "小R玩家客服";
    }
}
