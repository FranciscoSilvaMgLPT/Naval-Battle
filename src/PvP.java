import Assets.Colors;
import Boats.Boat;

import java.util.Scanner;



public class PvP {

    static Scanner sc = new Scanner(System.in);

    BoatList boatlist = CreativeMode.lists.get(0);


    static void start(String player1, String player2) throws InterruptedException {
        positionBoats(player1,player2);
        attack(player1,player2);


    }




    static void positionBoats(String player1, String player2) {

        System.out.println("Positioning your Boats " + "" + player1);
        player1SetBoat(player1);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("Positioning your Boats " + "" + player2);
        player2SetBoat(player2);


    }


    static void attack(String player1, String player2) throws InterruptedException {
        System.out.print(Colors.CYAN +"Get the cannons ready.");
        Thread.sleep(1000);
        System.out.print(Colors.CYAN +".");
        Thread.sleep(1000);
        System.out.print(Colors.CYAN +".🔥");
        Thread.sleep(1000);
        displayBothBoards(player1,player2);
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



    private static void player1SetBoat(String player) {


        for (int i = 0; i < BoatList.list.size(); i++) {
            //  hideBoatsPlayer1();
            displayBoard1(player);
            System.out.println("Position boat: " + BoatList.list.get(i).getName());
            System.out.println("Set the X: ");
            String x = sc.next();
            int newX = convertToLetter(x);

            System.out.println("Set the Y: ");
            int newY = sc.nextInt();

            setDirectionOfBoatAndInsertPlayer1(newY - 1, newX, BoatList.list.get(i));
        }

    }

    private static void player2SetBoat(String player) {



        for (int i = 0; i < BoatList.list.size(); i++) {
            //hideBoatsPlayer2();
            displayBoard2(player);
            System.out.println("Position boat: " + BoatList.list.get(i).getName());
            System.out.println("Set the X: ");
            String x = sc.next();
            int newX = convertToLetter(x);

            System.out.println("Set the Y: ");
            int newY = sc.nextInt();

            setDirectionOfBoatAndInsert2(newY - 1, newX, BoatList.list.get(i));
        }


    }


    private static void setDirectionOfBoatAndInsert2(int y, int x , Boat boat) {
        boolean successfullyInserted = false;

        while (!successfullyInserted){
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


    static void checkNullTemporary(){
        for (int i = 0; i <NavalBattle.positions1.length ; i++) {
            for (int j = 0; j <NavalBattle.positions1.length ; j++) {
                System.out.println(NavalBattle.positions1[i][j].boat);

            }

        }
    }
    private static void displayBoard1(String player1) {

        NavalBattle.printPlayer1Board(player1);
    }
    private static void displayBoard2(String player1) {

        NavalBattle.printPlayer2Board(player1);
    }
    private static void displayBothBoards(String player1, String player2){
        NavalBattle.printBothBoards(player1,player2);
    }


    private static void hideBoatsPlayer1(){
        for (int i = 0; i < NavalBattle.positions.length; i++) {
            for (int j = 0; j < NavalBattle.positions[i].length; j++) {
                for (int k = 0; k < BoatList.list.size(); k++) {
                    if (NavalBattle.positions[i][j].getBoat() != null && NavalBattle.positions[i][j].getBoat().getSymbol().equals(BoatList.list.get(k).getSymbol())) {
                        BoatList.list.get(k).setSymbol("⬛");
                    }
                }
            }
        }
    }
    private static void hideBoatsPlayer2(){
        for (int i = 0; i < NavalBattle.positions1.length; i++) {
            for (int j = 0; j < NavalBattle.positions1[i].length; j++) {
                for (int k = 0; k < BoatList.list.size(); k++) {
                    if (NavalBattle.positions1[i][j].getBoat() != null && NavalBattle.positions1[i][j].getBoat().getSymbol().equals(BoatList.list.get(k).getSymbol())) {
                        BoatList.list.get(k).setSymbol("⬛");
                    }
                }
            }
        }
    }

}