package net.alaux.diosmio.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class DiosMioUtils {

    public static void copyFile(File sourceFile, File destFile)
	    throws IOException {
	if (!destFile.exists()) {
	    destFile.createNewFile();
	}

	FileChannel source = null;
	FileChannel destination = null;
	try {
	    source = new FileInputStream(sourceFile).getChannel();
	    destination = new FileOutputStream(destFile).getChannel();

	    long count = 0;
	    long size = source.size();
	    while ((count += destination.transferFrom(source, count, size
		    - count)) < size)
		;
	} finally {
	    if (source != null) {
		source.close();
	    }
	    if (destination != null) {
		destination.close();
	    }
	}
    }
}
