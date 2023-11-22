import Assets.Colors;
import Boats.Boat;

import java.util.Scanner;

public class PvC {

    static Scanner sc = new Scanner(System.in);
    BoatList boatlist = CreativeMode.lists.get(0);
    private static boolean gameOver;

    static void start(String player1, String player2) throws InterruptedException {
        loadingBar(3, "LOADING GAME...");

        NavalBattle.printBothBoards(player1, player2);

        Thread.sleep(2500);
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "LOADING TO SET " + player1 + " BOATS.");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.println("." + Colors.RESET);
        Thread.sleep(1500);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        setPlayersBoats(player1, player2);
    }

    static void setPlayersBoats(String player1, String player2) throws InterruptedException {
        boolean playerOneIsReady = false;
        boolean playerTwoIsReady = false;
        while (!(playerOneIsReady && playerTwoIsReady)) {
            playerOneIsReady = player1SetBoat(player1);

            System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.BLUE + "LOADING " + player2 + " TERRITORY.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println("." + Colors.RESET);
            Thread.sleep(1000);
            System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    " + Colors.BLUE + "PREPARING CPU TERRITORY.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println("." + Colors.RESET);
            Thread.sleep(1000);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            playerTwoIsReady = player2SetBoat();

            //NavalBattle.printPlayer2Board(player2);

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
            NavalBattle.printBothFakeBoards(player1, player2);
            cpuAttack(player1, player2);

            if (checkWinPlayer2()) {
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

    static boolean checkWinPlayer2() {
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

        System.out.println("\nEnter the coordinates to attack:");
        System.out.print("X: ");
        String x = sc.next();
        int newX = convertToNumber(x);
        System.out.print("Y: ");
        int y = sc.nextInt();
        int newY = y - 1;

        if (x.equalsIgnoreCase("A") && y == 69) {
            NavalBattle.printPlayer2Board(player2);
            playerAttack(player1, player2);
            return;
        }

        boolean existsBoatInCPUBoard = existsBoatInCPUBoard(newY, newX);

        if (existsBoatInCPUBoard) {
            NavalBattle.positions1[newY][newX].hit = true;
            NavalBattle.fakeCPUField[newY][newX].field = " 🔥";

            Boat hitBoat = NavalBattle.positions1[newY][newX].boat;

            if (hitBoat.getLifeCPUBoard() > 0) {
                hitBoat.setLifeCPUBoard(hitBoat.getLifeCPUBoard() - 1);
            }

            boolean emojisChanged = false;

            if (checkWholeShipHitCPU(hitBoat)) {
                emojisChanged = changeEmojiInFakeBoard(NavalBattle.fakeCPUField, NavalBattle.positions1, hitBoat);
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            NavalBattle.printBothFakeBoards(player1, player2); // Display boards before the message
            if (emojisChanged) {
                System.out.println("\nYou sank a boat! [" + hitBoat.getName() + "]");
            }
            loadingBar(5, "DISPLAYING BOARD...");

        } else {
            NavalBattle.fakeCPUField[newY][newX].field = " 💧";
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            NavalBattle.printBothFakeBoards(player1, player2);
            loadingBar(5, "DISPLAYING BOARD...");
        }
    }

    static void cpuAttack(String player1, String player2) {

        int x = (int) (Math.random() * 9) + 1;
        int newX = x - 1;

        int y = (int) (Math.random() * 9) + 1;
        int newY = y - 1;

        boolean existsBoatInPlayerBoard = existsBoatInPlayerBoard(newY, newX);

        if (existsBoatInPlayerBoard) {
            NavalBattle.positions[newY][newX].hit = true;
            NavalBattle.fakePlayerField[newY][newX].field = " 🔥";

            Boat hitBoat = NavalBattle.positions[newY][newX].boat;

            if (hitBoat.getLifePlayerBoard() > 0) {
                hitBoat.setLifePlayerBoard(hitBoat.getLifePlayerBoard() - 1);
            }
            if (checkWholeShipHitPlayer(hitBoat)) {
                changeEmojiInFakeBoard(NavalBattle.fakePlayerField, NavalBattle.positions, hitBoat);
            }

        } else {
            NavalBattle.fakePlayerField[newY][newX].field = " 💧";
        }
        NavalBattle.printBothFakeBoards(player1, player2);
        loadingBar(5, "DISPLAYING BOARD...");
    }

    private static boolean checkWholeShipHitPlayer(Boat boat) {
        return boat.getLifePlayerBoard() == 0;
    }

    private static boolean checkWholeShipHitCPU(Boat boat) {
        return boat.getLifeCPUBoard() == 0;
    }

    private static boolean changeEmojiInFakeBoard(PositionField[][] fakeBoard, PositionField[][] cpuBoard, Boat boat) {
        String boatSymbol = boat.getSymbol();
        boolean emojisChanged = false;

        for (int i = 0; i < cpuBoard.length; i++) {
            for (int j = 0; j < cpuBoard[i].length; j++) {
                if (cpuBoard[i][j].boat != null && cpuBoard[i][j].boat.getSymbol().equals(boatSymbol) && cpuBoard[i][j].hit) {
                    fakeBoard[i][j].field = " ☠️";
                    emojisChanged = true;
                }
            }
        }
        return emojisChanged;
    }

    static void gameOver(String player) throws InterruptedException {
        if (player.equals("CPU")) {
            System.out.println("\nYou lost! CPU is the winner...");
        } else {
            System.out.println("\nNice one " + player + "! You are the winner...");
        }
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

    private static void setDirectionOfBoatAndInsertPlayer1(int y, int x, Boat boat) {
        boolean successfullyInserted = false;
        while (!successfullyInserted) {
            System.out.println("\nWhich direction do you want the boat?\nW - Up\nD - Right\nS - Down\nA - Left");
            System.out.print("=> ");
            String direction = sc.next().toLowerCase();
            boolean canInsertBoat = canInsertBoatPlayer1(y, x, boat.getSize(), direction);

            if (canInsertBoat) {
                insertBoatInDirectionInPlayerBoard(y, x, boat, direction);
                successfullyInserted = true;
            } else {
                System.out.println(Colors.RED + "Unable to place the boat in this position! Please choose new coordinates." + Colors.RESET);
                System.out.print("Set the X: ");
                String newX = sc.next();
                x = convertToNumber(newX);

                System.out.print("Set the Y: ");
                y = sc.nextInt() - 1;
            }
        }
    }

    private static void insertBoatInDirectionInPlayerBoard(int y, int x, Boat boat, String direction) {
        for (int i = 0; i < boat.getSize(); i++) {
            NavalBattle.positions[y][x].insertBoat(boat);
            switch (direction) {
                case "w":
                    y--;
                    break;
                case "d":
                    x++;
                    break;
                case "s":
                    y++;
                    break;
                case "a":
                    x--;
                    break;
            }
        }
    }

    private static boolean player1SetBoat(String player1) {
        CreativeMode.seeListsPvC();
        NavalBattle.printPlayer1Board(player1);

        for (int i = 0; i < BoatList.list.size(); i++) {
            System.out.println("\nPosition: " + BoatList.list.get(i).getName());

            int x, y;
            boolean positionOccupied;

            do {
                System.out.print("Set the X: ");
                String xInput = sc.next();
                x = convertToNumber(xInput);

                System.out.print("Set the Y: ");
                y = sc.nextInt();

                positionOccupied = isPositionOccupiedByBoatInPlayerBoard(x, y);
                if (positionOccupied) {
                    System.out.println(Colors.RED + "There's already a boat in that position. Please choose new coordinates." + Colors.RESET);
                }
            } while (positionOccupied);

            setDirectionOfBoatAndInsertPlayer1(y - 1, x, BoatList.list.get(i));
            NavalBattle.printPlayer1Board(player1);
        }

        return true;
    }

    private static boolean isPositionOccupiedByBoatInPlayerBoard(int x, int y) {
        return NavalBattle.positions[y - 1][x].boat != null;
    }

    private static boolean player2SetBoat() {
        for (int i = 0; i < BoatList.list.size(); i++) {
            int x, y;
            boolean positionOccupied;

            do {
                x = (int) (Math.random() * 9);
                y = (int) (Math.random() * 9);
                positionOccupied = isPositionOccupiedByBoatInCPUBoard(x, y);
            } while (positionOccupied);

            setDirectionOfBoatAndInsertPlayer2(y, x, BoatList.list.get(i));
        }
        return true;
    }

    private static boolean isPositionOccupiedByBoatInCPUBoard(int x, int y) {
        return NavalBattle.positions1[y][x].boat != null;
    }

    private static void setDirectionOfBoatAndInsertPlayer2(int y, int x, Boat boat) {
        boolean successfullyInserted = false;
        while (!successfullyInserted) {
            int direction = (int) (Math.random() * 4) + 1;
            boolean canInsertBoat = canInsertBoatPlayer2(y, x, boat.getSize(), direction);

            if (canInsertBoat) {
                insertBoatInDirectionInCPUBoard(y, x, boat, direction);
                successfullyInserted = true;
            } else {
                x = (int) (Math.random() * 9);
                y = (int) (Math.random() * 9);
            }
        }
    }

    private static boolean canInsertBoatPlayer2(int startY, int startX, int size, int direction) {
        int y = startY;
        int x = startX;

        for (int i = 0; i < size; i++) {
            switch (direction) {
                case 1:
                    if (y - 1 < 0 || NavalBattle.positions1[y - 1][x].boat != null) {
                        return false;
                    }
                    y--;
                    break;
                case 2:
                    if (x + 1 >= NavalBattle.positions1[0].length || NavalBattle.positions1[y][x + 1].boat != null) {
                        return false;
                    }
                    x++;
                    break;
                case 3:
                    if (y + 1 >= NavalBattle.positions1.length || NavalBattle.positions1[y + 1][x].boat != null) {
                        return false;
                    }
                    y++;
                    break;
                case 4:
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

    private static void insertBoatInDirectionInCPUBoard(int y, int x, Boat boat, int direction) {
        for (int i = 0; i < boat.getSize(); i++) {
            NavalBattle.positions1[y][x].insertBoat(boat);
            switch (direction) {
                case 1:
                    y--;
                    break;
                case 2:
                    x++;
                    break;
                case 3:
                    y++;
                    break;
                case 4:
                    x--;
                    break;
            }
        }
    }

    static int convertToNumber(String letter) {
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

    public static void loadingBar(int seconds, String message) {
        int totalProgress = 100;
        int barLength = 50;
        int progress = 0;
        long startTime = System.currentTimeMillis();

        System.out.println("\n" + message);

        while (progress <= totalProgress) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            double percentage = (double) elapsedTime / (seconds * 1000);

            progress = (int) (totalProgress * percentage);

            StringBuilder progressBar = new StringBuilder("[");
            int numChars = (int) (percentage * barLength);

            for (int i = 0; i < barLength; i++) {
                if (i < numChars) {
                    progressBar.append("=");
                } else {
                    progressBar.append(" ");
                }
            }

            progressBar.append("] " + progress + "%");

            int estimatedTimeRemaining = seconds - (int) (elapsedTime / 1000);
            System.out.print("\r" + progressBar + " - Estimated: " + estimatedTimeRemaining + "s remaining");

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
