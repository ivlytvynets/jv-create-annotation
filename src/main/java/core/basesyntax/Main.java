package core.basesyntax;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.factory.Factory;
import core.basesyntax.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        handler.handle();

        BetDao betDao = Factory.getBetDao();
        System.out.println("all bets: " + betDao.getAll());
    }
}
