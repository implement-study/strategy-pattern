package tech.insight.controller;

import org.springframework.stereotype.Component;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Component
@SupportUserType(UserType.NORMAL)
public class NormalCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        System.out.println("普通玩家客服");
        return "普通玩家客服";
    }
}
