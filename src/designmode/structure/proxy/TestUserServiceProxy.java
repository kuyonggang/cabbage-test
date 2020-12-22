package designmode.structure.proxy;

import designmode.structure.proxy.service.IUserService;
import designmode.structure.proxy.service.IUserService1;
import designmode.structure.proxy.service.IUserService2;
import designmode.structure.proxy.service.UserService;

import java.util.Arrays;

public class TestUserServiceProxy {
    public static void main(String[] args) {
        UserServiceProxy proxy = new UserServiceProxy();

        IUserService userService = new UserService();
        userService = (IUserService) proxy.createProxy(userService);
        userService = (IUserService) proxy.createProxy(userService);
        System.out.println(userService.getAge());

        System.out.println("==========================================");
        IUserService1 userService1 = (IUserService1) proxy.createProxy(new UserService());

        IUserService2 userService2 = (IUserService2) proxy.createProxy(new UserService());
        System.out.println(userService2.getIDCard());

        Object obj = new Object();
        System.out.println(Arrays.toString(obj.getClass().getInterfaces()));
    }
}
