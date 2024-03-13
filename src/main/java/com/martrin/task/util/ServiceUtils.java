package com.martrin.task.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;


public final class ServiceUtils {
    private ServiceUtils() {
    }

    public static <T> T validarArgumento(T argumento, String message) throws ApplicationException.IllegalArgument {
        if (argumento == null) {
            throw new ApplicationException.IllegalArgument(message);
        } else {
            return argumento;
        }
    }

    public static void validarArgumento(boolean expression, String message) throws ApplicationException.IllegalArgument {
        if (!expression) {
            throw new ApplicationException.IllegalArgument(message);
        }
    }

    public static <T> T validarEncontrado(T object, String message) throws ApplicationException.NotFound {
        if (object == null) {
            throw new ApplicationException.NotFound(message);
        } else if (object instanceof Collection && ((Collection)object).isEmpty()) {
            throw new ApplicationException.NotFound(message);
        } else {
            return object;
        }
    }

    public static <T> T validarUnico(List<T> list, String message) throws ApplicationException.NonUniqueResult {
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                throw new ApplicationException.NonUniqueResult(message);
            } else {
                return list.get(0);
            }
        } else {
            return null;
        }
    }

    public static <K, V> V validarKeyInMap(Map map, K key, Class<V> tipoDato, String mensajeError) throws ApplicationException.IllegalArgument {
        if (map.containsKey(key) && tipoDato.isInstance(map.get(key))) {
            return (V) map.get(key);
        } else {
            throw new ApplicationException.IllegalArgument(mensajeError);
        }
    }

    public static Date validarFecha(String format, String date, String errMsg) throws ApplicationException.IllegalArgument {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setLenient(false);
        Date parsedDate = null;

        try {
            parsedDate = formatter.parse(date);
            if (!date.equals(formatter.format(parsedDate))) {
                throw new ApplicationException.IllegalArgument(errMsg);
            } else {
                return parsedDate;
            }
        } catch (ParseException var6) {
            throw new ApplicationException.IllegalArgument(errMsg);
        }
    }
}
