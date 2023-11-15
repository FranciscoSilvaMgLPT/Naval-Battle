import Boats.Boat;

import java.util.Scanner;

public interface PvP {

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


    System.out.println("Positioning your Boats " + "" + player1);

    for (int i = 0; i <BoatList.list.size(); i++) {

        System.out.println("Position boat: " + BoatList.list.get(i).getName());

        System.out.println("Set the X: ");
        String x = sc.next();
        int newX = convertToLetter(x);

        System.out.println("Set the Y: ");
        int newY = sc.nextInt();

        boolean existAnyBoat = NavalBattle.positions[newY - 1][newX].field.equals(BoatList.list.get(i).getSymbol());

        if (existAnyBoat){
            System.out.println("\n1 - You already have a boat in that position.");
            break;
        } else {
         //  NavalBattle.positions[newY - 1][newX].insertBoat(BoatList.list.get(i));
           // checkNullTemporary();
            setDirectionOfBoatAndInsert1(newY-1,newX,BoatList.list.get(i));

        }
    }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Positioning your Boats " + "" + player2);

        NavalBattle.board2(player1,player2);
        for (int i = 0; i <BoatList.list.size(); i++) {

            System.out.println("Position boat: " + BoatList.list.get(i).getName());

            System.out.println("Set the X: ");
            String x = sc.next();
            int newX = convertToLetter(x);

            System.out.println("Set the Y: ");
            int newY = sc.nextInt();

            boolean existAnyBoat = NavalBattle.positions[newY - 1][newX].field.equals(BoatList.list.get(i).getSymbol());

            if (existAnyBoat){
                System.out.println("\n1 - You already have a boat in that position.");
                break;
            } else {
                //  NavalBattle.positions[newY - 1][newX].insertBoat(BoatList.list.get(i));
                // checkNullTemporary();
                setDirectionOfBoatAndInsert2(newY-1,newX,BoatList.list.get(i));

            }
        }


    }





    static void attack() {


    }

    private static boolean insertBoat(int y, int x, Boat boat){
        boolean canInsert = true;
        int numberOfPositions = 0;
        while (numberOfPositions < boat.getSize()) {
            if(NavalBattle.positions[y][x].boat == null){
                NavalBattle.positions[y][x].insertBoat(boat);
                numberOfPositions++;
            } else if(NavalBattle.positions[y+1][x]==null){
                NavalBattle.positions[y][x].insertBoat(boat);
                numberOfPositions++;
            } else if(NavalBattle.positions[y][x+1]==null){
                NavalBattle.positions[y][x].insertBoat(boat);
                numberOfPositions++;
            } else if(NavalBattle.positions[y-1][x]==null){
                NavalBattle.positions[y][x].insertBoat(boat);
                numberOfPositions++;
            } else if(NavalBattle.positions[y][x-1]==null){
                NavalBattle.positions[y][x].insertBoat(boat);
                numberOfPositions++;
            } else{
                System.out.println("you already have boats");
                canInsert = false;
            }
        } return canInsert;

    }


    private static void setDirectionOfBoatAndInsert1(int y, int x , Boat boat) {
        System.out.println("\nPara que direção queres o barco\nW - Cima\nD - Direita\nS - Baixo\nA - Esquerda");
        String direction = sc.next().toLowerCase();
        switch (direction) {

            case "w":
                int numberOfPositionsW = 0;
                boolean canInsertBoat = true;
                while (numberOfPositionsW < boat.getSize()) {
                    if (NavalBattle.positions[y+1][x].boat == null) { // se e W fica
                        NavalBattle.positions[y][x].insertBoat(boat);
                        y = y + 1;
                        numberOfPositionsW++;
                    }else {
                        System.out.println("You aready have boat");
                        break;
                    }
                }

             // insertBoat(y,x,boat);

                break;
            case "d":
                boolean canInsertBoat2 = true;
                int numberOfPositionsD = 0;
                while (numberOfPositionsD < boat.getSize()) {
                    if (NavalBattle.positions[y][x+1].boat == null) {
                        NavalBattle.positions[y][x].insertBoat(boat);
                         x = x + 1;
                        numberOfPositionsD++;
                    } else {
                        System.out.println("You aready have boat");
                        break;
                    }
                }


                break;
            case "s":
                int numberOfPositionsS = 0;
                boolean canInsertBoat3 = true;
                while(numberOfPositionsS<boat.getSize()) {
                    if (NavalBattle.positions[y+1][x].boat == null) {
                        NavalBattle.positions[y][x].insertBoat(boat);
                        y = y + 1;
                        numberOfPositionsS++;
                    } else{
                        System.out.println("You already have a boat");
                        canInsertBoat3 = false;
                        break;
                    }
                }

                break;
            case "a":
                int numberOfPositionsA = 0;
                boolean canInsertBoat4 = true;
                while(numberOfPositionsA<boat.getSize()) {
                    if (NavalBattle.positions[y][x-1].boat == null) {
                        NavalBattle.positions[y][x].insertBoat(boat);
                        x = x - 1;
                        numberOfPositionsA++;
                    } else{
                        System.out.println("You already have a boat");

                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid direction");
        }
    }

    private static void setDirectionOfBoatAndInsert2(int y, int x , Boat boat) {
        System.out.println("\nPara que direção queres o barco\nW - Cima\nD - Direita\nS - Baixo\nA - Esquerda");
        String direction = sc.next().toLowerCase();
        switch (direction) {

            case "w":
                int numberOfPositionsW = 0;
                boolean canInsertBoat = true;
                while (numberOfPositionsW < boat.getSize()) {
                    if (NavalBattle.positions[y+1][x].boat == null) { // se e W fica
                        NavalBattle.positions[y][x].insertBoat(boat);
                        y = y + 1;
                        numberOfPositionsW++;
                    }else {
                        System.out.println("You aready have boat");
                        break;
                    }
                }

                // insertBoat(y,x,boat);

                break;
            case "d":
                boolean canInsertBoat2 = true;
                int numberOfPositionsD = 0;
                while (numberOfPositionsD < boat.getSize()) {
                    if (NavalBattle.positions[y][x+1].boat == null) {
                        NavalBattle.positions[y][x].insertBoat(boat);
                        x = x + 1;
                        numberOfPositionsD++;
                    } else {
                        System.out.println("You aready have boat");
                        break;
                    }
                }


                break;
            case "s":
                int numberOfPositionsS = 0;
                boolean canInsertBoat3 = true;
                while(numberOfPositionsS<boat.getSize()) {
                    if (NavalBattle.positions[y+1][x].boat == null) {
                        NavalBattle.positions[y][x].insertBoat(boat);
                        y = y + 1;
                        numberOfPositionsS++;
                    } else{
                        System.out.println("You already have a boat");
                        canInsertBoat3 = false;
                        break;
                    }
                }

                break;
            case "a":
                int numberOfPositionsA = 0;
                boolean canInsertBoat4 = true;
                while(numberOfPositionsA<boat.getSize()) {
                    if (NavalBattle.positions[y][x-1].boat == null) {
                        NavalBattle.positions[y][x].insertBoat(boat);
                        x = x - 1;
                        numberOfPositionsA++;
                    } else{
                        System.out.println("You already have a boat");

                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid direction");
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
        for (int i = 0; i <NavalBattle.positions.length ; i++) {
            for (int j = 0; j <NavalBattle.positions.length ; j++) {
                System.out.println(NavalBattle.positions[i][j].boat);

            }

        }
    }

}
