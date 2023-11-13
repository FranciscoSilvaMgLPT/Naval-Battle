import Assets.Colors;
import Boats.Boat;

import java.util.Scanner;

public interface PvP {
      /* System.out.print("\nX: ");
           x = sc.next().toLowerCase();
           newX = convertToLetter(x);
           System.out.print("Y: ");
           y = sc.nextInt();
           newY = y - 1;

           if ((newY > 0) && (newY <= NavalBattle.positions.length) && (newX >= 0) && (newX < NavalBattle.positions[newY].length)) {
               if (NavalBattle.positions[newY][newX].field.equals("🚤") ||
                       NavalBattle.positions[newY][newX].field.equals("⛴️️️️") || NavalBattle.positions[newY][newX].field.equals("🛳️")) {
                   System.out.println("\nYou already have a boat in that position.");
               }
               else {
                   NavalBattle.positions[newY][newX].insertBoat(BoatList.list.get(selectedBoat));
                   setDirectionOfBoat(newY, newX, symbolOfBoat);

               }
           } else {
               System.out.println("\nInvalid coordinates. Please enter valid coordinates.");

           }
*/

    Scanner sc = new Scanner(System.in);

    BoatList boatlist = CreativeMode.lists.get(0);


    static void start(boolean pvp, String player1, String player2) {
        positionBoats(player1, player2);
        NavalBattle.board(player1, player2);
        game(player1, player2);

    }


    static void game(String player1, String player2) {
        CreativeMode.seelists();
        positionBoats(player1, player2);
    }


    static void positionBoats(String player1, String player2) {
//enquanto player1 n posicioou os seus boats ira correr esse for, quando correr todos, ira passar pro player2;

        NavalBattle.board(player1, player2);
        System.out.println("Positioning your Boats " + "" + player1);
        for (int i = 0; i <BoatList.list.size() ; i++) {

            System.out.println("Position boat: " + BoatList.list.get(i).getName());

            System.out.println("Set the X: ");
            String x = sc.next();
            int newX = convertToLetter(x);

            System.out.println("Set the Y: ");
            int newY = sc.nextInt();
            setDirectionOfBoat(newX,newY, BoatList.list.get(i).getSymbol());

            if (NavalBattle.positions[newY][newX].field.equals("🚤") || NavalBattle.positions[newY][newX].field.equals("⛴️️️️")
                    || NavalBattle.positions[newY][newX].field.equals("🛳️")) {
                System.out.println("\nYou already have a boat in that position.");
            } else {
                NavalBattle.positions[newY-1][newX].insertBoat(BoatList.list.get(i));

            }

        }

    }





    static void attack() {

    }

    static void setDirectionOfBoat(int position, int position2, String symbol) {
        System.out.println("\nPara que direção queres o barco\nW - Cima\nD - Direita\nS - Baixo\nA - Esquerda");
        String direction = sc.next().toLowerCase();
        switch (direction) {
            case "w" -> {
                NavalBattle.positions[position][position2].field = symbol;
                NavalBattle.positions[position - 1][position2].field = symbol;
            }
            case "d" -> {
                NavalBattle.positions[position][position2].field = symbol;
                NavalBattle.positions[position][position2 + 1].field = symbol;
            }
            case "s" -> {
                NavalBattle.positions[position][position2].field = symbol;
                NavalBattle.positions[position + 1][position2].field = symbol;
            }
            case "a" -> {
                NavalBattle.positions[position][position2].field = symbol;
                NavalBattle.positions[position][position2 - 1].field = symbol;
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
