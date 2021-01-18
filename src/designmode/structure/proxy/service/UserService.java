package designmode.structure.proxy.service;

public class UserService implements IUserService,IUserService1,IUserService2 {

    @Override
    public String getUserName(){
        return "zhangsan";
    }

    @Override
    public int getAge(){
        return 23;
    }

    @Override
    public String getAddress(){
        return "北京市海淀区";
    }

    @Override
    public String getIDCard() {
        return "410426199952325625";
    }
}
