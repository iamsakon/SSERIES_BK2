package com.sky.el;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

import javax.el.*;

import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

public class CustomBeanELResolver extends SpringBeanFacesELResolver {
	@Override
	public Object getValue(ELContext context, Object base, Object property) {
		if (property == null || base == null || base instanceof ResourceBundle || base instanceof Map
				|| base instanceof Collection) {
			return null;
		}

		String propertyString = property.toString();

		if (propertyString.contains(".")) {
			Object value = base;
			Class[] params = new Class[] { ELContext.class, Object.class, Object.class };
			for (String propertyPart : propertyString.split("\\.")) {

				Class aClass = BeanELResolver.class;

				try {
					Method getValueMethod = aClass.getDeclaredMethod("getValue", params);
					value = getValueMethod.invoke(aClass.newInstance(), context, value, propertyPart);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return value;
		} else {
			return super.getValue(context, base, property);
		}
	}
}
