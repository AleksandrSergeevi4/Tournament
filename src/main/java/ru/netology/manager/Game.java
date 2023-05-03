package ru.netology.manager;

import ru.netology.NotRegisteredException;
import ru.netology.Player;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public void register(String playerName, Player player) {
        players.put(playerName, player);
    }

    public Player findByPlayerName(String key) {
        return players.get(key);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByPlayerName(playerName1);
        Player player2 = findByPlayerName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
