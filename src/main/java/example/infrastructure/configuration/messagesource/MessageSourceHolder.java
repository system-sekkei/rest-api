package example.infrastructure.configuration.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component()
public class MessageSourceHolder {

    @Autowired
    MessageSource messageSource;

    @PostConstruct
    public void setMessageSource() {
        MessageResolver.setMessageSource(messageSource);
    }

}