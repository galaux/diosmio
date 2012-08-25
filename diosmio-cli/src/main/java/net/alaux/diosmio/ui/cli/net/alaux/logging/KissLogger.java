package net.alaux.diosmio.ui.cli.net.alaux.logging;

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

    // TODO Handle "SHUT UP"

    private FileOutputStream fileOutputStream = null;
    private PrintStream printStream = System.out;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

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

    private Level level;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean setDestination(File destination) {

        PrintStream ps;
        FileOutputStream fos;


        try {
            fos = new FileOutputStream(destination, true);
        } catch (FileNotFoundException e) {
            return false;
        }

        ps = new PrintStream(fos);
        if (ps == null || ps.checkError()) {
            return false;
        }

        this.printStream.flush();

        this.fileOutputStream = fos;
        this.printStream = ps;
        return true;
    }

    // Constructors *****************************
    public KissLogger(Level level) {
        this.level = level;
    }
    // /Constructors *****************************

    public void close() {

        info("----------------------");
        if (fileOutputStream != null) {
            try {
                printStream.flush();
                printStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                // Nothing to do
            }
        }
    }


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
}
