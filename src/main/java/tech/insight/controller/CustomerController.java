package tech.insight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
@RestController
public class CustomerController {


    private Map<UserType, CustomerService> customerServiceMap;

    @Autowired
    private DefaultCustomerService defaultCustomerService;


    //  抽象逻辑
    //  要实现具体的逻辑策略
    //  选择一个不同的策略
    //  调用策略具体的逻辑
    @GetMapping("/customer/{recharge}")
    public String customer(@PathVariable(value = "recharge") int recharge) {
        UserType userType = UserType.typeOf(recharge);
        CustomerService customerService = customerServiceMap.getOrDefault(userType, defaultCustomerService);
        return customerService.findCustomer();
    }

    @Autowired
    public void setCustomerServiceMap(List<CustomerService> customerServiceList) {
        this.customerServiceMap =
            customerServiceList.stream()
                .filter(customerService -> customerService.getClass().isAnnotationPresent(SupportUserType.class))
                .collect(Collectors.toMap(this::findUserTypeFromService, Function.identity()));
        if (this.customerServiceMap.size() != UserType.values().length) {
            throw new IllegalArgumentException("有用户类型没有对应的策略");
        }
    }

    private UserType findUserTypeFromService(CustomerService customerService) {
        SupportUserType annotation = customerService.getClass().getAnnotation(SupportUserType.class);
        return annotation.value();
    }


}
