import Assets.Colors;
import Boats.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NavalBattle {
    static int option = -10;
    static String player1,player2;
    static Scanner sc = new Scanner(System.in);

    static PositionField[][] positions = new PositionField[9][9];
    static PositionField[][] positions1 = new PositionField[9][9];

    public static void start() throws InterruptedException, IOException {

        ArrayList<Boat> classic = new ArrayList<>(Arrays.asList(new SmallBoat(),new MediumBoat(),new BigBoat()));
        new BoatList(classic, Colors.CYAN+"Classic"+Colors.RESET);

        System.out.print("\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "Welcome !");
        Thread.sleep(1000);
        System.out.print(" !");
        Thread.sleep(1000);
        System.out.println(" !"+Colors.RESET);
        Thread.sleep(1000);

          // Logo.logoCinematic();
            menu();

        }


    public static void menu() throws InterruptedException, IOException {

        while (option != 0) {
           Thread.sleep(1500);
            System.out.print(
                    "\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    1-Play\n" +
                            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    0-Exit\n\n" +
                            Colors.YELLOW + "Option:" + Colors.RESET);
            option = sc.nextInt();
            switch (option) {
                case 1:
                        play();
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("AHM?!?");
            }
        }
    }

    public static void play() throws InterruptedException, IOException {
        fillBoard();
        Scanner sc = new Scanner(System.in);
        String player1;
        String player2;
        System.out.print(
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1-Player👤 VS 👤Player\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2-Player👤 VS 💻CPU\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3- ✏️Creation Mode✏️\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0-Back\n" +
                        Colors.YELLOW + "Option:" + Colors.RESET);
        option = sc.nextInt();
        switch (option) {
            case 1:
                    System.out.print(
                            "🛳️ Naval battle! 🛳\n\n" +
                                    "Insert names.\n" +
                                    "P1 name:");

                    player1 = sc.nextLine();
                    System.out.print("\nP2 name:");
                    player2 = sc.nextLine();
                    PvP.start(true, player1, player2);
                break;
            case 2:
                player1 = "Player";
                player2 = "CPU";
                PvC.start(player1, player2);
                break;
            case 3:
                    CreativeMode.start();
                break;
            case 0:
                menu();
                break;
            default:
                System.out.println("AHM?!?");
        }
    }

    public static void pvc() {
        System.out.print(
                "🛳️ Naval battle! 🛳\n\n" +
                        "Insert name.\n" +
                        "P1 name:");
        sc.nextLine();
        player1 = sc.nextLine();
        player2 = "CPU";

    }



    public static void fillBoard() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                positions[x][y] = new PositionField();
                positions[x][y] = new PositionField();
                positions1[x][y] = new PositionField();
                positions1[x][y] = new PositionField();
            }
        }
    }

    public static void printPlayer1Board(String player1) {
        System.out.println("                       " + Colors.BLUE + player1 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y\n" +
                "            ⬇️\n" +
                "        X ➡️  | 🅐 | B | C | D | E | F | G | H | I |\n");

        for (int i = 0; i < positions.length; i++) {
            System.out.print("            " + (i + 1) + " | ");
            for (int j = 0; j < positions[i].length; j++) {
                System.out.print(positions[i][j].field + "| ");
            }
            System.out.println();
        }
    }

    public static void printPlayer2Board(String player2) {
        System.out.println("                       " + Colors.RED + player2 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y\n" +
                "            ⬇️\n" +
                "        X ➡️  | 🅐 | 🅑 | 🅒 | 🅓 | 🅔 | 🅕 | 🅖 | 🅗 | 🅘 |\n");

        for (int i = 0; i < positions1.length; i++) {
            System.out.print("            " + (i + 1) + " | ");
            for (int j = 0; j < positions1[i].length; j++) {
                System.out.print(positions1[i][j].field + "| ");
            }
            System.out.println();
        }
    }
    public static void printBothBoards(String player1, String player2) {
        System.out.print("                       " + Colors.BLUE + player1 + " TERRITORY" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.RED + player2 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y                                                                                                                    Y\n" +
                "            ⬇️                                                                                                                  ⬇️\n" +
                "        X ➡️  | 𝔸 | 𝔹 | 𝔻 | 𝔻 | 𝔼 | 𝔽 | 𝔾 | 𝔻 | 𝕀 |" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "X ➡️  | 🅐 | 🅑 | 🅒 | 🅓 | 🅔 | 🅕 | 🅖 | 🅗 | 🅘 |\n");

        for (int i = 0; i < positions.length; i++) {
            System.out.print("            " + (i + 1) + " | ");
            for (int j = 0; j < positions[i].length; j++) {
                System.out.print(positions[i][j].field + " | ");
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < positions1[i].length; j++) {
                System.out.print(positions1[i][j].field + " | ");
            }
            System.out.println();
        }
    }

}


