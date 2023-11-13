import Assets.Colors;
import Boats.Boat;
import Boats.CreativeBoat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface CreativeMode {
    ArrayList<BoatList> lists = new ArrayList<>();

    static void start() throws IOException, InterruptedException {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println(Colors.PURPLE + "\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ✏️ CREATION MODE ✏️\n" + Colors.RESET);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  1-Lists\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  2-Create Boats\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  0-Back");
        System.out.print(Colors.YELLOW + "Option:" + Colors.RESET);
        option = sc.nextInt();
        switch (option) {
            case 1:
                lists();
                break;
            case 2:
                createBoat();
                break;
            default:
                System.out.println("Ahm?");
                sc.nextInt();
                start();
        }
    }

    static void lists() throws IOException, InterruptedException {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Colors.PURPLE + "🧾 Lists 🧾\n" + Colors.RESET +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  1-See lists\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  2-Create list\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  0-Back");
        System.out.print(Colors.YELLOW + "Option:" + Colors.RESET);
        option = sc.nextInt();
        switch (option) {
            case 1:
                seelists();
                break;
            case 2:
                createList();
                break;
            case 0:
                NavalBattle.play();
                break;
            default:
                System.out.println("Ahm?");
                sc.nextInt();
                start();
        }
    }

    static void seelists() {
        System.out.println("\n\n\n\n");
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i).list.size() > 0) {
                    for (int j = 0; j < lists.get(i).list.size(); j++) {
                        if (j == 0) {
                            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + lists.get(i).name + "-> " + lists.get(i).list.get(j).getName() + " " + lists.get(i).list.get(j).getSymbol().repeat(lists.get(i).list.get(j).getSize()));
                        } else {
                            System.out.print(", " + lists.get(i).list.get(j).getName() + " " + lists.get(i).list.get(j).getSymbol().repeat(lists.get(i).list.get(j).getSize()));
                        }
                    }
                } else {
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + lists.get(i).name + "-> No boats 🏄");
                }
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t ----------------------------------------------------------------------------------");
            }

    }

    static void createList() {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println(Colors.PURPLE + "\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ✏️ CREATING LIST ✏️\n");
        System.out.print("List name:");
        name = sc.nextLine();
        new BoatList(name);
        System.out.println(Colors.GREEN + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  List created!✅" + Colors.RESET);
    }

    static void createBoat() throws IOException, InterruptedException {
        boolean pass = false;
        int option;
        Scanner sc = new Scanner(System.in);
        String name = "";
        int size = 1;

        if (lists.size() > 1) {
            System.out.println(Colors.PURPLE + "\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ✏️ CREATING BOAT ✏️\n");
            System.out.print(Colors.YELLOW + "Boat name: ");
            name = sc.nextLine();
            while (!pass) {
                System.out.print("Insert size: ");
                size = sc.nextInt();
                if (size > 0 && size <= 9) {
                    pass = true;

                    addBoatToList(new CreativeBoat(name, size, symbolPick()));
                    System.out.println(Colors.GREEN + "Boat created!✅" + Colors.RESET);
                } else {
                    System.out.println(Colors.RED + "Minimum size is 1 and max is 9!" + Colors.RESET);
                }
            }
        } else {
            System.out.println("First you must create a list to add boats!");
            System.out.println("1-Create a List\n0-Ok/Back");
            System.out.println(Colors.YELLOW + "Option:" + Colors.RESET);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    createList();
                    createBoat();
                    break;
                case 2:
                    start();
                    break;
                default:
                    System.out.println("Ahm?");
                    sc.nextInt();
                    createBoat();
            }
        }
    }

    static String symbolPick() {
        String symbol = "";
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.print(Colors.YELLOW + "\n\n1-🏊‍️ 2-🏄 3-🚣 4-🐋 5-🦢 6-🦞 7- 🐳 8-🦑 9-🐠 10-🍆\nSymbol nº:");
        option = sc.nextInt();
        if (option == 1) {
            symbol = "🏊";
        } else if (option == 2) {
            symbol = "🏄";
        } else if (option == 3) {
            symbol = "🚣";
        } else if (option == 4) {
            symbol = "🐋";
        } else if (option == 5) {
            symbol = "🦢";
        } else if (option == 6) {
            symbol = "🦞";
        } else if (option == 7) {
            symbol = "🐳";
        } else if (option == 8) {
            symbol = "🦑";
        } else if (option == 9) {
            symbol = "🐠";
        } else if (option == 10) {
            symbol = "🍆";
        } else {
            System.out.println(Colors.RED + "Amazing, maybe try again" + Colors.RESET);
            sc.nextInt();
            symbol = symbolPick();
        }

        return symbol;
    }

    static void addBoatToList(Boat boat) {
        int option;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < lists.size(); i++) {
            System.out.println(i + " - " + lists.get(i).name);
        }
        System.out.print("List number:");
        option = sc.nextInt();
        lists.get(option).list.add(boat);
    }
}
