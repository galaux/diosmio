package net.alaux.utils;

import org.springframework.context.MessageSource;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 * Date: 8/4/12
 */
public class AppMessages {

    // Injected in applicationContext.xml to prevent it from being used elsewhere
    private MessageSource messageSource;

    private static Locale usedLocale = Locale.getDefault();

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
