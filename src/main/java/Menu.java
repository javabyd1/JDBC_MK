import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MENU");
        System.out.println("1. Addressees list ");
        System.out.println("2. Insert ");
        int selectedOption = scanner.nextInt();

        switch (selectedOption) {
            case 1:
                SelectAdresy.showAdresy();
                break;
            case 2:
                InsertNewAdres.insertNewAdres();
                break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
