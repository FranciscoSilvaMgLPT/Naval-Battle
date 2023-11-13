import Boats.BigBoat;
import Boats.Boat;
import Boats.MediumBoat;
import Boats.SmallBoat;

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

        SmallBoat smallBoat = new SmallBoat();
        MediumBoat mediumBoat = new MediumBoat();
        BigBoat bigBoat = new BigBoat();
        ArrayList<Boat> classic = new ArrayList<>(Arrays.asList(smallBoat,mediumBoat,bigBoat));
        new BoatList(classic,Colors.CYAN+"Classic"+Colors.RESET);


        System.out.print("\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "Welcome !");
        Thread.sleep(1000);
        System.out.print(" !");
        Thread.sleep(1000);
        System.out.println(" !"+Colors.RESET);
        Thread.sleep(1000);
        try {
           // Logo.logoCinematic();
            menu();
        } catch (Exception e) {
            System.out.println("AHM?");
            sc.nextLine();
            menu();
        }
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
                    try {
                        play();
                    } catch (Exception e) {
                        System.out.println("AHM?");
                        sc.nextLine();
                        menu();
                    }
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
        System.out.print(
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1-Player👤 VS 👤Player\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2-Player👤 VS 💻CPU\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3- ✏️Creation Mode✏️\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0-Back\n" +
                        Colors.YELLOW + "Option:" + Colors.RESET);
        option = sc.nextInt();
        switch (option) {
            case 1:
                try {
                    Scanner sc = new Scanner(System.in);
                    String player1;
                    String player2;
                    System.out.print(
                            "🛳️ Naval battle! 🛳\n\n" +
                                    "Insert names.\n" +
                                    "P1 name:");

                    player1 = sc.nextLine();
                    System.out.print("\nP2 name:");
                    player2 = sc.nextLine();
                    PvP.start(true,player1,player2);

                } catch (Exception e) {
                    System.out.println("AHM?");
                    sc.nextLine();

                }
                break;
            case 2:
                try {
                    pvc();
                    PvC.start();
                } catch (Exception e) {
                    System.out.println("AHM?");
                    sc.nextLine();
                    PvC.start();
                }
                break;
            case 3:
                try {
                    CreativeMode.start();
                } catch (Exception e) {
                    System.out.println("AHM?");
                    sc.nextLine();
                    CreativeMode.start();
                }
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
                positions1[x][y] = new PositionField();
            }
        }
    }

    public static void board(String player1, String player2) {
        System.out.println("                       " + Colors.BLUE + player1 + " TERRITORY" + Colors.RESET + "                                                                                                                  " + Colors.RED + player2 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y                                                                                                                                Y        \n" +
                "            ⬇️                                                                                                                               ⬇️\n" +
                "        X ➡️  | A | B | C | D | E | F | G | H | I |                                                                                      X ➡️  | A | B | C | D | E | F | G | H | I |\n" +
                "            1 | " + positions[0][0].field + "| " + positions[0][1].field + "| " + positions[0][2].field + "| " + positions[0][3].field + "| " + positions[0][4].field + "| " + positions[0][5].field + "| " + positions[0][6].field + "| " + positions[0][7].field + "| " + positions[0][8].field + "|                                                                                          1 | " + positions1[0][0].field + "| " + positions1[0][1].field + "| " + positions1[0][2].field + "| " + positions1[0][3].field + "| " + positions1[0][4].field + "| " + positions1[0][5].field + "| " + positions1[0][6].field + "| " + positions1[0][7].field + "| " + positions1[0][8].field + "|\n" +
                "            2 | " + positions[1][0].field + "| " + positions[1][1].field + "| " + positions[1][2].field + "| " + positions[1][3].field + "| " + positions[1][4].field + "| " + positions[1][5].field + "| " + positions[1][6].field + "| " + positions[1][7].field + "| " + positions[1][8].field + "|                                                                                          2 | " + positions1[1][0].field + "| " + positions1[1][1].field + "| " + positions1[1][2].field + "| " + positions1[1][3].field + "| " + positions1[1][4].field + "| " + positions1[1][5].field + "| " + positions1[1][6].field + "| " + positions1[1][7].field + "| " + positions1[1][8].field + "|\n" +
                "            3 | " + positions[2][0].field + "| " + positions[2][1].field + "| " + positions[2][2].field + "| " + positions[2][3].field + "| " + positions[2][4].field + "| " + positions[2][5].field + "| " + positions[2][6].field + "| " + positions[2][7].field + "| " + positions[2][8].field + "|                                                                                          3 | " + positions1[2][0].field + "| " + positions1[2][1].field + "| " + positions1[2][2].field + "| " + positions1[2][3].field + "| " + positions1[2][4].field + "| " + positions1[2][5].field + "| " + positions1[2][6].field + "| " + positions1[2][7].field + "| " + positions1[2][8].field + "|\n" +
                "            4 | " + positions[3][0].field + "| " + positions[3][1].field + "| " + positions[3][2].field + "| " + positions[3][3].field + "| " + positions[3][4].field + "| " + positions[3][5].field + "| " + positions[3][6].field + "| " + positions[3][7].field + "| " + positions[3][8].field + "|                                                                                          4 | " + positions1[3][0].field + "| " + positions1[3][1].field + "| " + positions1[3][2].field + "| " + positions1[3][3].field + "| " + positions1[3][4].field + "| " + positions1[3][5].field + "| " + positions1[3][6].field + "| " + positions1[3][7].field + "| " + positions1[3][8].field + "|\n" +
                "            5 | " + positions[4][0].field + "| " + positions[4][1].field + "| " + positions[4][2].field + "| " + positions[4][3].field + "| " + positions[4][4].field + "| " + positions[4][5].field + "| " + positions[4][6].field + "| " + positions[4][7].field + "| " + positions[4][8].field + "|                                                                                          5 | " + positions1[4][0].field + "| " + positions1[4][1].field + "| " + positions1[4][2].field + "| " + positions1[4][3].field + "| " + positions1[4][4].field + "| " + positions1[4][5].field + "| " + positions1[4][6].field + "| " + positions1[4][7].field + "| " + positions1[4][8].field + "|\n" +
                "            6 | " + positions[5][0].field + "| " + positions[5][1].field + "| " + positions[5][2].field + "| " + positions[5][3].field + "| " + positions[5][4].field + "| " + positions[5][5].field + "| " + positions[5][6].field + "| " + positions[5][7].field + "| " + positions[5][8].field + "|                                                                                          6 | " + positions1[5][0].field + "| " + positions1[5][1].field + "| " + positions1[5][2].field + "| " + positions1[5][3].field + "| " + positions1[5][4].field + "| " + positions1[5][5].field + "| " + positions1[5][6].field + "| " + positions1[5][7].field + "| " + positions1[5][8].field + "|\n" +
                "            7 | " + positions[6][0].field + "| " + positions[6][1].field + "| " + positions[6][2].field + "| " + positions[6][3].field + "| " + positions[6][4].field + "| " + positions[6][5].field + "| " + positions[6][6].field + "| " + positions[6][7].field + "| " + positions[6][8].field + "|                                                                                          7 | " + positions1[6][0].field + "| " + positions1[6][1].field + "| " + positions1[6][2].field + "| " + positions1[6][3].field + "| " + positions1[6][4].field + "| " + positions1[6][5].field + "| " + positions1[6][6].field + "| " + positions1[6][7].field + "| " + positions1[6][8].field + "|\n" +
                "            8 | " + positions[7][0].field + "| " + positions[7][1].field + "| " + positions[7][2].field + "| " + positions[7][3].field + "| " + positions[7][4].field + "| " + positions[7][5].field + "| " + positions[7][6].field + "| " + positions[7][7].field + "| " + positions[7][8].field + "|                                                                                          8 | " + positions1[7][0].field + "| " + positions1[7][1].field + "| " + positions1[7][2].field + "| " + positions1[7][3].field + "| " + positions1[7][4].field + "| " + positions1[7][5].field + "| " + positions1[7][6].field + "| " + positions1[7][7].field + "| " + positions1[7][8].field + "|\n" +
                "            9 | " + positions[8][0].field + "| " + positions[8][1].field + "| " + positions[8][2].field + "| " + positions[8][3].field + "| " + positions[8][4].field + "| " + positions[8][5].field + "| " + positions[8][6].field + "| " + positions[8][7].field + "| " + positions[8][8].field + "|                                                                                          9 | " + positions1[8][0].field + "| " + positions1[8][1].field + "| " + positions1[8][2].field + "| " + positions1[8][3].field + "| " + positions1[8][4].field + "| " + positions1[8][5].field + "| " + positions1[8][6].field + "| " + positions1[8][7].field + "| " + positions1[8][8].field + "|");

    }



}


