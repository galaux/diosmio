package net.alaux.diosmio.core;

import java.io.File;

public class SayHelloService implements ISaySomethingService {

	@Override
	public String saySomething(String name, String otherName, File file) {
		String str = "Hello " + name + " and " + otherName + " "
				+ file.getAbsolutePath();
		System.out.println(str);
		return str;
	}

}
