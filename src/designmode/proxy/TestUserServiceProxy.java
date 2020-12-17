package designmode.proxy;

public class TestUserServiceProxy {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserServiceProxy proxy = new UserServiceProxy();
        Object proxy1 = proxy.createProxy(userService);

    }
}
