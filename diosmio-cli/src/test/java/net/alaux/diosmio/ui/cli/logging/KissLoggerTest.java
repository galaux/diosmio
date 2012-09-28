package net.alaux.diosmio.ui.cli.logging;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

import net.alaux.diosmio.cli.KissLogger;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: miguel Date: 8/25/12 Time: 9:21 PM To
 * change this template use File | Settings | File Templates.
 */
public class KissLoggerTest {

    private class DateFormatMock extends DateFormat {

	@Override
	public StringBuffer format(Date date, StringBuffer stringBuffer,
		FieldPosition fieldPosition) {
	    return new StringBuffer("[DATE]");
	}

	@Override
	public Date parse(String s, ParsePosition parsePosition) {
	    throw new NotImplementedException();
	}
    }

    @Test
    public void testSwitchPrintStream() {

	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	KissLogger logger = new KissLogger(KissLogger.Level.INFO);

	logger.setDateFormat(new DateFormatMock());

	logger.error("ERROR");
	logger.error("ERROR");
	logger.debug("DEBUG");
	logger.warn("WARN");

	logger.setLevel(KissLogger.Level.SHUT_UP);

	logger.error("ERROR");

	logger.switchDestination(out);

	Assert.assertEquals("[DATE] ERROR - ERROR\n" + "[DATE] ERROR - ERROR\n"
		+ "[DATE] WARNING - WARN\n", os.toString());
    }

    @Test
    public void testLevelDebug() {

	KissLogger logger = new KissLogger(KissLogger.Level.DEBUG);
	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	logger.setDateFormat(new DateFormatMock());

	logger.error("error");
	logger.warn("warn");
	logger.info("info");
	logger.debug("debug");

	logger.switchDestination(out);

	Assert.assertEquals("[DATE] ERROR - error\n"
		+ "[DATE] WARNING - warn\n" + "[DATE] INFO - info\n"
		+ "[DATE] DEBUG - debug\n", os.toString());
    }

    @Test
    public void testLevelInfo() {

	KissLogger logger = new KissLogger(KissLogger.Level.INFO);
	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	logger.setDateFormat(new DateFormatMock());

	logger.error("error");
	logger.warn("warn");
	logger.info("info");
	logger.debug("debug");

	logger.switchDestination(out);

	Assert.assertEquals("[DATE] ERROR - error\n"
		+ "[DATE] WARNING - warn\n" + "[DATE] INFO - info\n",
		os.toString());
    }

    @Test
    public void testLevelWarning() {

	KissLogger logger = new KissLogger(KissLogger.Level.WARNING);
	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	logger.setDateFormat(new DateFormatMock());

	logger.error("error");
	logger.warn("warn");
	logger.info("info");
	logger.debug("debug");

	logger.switchDestination(out);

	Assert.assertEquals("[DATE] ERROR - error\n"
		+ "[DATE] WARNING - warn\n", os.toString());
    }

    @Test
    public void testLevelError() {

	KissLogger logger = new KissLogger(KissLogger.Level.ERROR);
	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	logger.setDateFormat(new DateFormatMock());

	logger.error("error");
	logger.warn("warn");
	logger.info("info");
	logger.debug("debug");

	logger.switchDestination(out);

	Assert.assertEquals("[DATE] ERROR - error\n", os.toString());
    }

    @Test
    public void testLevelShutUp() {

	KissLogger logger = new KissLogger(KissLogger.Level.SHUT_UP);
	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	logger.setDateFormat(new DateFormatMock());

	logger.error("error");
	logger.warn("warn");
	logger.info("info");
	logger.debug("debug");

	logger.switchDestination(out);

	Assert.assertEquals("", os.toString());
    }

    @Test
    public void testLogException() {

	KissLogger logger = new KissLogger(KissLogger.Level.SHUT_UP);
	OutputStream os = new ByteArrayOutputStream();
	PrintStream out = new PrintStream(os);

	logger.setDateFormat(new DateFormatMock());

	logger.logException(new NullPointerException("Message"));

	logger.switchDestination(out);

	Assert.assertEquals(
		"java.lang.NullPointerException: Message\n"
			+ "\tat net.alaux.diosmio.ui.cli.logging.KissLoggerTest.testLogException(KissLoggerTest.java:179)\n"
			+ "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"
			+ "\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)\n"
			+ "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"
			+ "\tat java.lang.reflect.Method.invoke(Method.java:601)\n"
			+ "\tat org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)\n"
			+ "\tat org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)\n"
			+ "\tat org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)\n"
			+ "\tat org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)\n"
			+ "\tat org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)\n"
			+ "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)\n"
			+ "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)\n"
			+ "\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)\n"
			+ "\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)\n"
			+ "\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)\n"
			+ "\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)\n"
			+ "\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)\n"
			+ "\tat org.junit.runners.ParentRunner.run(ParentRunner.java:300)\n"
			+ "\tat org.junit.runner.JUnitCore.run(JUnitCore.java:157)\n"
			+ "\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:76)\n"
			+ "\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:195)\n"
			+ "\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:63)\n"
			+ "\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"
			+ "\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)\n"
			+ "\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"
			+ "\tat java.lang.reflect.Method.invoke(Method.java:601)\n"
			+ "\tat com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)\n",
		os.toString());
    }

    public void testEnumLevelGetLevel() {
	Assert.assertEquals(KissLogger.Level.ERROR,
		KissLogger.Level.getLevel("ERROR"));
    }

}
