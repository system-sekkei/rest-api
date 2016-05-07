package example.infrastructure.configuration.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class MessageResolver {

    public static MessageSource messageSource;

    public static void setMessageSource(MessageSource source) {
        messageSource = source;
    }

    public static String of(String key, Object... args) {
        return messageSource.getMessage(key, args , LocaleContextHolder.getLocale());
    }
}