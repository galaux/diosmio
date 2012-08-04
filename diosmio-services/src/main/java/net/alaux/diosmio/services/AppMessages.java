package net.alaux.diosmio.services;

import org.springframework.context.MessageSource;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class AppMessages {

    // Injected in applicationContext.xml to prevent it from beeing used elsewhere
    private MessageSource messageSource;

    private Locale usedLocale = Locale.getDefault();

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    public String get(String key, String... args) {
        return messageSource.getMessage(key,
                Arrays.asList(args).toArray(),
                this.usedLocale);
    }
}
