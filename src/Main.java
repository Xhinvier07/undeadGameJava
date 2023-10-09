import java.util.ArrayList;
import java.util.Scanner;


class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static boolean useANSIColors = true; //on and off colors (might have bugs depending on the IDE)
    //if you are experiencing errors in the text colors, change the string values to ""


    public static void main(String[] args) {
        /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UndeadGameUI();
            }
        });

*/
        Scanner scanner = new Scanner(System.in);
        ArrayList<Undead> undeadList = new ArrayList<>();

        while (true) {
            System.out.println(ANSI_RED + "\n============================" + ANSI_RESET);
            System.out.println("      UNDEAD GAME MENU      ");
            System.out.println(ANSI_RED + "============================" + ANSI_RESET);
            System.out.println("\t1. Create Undead");
            System.out.println("\t2. Command Undead");
            System.out.println("\t3. Display Undead");
            System.out.println("\t4. Quit");
            System.out.print(ANSI_RED + "\tEnter your choice: " + ANSI_RESET);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUndead(undeadList, scanner);
                    break;
                case 2:
                    commandUndead(undeadList, scanner);
                    break;
                case 3:
                    displayUndead(undeadList);
                    break;
                case 4:
                    System.out.println(ANSI_BLUE + "\n-.-- --- ..- .-. / ... --- ..- .-.. / .. ... / -- .. -. ." + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "Exiting the game." + ANSI_RESET);
                    return;
                default:
                    System.out.println(ANSI_BLUE + "\tInvalid choice. Try again." + ANSI_RESET);
            }
        }
    }

    public static void createUndead(ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_BLUE + "\n..- -. .-.. . .- ... .... / - .... . / -.. . ...- .. .-.." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\n=== " + ANSI_RESET + "CHOOSE YOUR UNDEAD TYPE:");
        System.out.println("\t1. Zombie");
        System.out.println("\t2. Vampire");
        System.out.println("\t3. Skeleton");
        System.out.println("\t4. Ghost");
        System.out.println("\t5. Lich");
        System.out.println("\t6. Mummy");
        System.out.print(ANSI_YELLOW + "\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline


        System.out.print("\n\tEnter a name for the undead: ");
        String name = scanner.nextLine();

        Undead undead = null;

        switch (choice) {
            case 1:
                undead = new Zombie(name.isEmpty() ? "Zombie" : name + ANSI_YELLOW + " - Zombie" + ANSI_RESET);
                break;
            case 2:
                undead = new Vampire(name.isEmpty() ? "Vampire" : name + ANSI_YELLOW + " - Vampire" + ANSI_RESET);
                break;
            case 3:
                undead = new Skeleton(name.isEmpty() ? "Skeleton" : name + ANSI_YELLOW + " - Skeleton" + ANSI_RESET);
                break;
            case 4:
                undead = new Ghost(name.isEmpty() ? "Ghost" : name + ANSI_YELLOW + " - Ghost" + ANSI_RESET);
                break;
            case 5:
                undead = new Lich(name.isEmpty() ? "Lich" : name + ANSI_YELLOW +" - Lich" + ANSI_RESET); //
                break;
            case 6:
                undead = new Mummy(name.isEmpty() ? "Mummy" : name + ANSI_YELLOW + " - Mummy" + ANSI_RESET);
                break;
            default:
                System.out.println(ANSI_BLUE + "\tInvalid choice. Undead creation failed." + ANSI_RESET);
        }

        if (undead != null) {
            undeadList.add(undead);
            System.out.println("\t" + undead.getName() + " created!");
        }
    }
    public static void commandUndead(ArrayList<Undead> undeadList, Scanner scanner) {
        if (undeadList.isEmpty()) {
            System.out.println("\tNo undead to command.");
            return;
        }

        System.out.println(ANSI_BLUE + "\n- .... . / -.-. .... . .- - / -.-. --- -.. . / .. ... / .- .. -. --.. " + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\n=== " + ANSI_RESET + "CHOOSE AN UNDEAD TO COMMAND:");
        for (int i = 0; i < undeadList.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + undeadList.get(i).getName());
        }
        System.out.print(ANSI_YELLOW + "\tEnter the number of the undead: " + ANSI_RESET);
        int undeadIndex = scanner.nextInt();

        if (undeadIndex < 1 || undeadIndex > undeadList.size()) {
            System.out.println(ANSI_BLUE + "\tInvalid undead number." + ANSI_RESET);
            return;
        }

        Undead undead = undeadList.get(undeadIndex - 1);

        if (undead instanceof Mummy) {
            commandMummy((Mummy) undead, undeadList, scanner);
        } else if(undead instanceof Zombie) {
            commandZombie((Zombie) undead, undeadList, scanner);
        } else if (undead instanceof Vampire) {
            commandVampire((Vampire) undead, undeadList, scanner);
        } else if (undead instanceof Ghost) {
            commandGhost((Ghost) undead, undeadList, scanner);
        } else if (undead instanceof Lich) {
            commandLich((Lich) undead, undeadList, scanner);
        } else if (undead instanceof Skeleton) {
            commandSkeleton((Skeleton) undead, undeadList, scanner);
        }

    }

    public static void commandZombie(Zombie zombie, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_GREEN + "\n\t+++ " + ANSI_RESET + "ZOMBIE COMMANDS");
        System.out.println("\t\t1. Attack");
        System.out.println("\t\t2. Eat");
        System.out.println("\t\t3. Exit");
        System.out.print(ANSI_GREEN + "\t\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(zombie, undeadList, scanner);
                break;
            case 2:
                eatUndead(zombie, undeadList, scanner);
            case 3:
                break; // Exit
            default:
                System.out.println(ANSI_BLUE + "\t\tInvalid choice." + ANSI_RESET);
        }
    }


    public static void eatUndead(Zombie zombie, ArrayList<Undead> undeadList, Scanner scanner) {
        if (zombie.isDead()) {
            System.out.println("\n\t\t" + zombie.getName() + " is already dead.");
            return;
        }

        System.out.println(ANSI_GREEN + "\n\t\tChoose an undead to eat:" + ANSI_RESET);

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != zombie && !undeadList.get(i).isDead()) {
                System.out.println("\t\t" + (i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        System.out.print("\n\t\tEnter the number of the undead to eat: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size()) {
            System.out.println(ANSI_BLUE + "\t\tInvalid target." + ANSI_RESET);
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);
        zombie.eat(target);
        System.out.println(ANSI_RED + "\t\t" + zombie.getName() + " eats " + target.getName() + "!" + ANSI_RESET);
    }


    public static void commandVampire(Vampire vampire, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_GREEN + "\n\t+++ " + ANSI_RESET + "VAMPIRE COMMANDS");
        System.out.println("\t\t1. Attack");
        System.out.println("\t\t2. Bite");
        System.out.println("\t\t3. Exit");
        System.out.print(ANSI_GREEN + "\t\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(vampire, undeadList, scanner);
                break;
            case 2:
                biteUndead(vampire, undeadList, scanner);
                break;
            case 3:
                break; // Exit
            default:
                System.out.println(ANSI_BLUE + "\t\tInvalid choice." + ANSI_RESET);
        }
    }

    public static void commandGhost(Ghost ghost, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_GREEN + "\n\t+++ " + ANSI_RESET + "GHOST COMMANDS");
        System.out.println("\t\t1. Attack");
        System.out.println("\t\t2. Haunt");
        System.out.println("\t\t3. Exit");
        System.out.print(ANSI_GREEN + "\t\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(ghost, undeadList, scanner);
                break;
            case 2:
                hauntUndead(ghost, undeadList, scanner);
                break;
            case 3:
                break; // Exit
            default:
                System.out.println(ANSI_BLUE + "\t\tInvalid choice." + ANSI_RESET);
        }
    }

    public static void commandSkeleton(Skeleton skeleton, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_GREEN + "\n\t+++ " + ANSI_RESET + "SKELETON COMMANDS");
        System.out.println("\t\t1. Attack");
        System.out.println("\t\t2. Exit");
        System.out.print(ANSI_GREEN + "\t\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(skeleton, undeadList, scanner);
                break;
            case 2:
                break; // Exit
            default:
                System.out.println(ANSI_BLUE + "\t\tInvalid choice." + ANSI_RESET);
        }
    }
    public static void commandLich(Lich lich, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_GREEN + "\n\t+++ " + ANSI_RESET + "LICH COMMANDS");
        System.out.println("\t\t1. Attack");
        System.out.println("\t\t2. Cast Spell");
        System.out.println("\t\t3. Exit");
        System.out.print(ANSI_GREEN + "\t\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(lich, undeadList, scanner);
                break;
            case 2:
                castSpell(lich, undeadList, scanner);
                break;
            case 3:
                break; // Exit
            default:
                System.out.println(ANSI_BLUE + "\t\tInvalid choice." + ANSI_RESET);
        }
    }

    public static void commandMummy(Mummy mummy, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println(ANSI_GREEN + "\n\t+++ " + ANSI_RESET + "MUMMY COMMANDS");
        System.out.println("\t\t1. Attack");
        System.out.println("\t\t2. Revive");
        System.out.println("\t\t3. Exit");
        System.out.print(ANSI_GREEN + "\t\tEnter your choice: " + ANSI_RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(mummy, undeadList, scanner);
                break;
            case 2:
                mummy.revive();
                break;
            case 3:
                break; // Exit
            default:
                System.out.println(ANSI_BLUE + "\t\tInvalid choice." + ANSI_RESET);
        }
    }



    public static void attackUndead(Undead attacker, ArrayList<Undead> undeadList, Scanner scanner ) {
        if (attacker.isDead()) {
            System.out.println(ANSI_BLUE + "\t\t" + attacker.getName() + " is already dead." + ANSI_RESET);
            return;
        }

        if (!attacker.isDead() && attacker.getHP() <= 0) {
            System.out.println(ANSI_BLUE + "\t\tHP is 0 can't attack." + ANSI_RESET);
            return;
        }

        System.out.println(ANSI_GREEN + "\n\t\tChoose an undead to attack:" + ANSI_RESET);

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != attacker && !undeadList.get(i).isDead()) {
                System.out.println("\t\t" + (i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        // If there are no one else to attack except the attacker itself, print a message (dane commit)
        if (undeadList.size() == 1) {
            System.out.println(ANSI_BLUE + "\n\t\tThere is no one else to attack but yourself. Populate the world with more undead first!" + ANSI_RESET);
            return;
        }

        System.out.print("\n\t\tEnter the number of the undead to attack: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size() || undeadList.get(targetIndex - 1).equals(attacker)) { //adjusted can't attack self
            System.out.println(ANSI_BLUE + "\t\tInvalid target.");
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);

        attacker.attack(target);

    }

    public static void biteUndead(Vampire vampire, ArrayList<Undead> undeadList, Scanner scanner) {
        if (vampire.isDead()) {
            System.out.println("\n\t\t" + vampire.getName() + " is already dead.");
            return;
        }

        System.out.println(ANSI_GREEN + "\n\t\tChoose an undead to bite:" + ANSI_RESET);

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != vampire && !undeadList.get(i).isDead()) {
                System.out.println("\t\t" + (i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        System.out.print("\n\t\tEnter the number of the undead to bite: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size()) {
            System.out.println(ANSI_BLUE + "\t\tInvalid target." + ANSI_RESET);
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);
        vampire.bite(target);
        System.out.println(ANSI_RED + "\t\t" + vampire.getName() + " bites " + target.getName() + "!" + ANSI_RESET);
    }



    public static void hauntUndead(Ghost ghost, ArrayList<Undead> undeadList, Scanner scanner) {
        if (ghost.isDead()) {
            System.out.println("\t\t" + ghost.getName() + " is already dead.");
            return;
        }

        System.out.println(ANSI_GREEN + "\n\t\tChoose an undead to haunt:" + ANSI_RESET);

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != ghost && !undeadList.get(i).isDead()) {
                System.out.println("\t\t" + (i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        System.out.print("\n\t\tEnter the number of the undead to haunt: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size()) {
            System.out.println(ANSI_BLUE + "\t\tInvalid target." + ANSI_RESET);
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);
        ghost.haunt(target);
        System.out.println(ANSI_RED + "\n\t\t" + ghost.getName() + " haunts " + target.getName() + "!" + ANSI_RESET);
    }

    public static void castSpell(Lich lich, ArrayList<Undead> undeadList, Scanner scanner) {
        if (lich.isDead()) {
            System.out.println("\t\t" + lich.getName() + " is already dead.");
            return;
        }

        System.out.println("\n\t\tChoose an undead to cast a spell on:");

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != lich && !undeadList.get(i).isDead()) {
                System.out.println("\t\t" + (i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        System.out.print("\n\t\tEnter the number of the undead to cast a spell on: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size()) {
            System.out.println(ANSI_BLUE + "\t\tInvalid target." + ANSI_RESET);
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);
        lich.castSpell(target);
        System.out.println(ANSI_RED + "\n\t\t" + lich.getName() + " casts a spell on " + target.getName() + "!" + ANSI_RESET);
    }


    //method display
    public static void displayUndead(ArrayList<Undead> undeadList) {
        System.out.println(ANSI_BLUE + "\n-.-. .. -- --- - .- / -- .- / .." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\n=== " + ANSI_RESET + "THE UNDEAD LIST");

        for (Undead undead : undeadList) {
            System.out.println("\n\t" + undead.getName());
            String hpColor = (undead.getHP() == 0) ? ANSI_RED : ANSI_GREEN;
            System.out.println("\tHP: " + hpColor + undead.getHP() + ANSI_RESET);
            System.out.print("\tState: ");

            if (undead.isDead()) {
                System.out.println(ANSI_RED + "DEAD" + ANSI_RESET);
            } else {
                System.out.println(ANSI_BLUE + "ALIVE" + ANSI_RESET);
            }
        }
    }

    //attack ghost and reduce damage (ghost only receives 10% damage) (dane commit)
    public static int attackGhost(Ghost target, int damage) {
        int reducedDamage = (int) (damage * 0.10);
        target.setHP(target.getHP() - reducedDamage);
        if (target.getHP() <= 0) {
            target.setHP(0);
            target.isDead(true);
        }

        return reducedDamage;
    }
    public static String getColoredText(String text, String color) {
        return useANSIColors ? color + text + ANSI_RESET : text;
    }
}