package es.jlmartin;

import java.text.MessageFormat;
import java.util.Random;

public class Utils {

    public static String generateRandom4DigitsCode(){
        //Random random = ;
        return String.format("%04d", new Random().nextInt(10000));
    }

    public static String getTemplateMessageFormatted(String template, String... params){
        return MessageFormat.format(template, params);
    }

}
