package net.alaux.diosmio.ui.cli.logging;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple logger for Java
 *
 * This very simple logger tries to "Keep It Simple Stupid" while also trying to bring some nice features such as:
 *
 *   - runtime customizable output format
 *      Just use kissLogger.setDateFormat(customDateFormat);
 *
 *   - runtime log level changing
 *      Just use kissLogger.setLevel(newLevel);
 *
 *   - logging to temporary buffer (useful on these part of an application where you do not know YET where you will log)
 *      Just instantiate a logger with no PrintStream
 *        KissLogger logger = new KissLogger(Level.INFO);
 *      Then after you parsed you CLI arguments or config file:
 *        logger.switchDestination(logFilePrintStream);
 *
 *      Temporary logs will then be written to the new PrintStream
 *
 * @Author: Guillaume ALAUX <guillaume at alaux dot net>
 */
public class KissLogger {

    public enum Level {
        SHUT_UP(-1), ERROR(0), WARNING(1), INFO(2), DEBUG(3);

        private int value;

        Level(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Level getLevel(String str) {
            if (str != null) {
                for (KissLogger.Level l : KissLogger.Level.values()) {
                    if (l.name().compareTo(str) == 0) {
                        return l;
                    }
                }
            }
            return null;
        }
    }


//    private static final KissLogger instance = new KissLogger(Level.ERROR);
//
//    public static KissLogger getInstance() {
//        return instance;
//    }

    /** Temporary OutputStream to hold data while definitive destination is not yet known */
    private ByteArrayOutputStream tempOutputStream = null;
    /** PrintStream to which logs are written */
    private PrintStream printStream = null;

    /** DateFormat used to display log lines */
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /** LogLevel at which this logger should print */
    private Level level;


    // Constructors

    /**
     * Constructs a logger that logs to a temporary OutputStream.
     *
     * The content of this temporary OutputStream is then written to a new one when using switchDestination()
     *
     * @param level     level at which print
     */
    public KissLogger(Level level) {
        this.tempOutputStream = new ByteArrayOutputStream();
        this.printStream = new PrintStream(tempOutputStream);
        this.level = level;
    }

    /**
     * Constructs a logger that logs to a a PrintStream
     *
     * @param stream    the PrintStream to which log
     * @param level     level at which print
     */
    public KissLogger(PrintStream stream, Level level) {
        this.printStream = stream;
        this.level = level;
    }


    // Getters and setters

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }


    // Loging methods

    /**
     * Logs the stack trace of an Exception
     *
     * @param e    the exception that owns the stack trace to print
     */
    public void logException(Exception e) {
        error("The following exception was thrown:");
        e.printStackTrace(this.printStream);
    }

    public void error(String mess) {
        printAtLevel(mess, Level.ERROR);
    }

    public void warn(String mess) {
        printAtLevel(mess, Level.WARNING);
    }

    public void info(String mess) {
        printAtLevel(mess, Level.INFO);
    }

    public void debug(String mess) {
        printAtLevel(mess, Level.DEBUG);
    }

    /**
     * Print an message at the specified level
     *
     * @param mess  the message to print
     * @param l     the level at which the message should be printed
     */
    public void printAtLevel(String mess, Level l) {
        if (l.getValue() <= level.getValue()) {
            printStream.println(dateFormat.format(new Date()) + " " + l.name() + " - " + mess);
        }
    }


    // Other methods

    /**
     * Switch the destination of the log
     *
     * @param destination   new destination to which log output will be written
     * @return              whether switch was successful (depends on the destination stream being OK)
     */
    public boolean switchDestination(PrintStream destination) {

        // First, check the future PrintStream & Al. are OK
        if (destination == null || destination.checkError()) {
            return false;
        }

        // OK then, let's write data held in the temporary stream to the new one
        if (tempOutputStream != null) {
            destination.print(tempOutputStream.toString());
        }

        // Finally, let's make the switch
        this.printStream = destination;
        return true;
    }

    /**
     * Close the print stream
     */
    public void close() {
        printStream.close();
    }
}
