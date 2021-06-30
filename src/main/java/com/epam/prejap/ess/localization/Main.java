package com.epam.prejap.ess.localization;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.epam.prejap.ess.localization.Main.Translation.FAREWELL;
import static com.epam.prejap.ess.localization.Main.Translation.GREETING;

/**
 * RB showcase.
 *
 * @author Marcin Ogorzałek
 */
class Main {

    enum Translation {
        GREETING,
        FAREWELL
    }

    public static void main(String[] args) {
        var locale = Locale.getDefault();

        locale = getLocale(args, locale);

        var rb = ResourceBundle.getBundle("MyResource", locale);

        System.out.println(rb.getString(GREETING.name()));
        System.out.println(rb.getString(FAREWELL.name()));
    }

    private static Locale getLocale(String[] args, Locale locale) {
        if(args.length > 0) {
            if(args.length == 1) {
                locale = new Locale(args[0]);
            } else {
                locale = new Locale(args[0], args[1]);
            }
        }
        return locale;
    }
}
