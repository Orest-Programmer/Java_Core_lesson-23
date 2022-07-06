package ua.lviv.lgs.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rada r = new Rada();

        while (true){
            menu();
            switch (sc.nextInt()){
                case 1:{
                    r.addFaction();
                    break;
                }

                case 2:{
                    r.removeFaction();
                    break;
                }

                case 3:{
                    r.showAllFactions();
                    break;
                }

                case 4:{
                    r.clearFaction();
                    break;
                }

                case 5:{
                    r.showAllDeputyFromFaction();
                    break;
                }

                case 6:{
                    r.addDeputyToFaction();
                    break;
                }

                case 7:{
                    r.removeDeputyFromFaction();
                    break;
                }

                case 8:{
                    r.showBribeFromFaction();
                    break;
                }

                case 9:{
                r.showBiggestBribeFromFaction();
                    break;
                }

                case 10:{
                    r.giveBribeToDeputyFromFaction();
                    break;
                }

                default:{
                    System.out.println("Not correct enter number of menu!");
                    break;
                }
            }
        }
    }

    public static void menu(){
        System.out.println("Enter 1, to add Faction");
        System.out.println("Enter 2, to delete Faction");
        System.out.println("Enter 3, to show all Faction");
        System.out.println("Enter 4, to clear Faction");
        System.out.println("Enter 5, to show Faction");
        System.out.println("Enter 6, to add Deputy to Faction");
        System.out.println("Enter 7, to delete Deputy from Faction");
        System.out.println("Enter 8, to show list of bribe taker");
        System.out.println("Enter 9, to show most of bribe taker");
    }
}
