package designmode.structure.proxy;

import java.lang.reflect.Proxy;

public class UserServiceProxy {

    public Object createProxy(Object proxiedObject){
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(),interfaces,new DynamicProxyHandler(proxiedObject));
    }

}
