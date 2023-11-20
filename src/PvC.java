import Assets.Colors;
import Boats.Boat;

import java.util.Scanner;

public class PvC {

    static Scanner sc = new Scanner(System.in);
    BoatList boatlist = CreativeMode.lists.get(0);
    private static boolean gameOver;

    static void start(String player1, String player2) throws InterruptedException {
        NavalBattle.printBothBoards(player1, player2);
        Thread.sleep(2500);
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "LOADING TO SET PLAYER 1 BOATS.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println("." + Colors.RESET);
        Thread.sleep(1500);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        setPlayersBoats(player1, player2);
    }

    static void setPlayersBoats(String player1, String player2) throws InterruptedException {
        boolean playerOneIsReady = false;
        boolean playerTwoIsReady = false;
        while (!(playerOneIsReady && playerTwoIsReady)) {
            playerOneIsReady = player1SetBoat(player1, player2);

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.print(Colors.BLUE + "Loading CPU territory.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println("." + Colors.RESET);
            Thread.sleep(1000);
            playerTwoIsReady = player2SetBoat(player1, player2);
        }

        System.out.println("\nPLAYERS STATUS:");
        System.out.println("Player 1 is ready? : " + playerOneIsReady);
        System.out.println("Player 2 is ready? : " + playerTwoIsReady);

        game(player1, player2);
    }

    static void game(String player1, String player2) throws InterruptedException {
        System.out.print(Colors.BLUE + "STARTING GAME.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println("." + Colors.RESET);
        Thread.sleep(1000);

        while (!gameOver) {
            System.out.print(Colors.BLUE + "PLAYER ATTACKING.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println("." + Colors.RESET);
            Thread.sleep(1000);
            NavalBattle.printBothFakeBoards(player1, player2);
            playerAttack(player1, player2);

            if (checkWinPlayer()) {
                System.out.print(Colors.BLUE + "Checking board.");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.println("." + Colors.RESET);
                Thread.sleep(500);
                gameOver = true;
                gameOver(player1);
            }

            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.print(Colors.BLUE + "CPU ATTACKING.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println("." + Colors.RESET);
            Thread.sleep(1000);
            NavalBattle.printBothFakeBoards(player1, player2);
            cpuAttack(player1, player2);

            if (checkWinCPU()) {
                System.out.print(Colors.BLUE + "Checking board.");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.println("." + Colors.RESET);
                Thread.sleep(500);
                gameOver = true;
                gameOver(player2);
            }
        }
    }

    static boolean checkWinPlayer() {
        for (int i = 0; i < NavalBattle.positions1.length; i++) {
            for (int j = 0; j < NavalBattle.positions1[i].length; j++) {
                if (NavalBattle.positions1[i][j].boat != null && !NavalBattle.positions1[i][j].hit) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWinCPU() {
        for (int i = 0; i < NavalBattle.positions.length; i++) {
            for (int j = 0; j < NavalBattle.positions[i].length; j++) {
                if (NavalBattle.positions[i][j].boat != null && !NavalBattle.positions[i][j].hit) {
                    return false;
                }
            }
        }
        return true;
    }

    static void playerAttack(String player1, String player2) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the coordinates to attack:");
        System.out.print("X: ");
        int position1 = sc.nextInt() - 1;
        System.out.print("Y: ");
        int position2 = sc.nextInt() - 1;

        boolean existsBoatInCPUBoard = existsBoatInCPUBoard(position1, position2);

        if (existsBoatInCPUBoard) {
            NavalBattle.positions1[position1][position2].hit = true;
            NavalBattle.fakeCPUField[position1][position2].field = " ☠️";
        } else {
            NavalBattle.fakeCPUField[position1][position2].field = " 💧";
        }

        NavalBattle.printBothFakeBoards(player1, player2);
    }

    static void cpuAttack(String player1, String player2) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the coordinates to attack:");
        System.out.print("X: ");
        int position1 = sc.nextInt() - 1;
        System.out.print("Y: ");
        int position2 = sc.nextInt() - 1;

        boolean existsBoatInPlayerBoard = existsBoatInPlayerBoard(position1, position2);

        if (existsBoatInPlayerBoard) {
            NavalBattle.fakePlayerField[position1][position2].field = " ☠️";
        } else {
            NavalBattle.fakePlayerField[position1][position2].field = " 💧";
        }

        NavalBattle.printBothFakeBoards(player1, player2);
    }

    static void gameOver(String player) throws InterruptedException {
        System.out.println("Nice one! You won " + player);
        Thread.sleep(2000);
        System.exit(0);
    }

    static boolean existsBoatInPlayerBoard(int x, int y) {
        return NavalBattle.positions[x][y].boat != null;
    }

    static boolean existsBoatInCPUBoard(int x, int y) {
        return NavalBattle.positions1[x][y].boat != null;
    }

    private static boolean canInsertBoatPlayer1(int startY, int startX, int size, String direction) {
        int y = startY;
        int x = startX;

        for (int i = 0; i < size; i++) {
            switch (direction) {
                case "w":
                    if (y - 1 < 0 || NavalBattle.positions[y - 1][x].boat != null) {
                        return false;
                    }
                    y--;
                    break;
                case "d":
                    if (x + 1 >= NavalBattle.positions[0].length || NavalBattle.positions[y][x + 1].boat != null) {
                        return false;
                    }
                    x++;
                    break;
                case "s":
                    if (y + 1 >= NavalBattle.positions.length || NavalBattle.positions[y + 1][x].boat != null) {
                        return false;
                    }
                    y++;
                    break;
                case "a":
                    if (x - 1 < 0 || NavalBattle.positions[y][x - 1].boat != null) {
                        return false;
                    }
                    x--;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private static boolean canInsertBoatPlayer2(int startY, int startX, int size, String direction) {
        int y = startY;
        int x = startX;

        for (int i = 0; i < size; i++) {
            switch (direction) {
                case "w":
                    if (y - 1 < 0 || NavalBattle.positions1[y - 1][x].boat != null) {
                        return false;
                    }
                    y--;
                    break;
                case "d":
                    if (x + 1 >= NavalBattle.positions1[0].length || NavalBattle.positions1[y][x + 1].boat != null) {
                        return false;
                    }
                    x++;
                    break;
                case "s":
                    if (y + 1 >= NavalBattle.positions1.length || NavalBattle.positions1[y + 1][x].boat != null) {
                        return false;
                    }
                    y++;
                    break;
                case "a":
                    if (x - 1 < 0 || NavalBattle.positions1[y][x - 1].boat != null) {
                        return false;
                    }
                    x--;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private static void setDirectionOfBoatAndInsertPlayer1(int y, int x, Boat boat) {
        boolean successfullyInserted = false;
        /*for (int i = 0; i < NavalBattle.positions.length; i++) {
            for (int j = 0; j < NavalBattle.positions.length; j++) {
                for (int k = 0; k < BoatList.list.size(); k++) {
                    if (NavalBattle.positions[i][j].getField().equals(BoatList.list.get(k).getSymbol())) {
                        BoatList.list.get(k).setSymbol("⬛");
                    }
                }
            }
        }
        */
        while (!successfullyInserted) {
            System.out.println("\nPara que direção queres o barco\nW - Cima\nD - Direita\nS - Baixo\nA - Esquerda");
            String direction = sc.next().toLowerCase();
            boolean canInsertBoat = canInsertBoatPlayer1(y, x, boat.getSize(), direction);

            if (canInsertBoat) {
                for (int i = 0; i < boat.getSize(); i++) {
                    switch (direction) {
                        case "w":
                            NavalBattle.positions[y][x].insertBoat(boat);
                            y = y - 1;
                            break;
                        case "d":
                            NavalBattle.positions[y][x].insertBoat(boat);
                            x = x + 1;
                            break;
                        case "s":
                            NavalBattle.positions[y][x].insertBoat(boat);
                            y = y + 1;
                            break;
                        case "a":
                            NavalBattle.positions[y][x].insertBoat(boat);
                            x = x - 1;
                            break;
                    }
                }
                successfullyInserted = true;
            } else {
                System.out.println(Colors.RED + "Cant insert the boat, try again" + Colors.RESET);
            }
        }
    }

    private static boolean player1SetBoat(String player1, String player2) {

        /*for (int i = 0; i < NavalBattle.positions1.length; i++) {
            for (int j = 0; j < NavalBattle.positions1.length; j++) {
                for (int k = 0; k < BoatList.list.size(); k++) {
                    if (NavalBattle.positions1[i][j].getField().equals(BoatList.list.get(k).getSymbol())) {
                        BoatList.list.get(k).setSymbol("⬛");
                    }
                }
            }
        }
        */


        CreativeMode.seeListsPvC();
        NavalBattle.printPlayer1Board(player1);

        for (int i = 0; i < BoatList.list.size(); i++) {

            System.out.println("\nPosition: " + BoatList.list.get(i).getName());

            System.out.print("Set the X: ");
            String x = sc.next();
            int newX = convertToLetter(x);

            System.out.print("Set the Y: ");
            int newY = sc.nextInt();

            setDirectionOfBoatAndInsertPlayer1(newY - 1, newX, BoatList.list.get(i));
        }

        return true;
    }

    private static boolean player2SetBoat(String player1, String player2) {

        /*
        for (int i = 0; i < NavalBattle.positions.length; i++) {
            for (int j = 0; j < NavalBattle.positions.length; j++) {
                for (int k = 0; k < BoatList.list.size(); k++) {
                    if (NavalBattle.positions[i][j].getField().equals(BoatList.list.get(k).getSymbol())) {
                        BoatList.list.get(k).setSymbol("⬛");
                    }
                }

            }
        }
        */

        NavalBattle.printPlayer2Board(player2);
        for (int i = 0; i < BoatList.list.size(); i++) {

            System.out.println("\nPosition: " + BoatList.list.get(i).getName());

            System.out.print("Set the X: ");
            String x = sc.next();
            int newX = convertToLetter(x);

            System.out.print("Set the Y: ");
            int newY = sc.nextInt();

            setDirectionOfBoatAndInsertPlayer2(newY - 1, newX, BoatList.list.get(i));

        }

        return true;

    }

    private static void setDirectionOfBoatAndInsertPlayer2(int y, int x, Boat boat) {

        boolean successfullyInserted = false;
        /*for (int i = 0; i < NavalBattle.positions1.length; i++) {
            for (int j = 0; j < NavalBattle.positions1.length; j++) {
                for (int k = 0; k < BoatList.list.size(); k++) {
                    if (NavalBattle.positions1[i][j].getField().equals(BoatList.list.get(k).getSymbol())) {
                        BoatList.list.get(k).setSymbol("⬛");
                    }
                }
            }
        }

         */

        while (!successfullyInserted) {
            System.out.println("\nPara que direção queres o barco\nW - Cima\nD - Direita\nS - Baixo\nA - Esquerda");
            String direction = sc.next().toLowerCase();
            boolean canInsertBoat = canInsertBoatPlayer2(y, x, boat.getSize(), direction);

            if (canInsertBoat) {
                for (int i = 0; i < boat.getSize(); i++) {
                    switch (direction) {
                        case "w":
                            NavalBattle.positions1[y][x].insertBoat(boat);
                            y = y - 1;
                            break;
                        case "d":
                            NavalBattle.positions1[y][x].insertBoat(boat);
                            x = x + 1;
                            break;
                        case "s":
                            NavalBattle.positions1[y][x].insertBoat(boat);
                            y = y + 1;
                            break;
                        case "a":
                            NavalBattle.positions1[y][x].insertBoat(boat);
                            x = x - 1;
                            break;
                    }
                }
                successfullyInserted = true;
            } else {
                System.out.println(Colors.RED + "Cant insert the boat, try again" + Colors.RESET);
            }
        }
    }

    static int convertToLetter(String letter) {
        switch (letter.toLowerCase()) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            case "i":
                return 8;

            default:
                System.out.println("\nInvalid Option");
        }
        return -1;
    }
}
