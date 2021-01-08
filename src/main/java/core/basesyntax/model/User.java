package core.basesyntax.model;

import java.util.List;

public class User {

    private String name;
    private List<Bet> bets;

    public User(String name, List<Bet> bets) {
        this.name = name;
        this.bets = bets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", bets=" + bets
                + '}';
    }
}
