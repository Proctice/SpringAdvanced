package com.itheima;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @program: spring_advanced
 * @description: $Proxy0 原始类
 * @author: lance
 * @create: 2022-05-02 00:10
 */
public class $Proxy0 extends Proxy implements  Foo {


	protected $Proxy0(InvocationHandler h) {
		super(h);
	}

	@Override
	public void foo() {
		try {
			this.h.invoke(this, foo,null);
		} catch (Throwable e) {
			throw new UndeclaredThrowableException(e);
		}
	}


	static Method foo;
	static {
		try {
			foo = Foo.class.getMethod("foo");
		} catch (NoSuchMethodException e) {
			throw new NoSuchMethodError();
		}
	}
}
