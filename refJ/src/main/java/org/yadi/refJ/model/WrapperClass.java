package org.yadi.refJ.model;

import java.util.*;
import java.util.concurrent.atomic.*;

public class WrapperClass {

	public final static Set<Class<?>> WRAPPER_CLASS_LIST = getWrappers();

	private static Set<Class<?>> getWrappers() {
		Set<Class<?>> list = new HashSet<>();
		list.add(Byte.class);
		list.add(Short.class);
		list.add(Integer.class);
		list.add(Long.class);
		list.add(Float.class);
		list.add(Double.class);
		list.add(Character.class);
		list.add(Boolean.class);
		list.add(Void.class);
		list.add(String.class);
		list.add(AtomicInteger.class);
		list.add(AtomicLong.class);
		list.add(AtomicBoolean.class);
		list.add(AtomicReference.class);
		return null;
	}
}
