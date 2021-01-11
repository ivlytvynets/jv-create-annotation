package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exception.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object objectDao = new Object();
                if (field.getType() == BetDao.class) {
                    objectDao = Factory.getBetDao();
                } else if (field.getType() == UserDao.class) {
                    objectDao = Factory.getUserDao();
                }
                if (objectDao.getClass().isAnnotationPresent(Dao.class)) {
                    field.set(instance, objectDao);
                }
                else {
                    throw new AnnotationException("Annotation @Dao doesn't exist in class "
                            + objectDao.getClass());
                }
            }
        }
        return instance;
    }
}
