package net.alaux.diosmio.ui.cli.logging;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/9/12
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
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


    private ByteArrayOutputStream tempOutputStream = null;
    private PrintStream printStream = null;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Level level;

    // Constructors
    public KissLogger(Level level) {
        this.tempOutputStream = new ByteArrayOutputStream();
        this.printStream = new PrintStream(tempOutputStream);
        this.level = level;
    }

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
    public void error(Exception e) {
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

    public void printAtLevel(String mess, Level l) {
        if (l.getValue() <= level.getValue()) {
            printStream.println(dateFormat.format(new Date()) + " " + l.name() + " - " + mess);
        }
    }

    // Other methods
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

    public void close() {
        printStream.close();
    }
}
