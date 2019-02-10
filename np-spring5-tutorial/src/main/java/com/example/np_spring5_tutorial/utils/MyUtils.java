package com.example.np_spring5_tutorial.utils;

import java.util.Objects;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class MyUtils {
    
private static MessageSource messageSource;

public MyUtils(MessageSource messageSource) {
   
    MyUtils.messageSource = messageSource;
} 

public static String getMessage(String msgCode, Objects... args) {
    
    return messageSource.getMessage(msgCode, args, LocaleContextHolder.getLocale());
}

public static String getMessage(String msgCode) {
    
    return getMessage(msgCode, (Objects) null);
}

public static void flashMessage (RedirectAttributes redirectAtt, String flashType, String flashMsgCode) {
    
	redirectAtt.addFlashAttribute("flash", getMessage(flashMsgCode));
	redirectAtt.addFlashAttribute("flashType", flashType);
    
}


   

}
