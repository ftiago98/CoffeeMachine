import java.util.Scanner;

public class CoffeeMachineBlueprint {

    Scanner scannner = new Scanner(System.in);

    int money = 0;
    int water = 0;
    int milk = 0;
    int coffeeBeans = 0;
    int cups = 0;

    public CoffeeMachineBlueprint(int money, int water, int milk, int coffeeBeans, int cups) {

        this.money = money;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;

    }

    public void printState(){
        System.out.printf("%nThe coffee machine has:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n"+
                "%d disposable cups%n"+
                "$%d of money%n", water, milk, coffeeBeans, cups, money);
    }

    public boolean printMenu(){
        System.out.printf("%nWrite action (buy, fill, take, remaining, exit):");
        String response = scannner.next();

        switch (response) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillCoffeeMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printState();
                break;
            case "exit":
                return true;
            default:
                System.out.println("Sorry, false input. Try again");
                printMenu();
                break;
        }
        return false;
    }

    public void buyCoffee() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String response = scannner.next();

        switch (response) {
            case "1":
                if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                    water -= 250;
                    coffeeBeans -= 16;
                    cups--;
                    money += 4;
                    System.out.print("I have enough resources, making you a espresso!");
                } else {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (coffeeBeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cups <  1) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    cups--;
                    money += 7;
                    System.out.println("I have enough resources, making you a latte!");
                } else {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < 75){
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeeBeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cups <  1) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 6) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    cups--;
                    money += 6;
                    System.out.println("I have enough resources, making you a cappuccino!");
                } else {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < 100){
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeeBeans < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (cups <  1) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    public void fillCoffeeMachine(){

        System.out.println("Write how many ml of water you want to add: ");
        water += scannner.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        milk += scannner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scannner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        cups += scannner.nextInt();
    }

    public void takeMoney(){
        System.out.printf("I gave you $%d%n", money);
        money = 0;
    }
}
