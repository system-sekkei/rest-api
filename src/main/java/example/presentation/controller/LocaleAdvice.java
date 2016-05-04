package example.presentation.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@ControllerAdvice
public class LocaleAdvice {

    @ModelAttribute("lang")
    public void setLang(@RequestParam(value = "lang",defaultValue = "ja") String lang ) {
        Locale locale = new Locale(lang);
        LocaleContextHolder.setLocale(locale);
    }
}
