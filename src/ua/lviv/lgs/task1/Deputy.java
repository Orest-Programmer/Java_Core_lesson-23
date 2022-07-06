package ua.lviv.lgs.task1;

import java.util.Scanner;

public class Deputy extends Human {
    String name;
    String surname;
    boolean bribeTaker;
    double sizeOfBribe;

    public Deputy(int weight, int height, String name, String surname, boolean bribeTaker) {
        super(weight, height);
        this.name = name;
        this.surname = surname;
        this.bribeTaker = bribeTaker;
    }

    public Deputy(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    void takeBribe(){
        if(!bribeTaker){
            System.out.println("Deputy is not bribe taker");
        }
        else {
            System.out.println("Enter size of bribe: ");
            Scanner sc = new Scanner(System.in);
            double temp = 0;
            try{
                temp = sc.nextInt();
                this.sizeOfBribe += temp;
            }
            catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
            if(temp>5000){
                System.out.println("The police imprison the deputy");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isBribeTaker() {
        return bribeTaker;
    }

    public void setBribeTaker(boolean bribeTaker) {
        this.bribeTaker = bribeTaker;
    }

    public double getSizeOfBribe() {
        return sizeOfBribe;
    }

    public void setSizeOfBribe(double sizeOfBribe) {
        this.sizeOfBribe = sizeOfBribe;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bribeTaker=" + bribeTaker +
                ", sizeOfBribe=" + sizeOfBribe +
                '}';
    }
}
