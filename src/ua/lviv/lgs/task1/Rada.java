package ua.lviv.lgs.task1;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Rada {
    List<Faction> faction = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Supplier<Faction> getFaction = () -> {
        System.out.println("Enter name of Faction");
        String factionName = sc.next();

        return new Faction(factionName);
    };

    Optional<Faction> findFaction(){
        Faction factionInfo = getFaction.get();

        Predicate<Faction> isEqualFactionName = faction1 -> faction1.getName().equalsIgnoreCase(factionInfo.getName());
        Optional<Faction> factionFound = faction.stream().filter(isEqualFactionName).findFirst();
        return factionFound;
    }

    void addFaction(){
        faction.add(getFaction.get());
        System.out.println("Faction was added!");
    }

    void removeFaction(){
        Optional<Faction> findFaction = findFaction();
        if(findFaction.isPresent()){
            faction.remove(findFaction);
        }else {
            System.out.println("Faction is not found!");
        }
    }

    void showAllFactions(){
        faction.forEach(System.out::println);
    }

    void addDeputyToFaction(){
        Optional<Faction> factionFound =  findFaction();
        if (factionFound.isPresent()){
            factionFound.get().addDeputy();
        }else {
            System.out.println("Faction is not found!");
        }
    }

    void removeDeputyFromFaction(){
        Optional<Faction> factionFound =  findFaction();
        if (factionFound.isPresent()){
            factionFound.get().removeDeputy();
        }else {
            System.out.println("Faction is not found!");
        }
    }

    void showBribeFromFaction(){
        Optional<Faction> factionFound = findFaction();
        if(factionFound.isPresent()){
            factionFound.get().showAllBribeTaker();
        }else {
            System.out.println("Faction is not found!");
        }
    }
    void showBiggestBribeFromFaction(){
        Optional<Faction> factionFound = findFaction();
        if(factionFound.isPresent()){
            factionFound.get().theBiggestBribeTaker();
        }else {
            System.out.println("Faction is not found!");
        }
    }


    void showAllDeputyFromFaction(){
        Optional<Faction> factionFound = findFaction();
        if (factionFound.isPresent()){
            factionFound.get().showAllDeputys();
        }else {
            System.out.println("Faction is not found!");
        }
    }

    void clearFaction(){
        Optional<Faction> factionFound = findFaction();
        if(factionFound.isPresent()){
            factionFound.get().deleteAllDeputiesFromFaction();
        }else {
            System.out.println("Faction is not found!");
        }
    }

    void giveBribeToDeputyFromFaction(){
        Optional<Faction> factionFound = findFaction();
        if(factionFound.isPresent()){
            factionFound.get().giveBribe();
        }else {
            System.out.println("Faction is not found!");
        }
    }




}
