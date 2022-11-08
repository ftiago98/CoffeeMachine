public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeMachineBlueprint coffeeMachine = new CoffeeMachineBlueprint(550, 400, 540, 120, 9);

        boolean response;
        do {
            response = coffeeMachine.printMenu();
        } while (response == !true);

    }
}
