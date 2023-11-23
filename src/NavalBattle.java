import Assets.Colors;
import Assets.DolbySystem;
import Boats.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NavalBattle {
    static int option = -10;
    static Scanner sc = new Scanner(System.in);
    static boolean playSound = true;
    static PositionField[][] positions = new PositionField[9][9];
    static PositionField[][] positions1 = new PositionField[9][9];
    static PositionField[][] fakePlayerField = new PositionField[9][9];
    static PositionField[][] fakeCPUField = new PositionField[9][9];

    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        start();
    }

    public static void start() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {

        ArrayList<Boat> classic = new ArrayList<>(Arrays.asList(new SmallBoat(), new MediumBoat(), new BigBoat()));
        new BoatList(classic, Colors.CYAN + "Classic" + Colors.RESET);
        new DolbySystem().backgroundMusic();
        System.out.print("\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "Welcome !");
        Thread.sleep(500);
        System.out.print("!");
        Thread.sleep(500);
        System.out.println("!" + Colors.RESET);
        Thread.sleep(500);
        ArrayList<Boat> classic = new ArrayList<>(Arrays.asList(new SmallBoat(), new MediumBoat(), new BigBoat()));
        new BoatList(classic, Colors.CYAN + "Classic" + Colors.RESET);
        DolbySystem dolbySystem = new DolbySystem();
        dolbySystem.backgroundMusicCinematic();
        menu();
    }


    public static void menu() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        DolbySystem dolbySystem = new DolbySystem();
        while (option != 0) {
            Thread.sleep(500);
            System.out.println("\n" + Colors.PURPLE +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   /$$                       /$$$$$$$  /$$        /$$$$$$  /$$     /$$\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$$$                      | $$__  $$| $$       /$$__  $$|  $$   /$$/\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|_  $$                      | $$  \\ $$| $$      | $$  \\ $$ \\  $$ /$$/ \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | $$         /$$$$$$      | $$$$$$$/| $$      | $$$$$$$$  \\  $$$$/  \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | $$        |______/      | $$____/ | $$      | $$__  $$   \\  $$/   \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | $$                      | $$      | $$      | $$  | $$    | $$    \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$$$$$                    | $$      | $$$$$$$$| $$  | $$    | $$    \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|______/                    |__/      |________/|__/  |__/    |__/    \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                      \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                      \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                      \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  /$$$$$$                      /$$$$$$$$ /$$   /$$ /$$$$$$ /$$$$$$$$  \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$$_  $$                    | $$_____/| $$  / $$|_  $$_/|__  $$__/  \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$$$\\ $$                    | $$      |  $$/ $$/  | $$     | $$     \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$ $$ $$       /$$$$$$      | $$$$$    \\  $$$$/   | $$     | $$     \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$\\ $$$$      |______/      | $$__/     >$$  $$   | $$     | $$     \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$ \\ $$$                    | $$       /$$/\\  $$  | $$     | $$     \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|  $$$$$$/                    | $$$$$$$$| $$  \\ $$ /$$$$$$   | $$     \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \\______/                     |________/|__/  |__/|______/   |__/     \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                      \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                      \n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                      \n" + Colors.RESET);
            if (playSound) {
                dolbySystem.chooseOption();
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t=> ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    play();
                    playSound = false;
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("AHM?!?");
            }
        }
    }

    public static void play() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        DolbySystem dolbySystem= new DolbySystem();
        dolbySystem.backgroundMusic();
        fillBoard();
        Scanner sc = new Scanner(System.in);
        String player1;
        String player2;
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + Colors.PURPLE +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   /$$                       /$$$$$$$             /$$$$$$$                                                                                               \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$$$                      | $$__  $$           | $$__  $$                                                                                              \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|_  $$                      | $$  \\ $$ /$$    /$$| $$  \\ $$                                                                                              \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | $$         /$$$$$$      | $$$$$$$/|  $$  /$$/| $$$$$$$/                                                                                              \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | $$        |______/      | $$____/  \\  $$/$$/ | $$____/                                                                                               \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | $$                      | $$        \\  $$$/  | $$                                                                                                    \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$$$$$                    | $$         \\  $/   | $$                                                                                                    \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|______/                    |__/          \\_/    |__/                                                                                                    \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  /$$$$$$                      /$$$$$$$              /$$$$$$                                                                                             \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$__  $$                    | $$__  $$            /$$__  $$                                                                                            \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|__/  \\ $$                    | $$  \\ $$ /$$    /$$| $$  \\__/                                                                                            \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  /$$$$$$/       /$$$$$$      | $$$$$$$/|  $$  /$$/| $$                                                                                                  \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$____/       |______/      | $$____/  \\  $$/$$/ | $$                                                                                                  \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$                          | $$        \\  $$$/  | $$    $$                                                                                            \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$$$$$$$                    | $$         \\  $/   |  $$$$$$/                                                                                            \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|________/                    |__/          \\_/     \\______/                                                                                             \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                                                                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  /$$$$$$                      /$$$$$$$                      /$$                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /$$$_  $$                    | $$__  $$                    | $$                                                                                         \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$$$\\ $$                    | $$  \\ $$  /$$$$$$   /$$$$$$$| $$   /$$                                                                                   \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$ $$ $$       /$$$$$$      | $$$$$$$  |____  $$ /$$_____/| $$  /$$/                                                                                   \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$\\ $$$$      |______/      | $$__  $$  /$$$$$$$| $$      | $$$$$$/                                                                                    \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t| $$ \\ $$$                    | $$  \\ $$ /$$__  $$| $$      | $$_  $$                                                                                    \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|  $$$$$$/                    | $$$$$$$/|  $$$$$$$|  $$$$$$$| $$ \\  $$                                                                                   \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \\______/                     |_______/  \\_______/ \\_______/|__/  \\__/                                                                                   \n" +
                "                                                                                                                                                                                    \n" + Colors.RESET);
        System.out.print("\t=> ");
        option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                System.out.print(
                        "🛳️ Naval battle! 🛳\n\n" +
                                "Insert names.\n" +
                                "P1 name:");

                player1 = sc.nextLine();
                System.out.print("\nP2 name:");
                player2 = sc.nextLine();
                PvP.start(player1, player2);
                break;
            case 2:
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("INSERT YOUR NICKNAME");
                System.out.print("=> ");
                player1 = sc.nextLine();
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

    public static void fillBoard() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                positions[x][y] = new PositionField();
                positions1[x][y] = new PositionField();

                fakePlayerField[x][y] = new PositionField();
                fakeCPUField[x][y] = new PositionField();
            }
        }
    }

    public static void printPlayer1Board(String player1) {
        System.out.print("                       " + Colors.BLUE + player1 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y\n" +
                "            ⬇️\n" +
                "        X ➡️ " + Colors.PURPLE + " | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |\n" + Colors.RESET);
        for (int i = 0; i < positions.length; i++) {
            System.out.print("            " + Colors.PURPLE + (i + 1) + " |" + Colors.RESET);
            for (int j = 0; j < positions[i].length; j++) {
                System.out.print(positions[i][j].field + "|");
            }
            System.out.println();
        }
    }

    public static void printPlayer2Board(String player2) {
        System.out.print("                       " + Colors.RED + player2 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y\n" +
                "            ⬇️\n" +
                "        X ➡️ " + Colors.PURPLE + " | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |\n" + Colors.RESET);
        for (int i = 0; i < positions1.length; i++) {
            System.out.print("            " + Colors.PURPLE + (i + 1) + " |" + Colors.RESET);
            for (int j = 0; j < positions1[i].length; j++) {
                System.out.print(positions1[i][j].field + "|");
            }
            System.out.println();
        }
    }

    public static void printBothBoards(String player1, String player2) {
        System.out.print("                        " + Colors.BLUE + player1 + " TERRITORY" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.RED + player2 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y                                                                                                                   Y\n" +
                "            ⬇️                                                                                                                  ⬇️\n" +
                "        X ➡️ " + Colors.PURPLE + " | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |" + Colors.RESET + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "X ➡️ " + Colors.PURPLE + " | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |\n" + Colors.RESET);

        for (int i = 0; i < positions.length; i++) {
            System.out.print("            " + Colors.PURPLE + (i + 1) + " |" + Colors.RESET);
            for (int j = 0; j < positions[i].length; j++) {
                System.out.print(positions[i][j].field + "|");
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            System.out.print((Colors.PURPLE + (i + 1) + " |" + Colors.RESET));
            for (int j = 0; j < positions1[i].length; j++) {
                System.out.print(positions1[i][j].field + "|");
            }
            System.out.println();
        }
    }

    public static void printBothFakeBoards(String player1, String player2) {
        System.out.print("                        " + Colors.BLUE + player1 + " TERRITORY" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.RED + player2 + " TERRITORY" + Colors.RESET + "\n" +
                "            Y                                                                                                                   Y\n" +
                "            ⬇️                                                                                                                  ⬇️\n" +
                "        X ➡️ " + Colors.PURPLE + " | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |" + Colors.RESET + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "X ➡️ " + Colors.PURPLE + " | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |\n" + Colors.RESET);

        for (int i = 0; i < fakePlayerField.length; i++) {
            System.out.print("            " + Colors.PURPLE + (i + 1) + " |" + Colors.RESET);
            for (int j = 0; j < fakePlayerField[i].length; j++) {
                System.out.print(fakePlayerField[i][j].field + "|");
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            System.out.print((Colors.PURPLE + (i + 1) + " |" + Colors.RESET));
            for (int j = 0; j < fakeCPUField[i].length; j++) {
                System.out.print(fakeCPUField[i][j].field + "|");
            }
            System.out.println();
        }
    }

    public static void printBothFakeBoardsInverted(String player2, String player1) {
        System.out.print("                        " + Colors.BLUE + player2 + " TERRITORY" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.RED + player1 + " TERRITORY" + Colors.RESET + "\n" +

                "            Y                                                                                                                   Y\n" +
                "            ⬇️                                                                                                                  ⬇️\n" +
                "        X ➡️ "+Colors.PURPLE+" | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |"+Colors.RESET + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "X ➡️ "+Colors.PURPLE+" | 𝐀 | 𝐁 | 𝐂 | 𝐃 | 𝐄 | 𝐅 | 𝐆 | 𝐇 | 𝐈 |\n"+Colors.RESET);

        for (int i = 0; i < fakeCPUField.length; i++) {
            System.out.print("            " +Colors.PURPLE+ (i + 1) +" |"+Colors.RESET);
            for (int j = 0; j < fakeCPUField[i].length; j++) {
                System.out.print(fakeCPUField[i][j].field + "|");
            }
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            System.out.print((Colors.PURPLE+ (i + 1) +" |"+Colors.RESET));
            for (int j = 0; j < fakePlayerField[i].length; j++) {
                System.out.print(fakePlayerField[i][j].field + "|");

            }
            System.out.println();
        }
    }

}