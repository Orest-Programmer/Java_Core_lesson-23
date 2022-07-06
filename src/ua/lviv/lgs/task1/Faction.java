package ua.lviv.lgs.task1;


import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Faction {
    List<Deputy> deputiesList = new ArrayList<>();

    String name;

    public Faction(String name) {
        this.name = name;
    }

    Supplier<Deputy> getDeputy = () ->{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter surname: ");
        String surname = sc.next();
        return new Deputy(name, surname);
    };

    Supplier<Deputy> fullInfoOfDeputy = () ->{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter surname: ");
        String surname = sc.next();
        System.out.println("Deputy is bribe taker or not (false/true)");
        boolean bribeTaker = sc.nextBoolean();
        System.out.println("Enter weight");
        int weight = sc.nextInt();
        System.out.println("Enter weight");
        int height = sc.nextInt();
        return new Deputy(weight, height, name, surname, bribeTaker);
    };

    void addDeputy(){
        Deputy deputyInfo = fullInfoOfDeputy.get();
        deputiesList.add(deputyInfo);
    }

    void removeDeputy(){
        if(deputiesList.size() < 1){
            System.out.println("Your faction have not deputys");
        }
        else {
            Deputy dp = getDeputy.get();
            Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(dp.getSurname())&& deputy.getName().equalsIgnoreCase(dp.getName());
            Optional<Deputy> deputyFound = deputiesList.stream().filter(isEqualSurnameName).findFirst();
            if(deputyFound.isPresent()){
                deputiesList.remove(deputyFound.get());
                System.out.println("Deputy was removed");
            }else{
                System.out.println("Deputy is not founded");
            }
        }
    }

    void showAllBribeTaker(){
        List<Deputy> bribeTakers = deputiesList.stream().filter(Deputy::isBribeTaker).collect(Collectors.toList());
        bribeTakers.forEach(System.out::println);
    }

    void showAllDeputys(){
        deputiesList.forEach(System.out::println);
    }

    void theBiggestBribeTaker(){
        Comparator<Deputy> deputyBiggestBribe = (deputy1, deputy2) ->
                (deputy1.getSizeOfBribe() > deputy2.getSizeOfBribe()) ? 1 : (deputy1.getSizeOfBribe() == deputy2.getSizeOfBribe()) ? 0 : 1;

        Optional<Deputy> theBiggestBribeTaker = deputiesList.stream().filter(Deputy::isBribeTaker).max(deputyBiggestBribe);

        if (theBiggestBribeTaker.isPresent()){
            System.out.println("The biggest bribe taker is " + theBiggestBribeTaker.get().toString());
        }else {
            System.out.println("Faction have not bribe takers");
        }
    }

    void deleteAllDeputiesFromFaction(){
        if(deputiesList.size() < 1){
            System.out.println("The faction is void");
        }else {
            deputiesList.clear();
            System.out.println("Faction was cleared!");
        }
    }

    void giveBribe(){
        Deputy dp = getDeputy.get();
        Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(dp.getSurname())&& deputy.getName().equalsIgnoreCase(dp.getName());
        Optional<Deputy> deputyFound = deputiesList.stream().filter(isEqualSurnameName).findFirst();
        if(deputyFound.isPresent()){
            deputyFound.get().takeBribe();
        }else {
            System.out.println("The deputy not founded");
        }
    }

    public List<Deputy> getDeputiesList() {
        return deputiesList;
    }

    public String getName() {
        return name;
    }

    public Supplier<Deputy> getGetDeputy() {
        return getDeputy;
    }

    public Supplier<Deputy> getFullInfoOfDeputy() {
        return fullInfoOfDeputy;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "name='" + name + '\'' +
                '}';
    }
}
