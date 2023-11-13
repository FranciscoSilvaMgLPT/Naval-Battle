import java.util.Scanner;

public interface PvP {

    static Scanner sc = new Scanner(System.in);

    static void start(boolean pvp, String player1, String player2) {
        positionBoats(player1,player2);
        NavalBattle.board(player1,player2);
        game(player1,player2);

    }


   static  void game(String player1,String player2) {
       CreativeMode.seelists();
      positionBoats(player1,player2);
   }




    static void positionBoats(String player1, String player2){
        int selectedBoat = 1;
        while (selectedBoat != 0) {
            NavalBattle.board(player1,player2);
            System.out.println("\nLet's play! Choose the boat!");
            System.out.println("1 - "+ BoatList.list.get(0).getName());
            System.out.println("2 - "+ BoatList.list.get(1).getName());
            System.out.println("3 - "+ BoatList.list.get(2).getName());
            System.out.println("0 - Back");
            System.out.print("=> ");
            if (sc.hasNextInt()) {
                selectedBoat = sc.nextInt();
                boatChosed(selectedBoat);

            } else {
                System.out.print("\nTry again");
            }
        }
    }

    static void boatChosed(int selectedBoat){
        switch (selectedBoat) {
            case 1:
                System.out.print("\nX: ");
                String x = sc.next().toLowerCase();
                int newX = convertToLetter(x);
                System.out.print("Y: ");
                int y = sc.nextInt();
                int newY = y - 1;

                if (newY > 0 && newY <= NavalBattle.positions.length && newX >= 0 && newX < NavalBattle.positions[newY].length) {
                    if (NavalBattle.positions[newY][newX].field.equals("🚤") || NavalBattle.positions[newY][newX].field.equals("⛴️️️️") || NavalBattle.positions[newY][newX].field.equals("🛳️")) {
                        System.out.println("\nYou already have a boat in that position.");
                        break;
                    } else {
                       // NavalBattle.positions[newY][newX].insertBoat(BoatList.list.get(selectedBoat).getSymbol());
;                    }
                } else {
                    System.out.println("\nInvalid coordinates. Please enter valid coordinates.");
                    break;
                }

              /*  if (NavalBattle.boat1Quantity > 0) {
                    setDirectionOfBoat(newY, newX);
                    break;
                } else {
                    System.out.println("\nAcabou-se o que era douce!");
                    break;
                }*/
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    static void attack(){

     }

    static int convertToLetter(String letter){
        switch (letter){
            case "a":
                return 1;
            case "b":
                return 2;
            case "c":
                return 3;
            case "d":
                return 4;
            case "e":
                return 5;
            case "f":
                return 6;
            case "g":
                return 7;
            case "h":
                return 8;
            case "i":
                return 9;

            default:
                System.out.println("Invalid Option");
        }
        return -1;
    }

}
