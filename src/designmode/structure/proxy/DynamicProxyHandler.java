package designmode.structure.proxy;

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
        System.out.println(MessageFormat.format("{0}执行方法前：{1}",method.getDeclaringClass().getName(),method.getName()));
        Object result = method.invoke(proxiedObject, args);
        System.out.println(MessageFormat.format("{0}执行方法后：{1} 执行结果：{2}",method.getDeclaringClass().getName(),method.getName(),result));
        // after: do something
        return result;
    }
}
