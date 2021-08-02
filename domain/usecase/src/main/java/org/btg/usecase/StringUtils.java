package org.btg.usecase;

public class StringUtils {
    public static boolean esVacio(String... strings) {
        boolean vacio = false;
        for (String str : strings) {
            vacio = vacio || esVacio(str);
        }
        return vacio;
    }

    public static boolean esVacio(String value) {
        return value == null || value.isEmpty();
    }
}
