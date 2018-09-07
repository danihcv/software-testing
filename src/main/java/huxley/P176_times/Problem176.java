package huxley.P176_times;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem176 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), t = scan.nextInt();
        scan.nextLine();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String name = line.split(" ")[0];
            int skill = Integer.parseInt(line.split(" ")[1]);
            players.add(new Player(skill, name));
        }
        players.sort(Player::compareTo);

        ArrayList<ArrayList<String>> teams = new ArrayList<>();
        for (int i = 1; i <= t; i++) {
            teams.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            teams.get((i - 1) % t).add(players.get(n - i).name);
        }

        for (int i = 0; i < t; i++) {
            if (i > 0) {
                System.out.println();
            }
            System.out.printf("Time %d%s", i + 1, System.lineSeparator());
            teams.get(i).sort(String::compareTo);
            for (String player : teams.get(i)) {
                System.out.println(player);
            }
        }
    }

    static class Player {
        Integer skill;
        String name;

        Player(int skill, String name) {
            this.skill = skill;
            this.name = name;
        }

        int compareTo(Player other) {
            return this.skill.compareTo(other.skill);
        }
    }
}
