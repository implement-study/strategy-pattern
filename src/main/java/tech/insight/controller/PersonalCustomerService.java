package tech.insight.controller;

import org.springframework.stereotype.Component;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@Component
@SupportUserType(UserType.PERSONAL)
public class PersonalCustomerService implements CustomerService {


    @Override
    public String findCustomer() {
        return "专属客服";
    }
}
