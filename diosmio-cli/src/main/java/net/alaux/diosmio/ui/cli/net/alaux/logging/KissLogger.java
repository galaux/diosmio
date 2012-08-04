package net.alaux.diosmio.ui.cli.net.alaux.logging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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

    private FileOutputStream fos = null;
    private PrintStream out = System.out;

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
    }

    private Level level;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public KissLogger(Level level) {
        this.level = level;
    }

    public KissLogger(Level level, String logPath) {
        this.level = level;
        try {
            fos = new FileOutputStream(logPath, true);
            out = new PrintStream(fos);
            // FIXME See how to close this
        } catch (FileNotFoundException e) {
            // Nothing to do. Let's fall back to default
        }
    }

    public void close() {

        info("----------------------");
        if (fos != null) {
            try {
                out.flush();
                out.close();
                fos.flush();
                fos.close();
            } catch (IOException e) {
                // Nothing to do
            }
        }
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
            out.println(dateFormat.format(new Date()) + " " + l.name() + " - " + mess);
        }
    }
}
