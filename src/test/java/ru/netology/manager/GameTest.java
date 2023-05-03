package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {
    Game tournament = new Game();
    Player player1 = new Player(1, "player1", 2);
    Player player2 = new Player(2, "player2", 4);
    Player player3 = new Player(3, "player3", 4);

    @BeforeEach
    public void add() {
        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);
    }

    @Test
    public void shouldPlayDraw() {

        int actual = tournament.round("player2", "player3");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldWinFirstPlayer() {

        int actual = tournament.round("player3", "player1");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldWinSecondPlayer() {

        int actual = tournament.round("player1", "player2");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldMsgForNotRegisteredFirstPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                tournament.round("player5", "player3")
        );
    }

    @Test
    public void shouldMsgForNotRegisteredSecondPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                tournament.round("player1", "player5")
        );
    }
}