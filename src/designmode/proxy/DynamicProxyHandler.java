package designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;

public class DynamicProxyHandler implements InvocationHandler {

    private Object proxiedObject;

    public DynamicProxyHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // before: do something
        System.out.println(MessageFormat.format("执行方法：{0}",method.getName()));
        Object result = method.invoke(proxiedObject, args);
        // after: do something
        return result;
    }
}
