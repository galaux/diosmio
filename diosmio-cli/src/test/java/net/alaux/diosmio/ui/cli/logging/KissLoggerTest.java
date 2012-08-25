package net.alaux.diosmio.ui.cli.logging;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/25/12
 * Time: 9:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class KissLoggerTest {

    @Test
    public void testSwitchPrintStream() {

        KissLogger logger = new KissLogger(KissLogger.Level.INFO);
        logger.error("This should be displayed!");
        logger.error("That also");
        logger.debug("But not this");
        logger.warn("That yes");



        logger.setLevel(KissLogger.Level.SHUT_UP);

        logger.error("GHJKHJ");

        logger.switchDestination(System.out);
    }
}
