package tech.insight.controller;

import org.springframework.stereotype.Component;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Component
@SupportUserType(UserType.BIG)
public class BigRCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        System.out.println("大R玩家客服");
        return "大R玩家客服";
    }
}
