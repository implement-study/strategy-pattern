package tech.insight.controller;


import java.util.function.IntPredicate;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public enum UserType {

    NORMAL(recharge -> recharge > 0 && recharge <= 100),
    SMALL(recharge -> recharge > 100 && recharge <= 1000),
    BIG(recharge -> recharge > 1000 && recharge <= 10000),
    SUPER(recharge -> recharge > 10000 && recharge <= 100000),
    PERSONAL(recharge -> recharge > 100000);

    private final IntPredicate support;

    UserType(IntPredicate support) {
        this.support = support;
    }

    public static UserType typeOf(int recharge) {
        for (UserType value : values()) {
            if (value.support.test(recharge)) {
                return value;
            }
        }
        return null;
    }
}
