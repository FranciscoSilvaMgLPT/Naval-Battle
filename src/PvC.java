import Assets.Colors;
import Boats.Boat;

import java.util.Scanner;

public interface PvC {

    Scanner sc = new Scanner(System.in);

    BoatList boatlist = CreativeMode.lists.get(0);


    static void start(String player1, String player2) throws InterruptedException {
        NavalBattle.printBothBoards(player1, player2);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "LOADING TO SET PLAYER 1 BOATS.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println("." + Colors.RESET);
        Thread.sleep(1000);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        setPlayerBoats(player1, player2);
    }


    static void setPlayerBoats(String player1, String player2) throws InterruptedException {
        //CreativeMode.seelists();
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

        NavalBattle.printBothBoards(player1, player2);

        Thread.sleep(2000);
        int position1 = 0;
        int position2 = 0;
        boolean boatExistsPlayer1 = existsBoat(NavalBattle.positions, position1, position2);
        boolean boatExistsPlayer2 = existsBoat(NavalBattle.positions1, position1, position2);

        if (boatExistsPlayer1) {
            NavalBattle.positions[position1][position2].field = "☠️";
        } else {
            NavalBattle.positions[position1][position2].field = "💧";
        }

        if (boatExistsPlayer2) {
            NavalBattle.positions1[position1][position2].field = "☠️";
        } else {
            NavalBattle.positions1[position1][position2].field = "💧";
        }

        NavalBattle.printBothBoards(player1,player2);
    }

    static boolean existsBoat(PositionField[][] positions, int x, int y) {
        return positions[x][y].boat != null;
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


        CreativeMode.seelists();
        NavalBattle.printPlayer1Board(player1);

        for (int i = 0; i < BoatList.list.size(); i++) {

            System.out.println("Position: " + BoatList.list.get(i).getName());

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

            System.out.println("Position: " + BoatList.list.get(i).getName());

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

    static void checkNullTemporary() {
        for (int i = 0; i < NavalBattle.positions1.length; i++) {
            for (int j = 0; j < NavalBattle.positions1.length; j++) {
                System.out.println(NavalBattle.positions1[i][j].boat);
            }
        }
    }

}
