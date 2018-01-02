package soot.rtlib.tamiflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SilentHandler implements IUnexpectedReflectiveCallHandler {
  @Override
  public void methodInvoke(Object receiver, Method m) {}

  @Override
  public void constructorNewInstance(Constructor<?> c) {}

  @Override
  public void classNewInstance(Class<?> c) {}

  @Override
  public void classForName(String typeName) {}

  @Override
  public void fieldSet(Object receiver, Field f) {}

  @Override
  public void fieldGet(Object receiver, Field f) {}
}
