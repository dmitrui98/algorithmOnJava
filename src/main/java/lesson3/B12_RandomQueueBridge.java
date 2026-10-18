package lesson3;

import common.data.structure.queue.RandomQueue;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Упражнение
 * 1.3.35 - реализация RandomQueue, раздача карт в игре бридж
 * 1.3.36 - случайный итератор
 */
public class B12_RandomQueueBridge {
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static void main(String[] args) {
        new B12_RandomQueueBridge().go();
    }

    private void go() {
        RandomQueue<Card> cards = new RandomQueue<>();
        for (Suit suit : Suit.values()) {
            for (String rank : RANKS) {
                cards.enqueue(new Card(suit, rank));
            }
        }
        ArrayUtil.print(cards);
        StdOut.println("Cards size: " + cards.size());
        StdOut.println("Random sample: " + cards.sample());
        StdOut.println("Random sample: " + cards.sample());
        List<Card>[] players = new ArrayList[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new ArrayList<>();
        }
        for (int i = 0; !cards.isEmpty(); i++) {
            int playerIndex = i % players.length;
            players[playerIndex].add(cards.dequeue());
        }
        for (List<Card> player : players) {
            ArrayUtil.print(player);
        }
    }

    private static class Card {
        private Suit suit;
        private String rank;

        public Card(Suit suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return suit + rank;
        }
    }

    private enum Suit {
        CLUBS("♣"),
        DIAMONDS("♦"),
        HEARTS("♥"),
        SPADES("♠"),
        ;

        Suit(String value) {
            this.value = value;
        }

        private String value;

        @Override
        public String toString() {
            return value;
        }
    }
}
