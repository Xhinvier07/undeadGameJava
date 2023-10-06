import java.util.ArrayList;
import java.util.Scanner;


 class Main {
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
            System.out.println("Undead Game Menu:");
            System.out.println("1. Create Undead");
            System.out.println("2. Command Undead");
            System.out.println("3. Display Undead");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Exiting the game.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

     public static void createUndead(ArrayList<Undead> undeadList, Scanner scanner) {
         System.out.println("Choose an undead type:");
         System.out.println("1. Zombie");
         System.out.println("2. Vampire");
         System.out.println("3. Skeleton");
         System.out.println("4. Ghost");
         System.out.println("5. Lich");
         System.out.println("6. Mummy");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();
         scanner.nextLine();  // Consume newline

         System.out.print("Enter a name for the undead: ");
         String name = scanner.nextLine();

         Undead undead = null;

         switch (choice) {
             case 1:
                 undead = new Zombie(name.isEmpty() ? "Zombie" : name + " - Zombie");
                 break;
             case 2:
                 undead = new Vampire(name.isEmpty() ? "Vampire" : name + " - Vampire");
                 break;
             case 3:
                 undead = new Skeleton(name.isEmpty() ? "Skeleton" : name + " - Skeleton");
                 break;
             case 4:
                 undead = new Ghost(name.isEmpty() ? "Ghost" : name + " - Ghost");
                 break;
             case 5:
                 undead = new Lich(name.isEmpty() ? "Lich" : name + " - Lich"); //
                 break;
             case 6:
                 undead = new Mummy(name.isEmpty() ? "Mummy" : name + " - Mummy");
                 break;
             default:
                 System.out.println("Invalid choice. Undead creation failed.");
         }

         if (undead != null) {
             undeadList.add(undead);
             System.out.println(undead.getName() + " created!");
         }
     }
     public static void commandUndead(ArrayList<Undead> undeadList, Scanner scanner) {
        if (undeadList.isEmpty()) {
            System.out.println("No undead to command.");
            return;
        }

        System.out.println("Choose an undead to command:");
        for (int i = 0; i < undeadList.size(); i++) {
            System.out.println((i + 1) + ". " + undeadList.get(i).getName());
        }
        System.out.print("Enter the number of the undead: ");
        int undeadIndex = scanner.nextInt();

        if (undeadIndex < 1 || undeadIndex > undeadList.size()) {
            System.out.println("Invalid undead number.");
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
        System.out.println("Zombie Commands:");
        System.out.println("1. Attack");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(zombie, undeadList, scanner);
                break;
            case 2:
                break; // Exit
            default:
                System.out.println("Invalid choice.");
        }
    }

     public static void commandVampire(Vampire vampire, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println("Vampire Commands:");
        System.out.println("1. Attack");
        System.out.println("2. Bite");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
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
                System.out.println("Invalid choice.");
        }
    }

     public static void commandGhost(Ghost ghost, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println("Ghost Commands:");
        System.out.println("1. Attack");
        System.out.println("2. Haunt");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
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
                System.out.println("Invalid choice.");
        }
    }

     public static void commandSkeleton(Skeleton skeleton, ArrayList<Undead> undeadList, Scanner scanner) {
        System.out.println("Skeleton Commands:");
        System.out.println("1. Attack");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                attackUndead(skeleton, undeadList, scanner);
                break;
            case 2:
                break; // Exit
            default:
                System.out.println("Invalid choice.");
        }
    }
     public static void commandLich(Lich lich, ArrayList<Undead> undeadList, Scanner scanner) {
         System.out.println("Lich Commands:");
         System.out.println("1. Attack");
         System.out.println("2. Cast Spell");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");
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
                 System.out.println("Invalid choice.");
         }
     }

     public static void commandMummy(Mummy mummy, ArrayList<Undead> undeadList, Scanner scanner) {
         System.out.println("Mummy Commands:");
         System.out.println("1. Attack");
         System.out.println("2. Revive");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");
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
                 System.out.println("Invalid choice.");
         }
     }



     public static void attackUndead(Undead attacker, ArrayList<Undead> undeadList, Scanner scanner ) {
        if (attacker.isDead()) {
            System.out.println(attacker.getName() + " is already dead.");
            return;
        }

         if (!attacker.isDead() && attacker.getHP() <= 0) {
             System.out.println("HP is 0 can't attack. ");
             return;
         }

        System.out.println("Choose an undead to attack:");

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != attacker && !undeadList.get(i).isDead()) {
                System.out.println((i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        // If there are no one else to attack except the attacker itself, print a message
        if (undeadList.size() == 1) {
            System.out.println("There is no one else to attack but yourself. Populate the world with more undead first!");
            return;
        }

        System.out.print("Enter the number of the undead to attack: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size() || undeadList.get(targetIndex - 1).equals(attacker)) {
            System.out.println("Invalid target.");
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);

        attacker.attack(target);

    }

     public static void biteUndead(Vampire vampire, ArrayList<Undead> undeadList, Scanner scanner) {
        if (vampire.isDead()) {
            System.out.println(vampire.getName() + " is already dead.");
            return;
        }

        System.out.println("Choose an undead to bite:");

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != vampire && !undeadList.get(i).isDead()) {
                System.out.println((i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        System.out.print("Enter the number of the undead to bite: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size()) {
            System.out.println("Invalid target.");
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);
        vampire.bite(target);
        System.out.println(vampire.getName() + " bites " + target.getName() + "!");
    }



     public static void hauntUndead(Ghost ghost, ArrayList<Undead> undeadList, Scanner scanner) {
        if (ghost.isDead()) {
            System.out.println(ghost.getName() + " is already dead.");
            return;
        }

        System.out.println("Choose an undead to haunt:");

        for (int i = 0; i < undeadList.size(); i++) {
            if (undeadList.get(i) != ghost && !undeadList.get(i).isDead()) {
                System.out.println((i + 1) + ". " + undeadList.get(i).getName());
            }
        }

        System.out.print("Enter the number of the undead to haunt: ");
        int targetIndex = scanner.nextInt();

        if (targetIndex < 1 || targetIndex > undeadList.size()) {
            System.out.println("Invalid target.");
            return;
        }

        Undead target = undeadList.get(targetIndex - 1);
        ghost.haunt(target);
        System.out.println(ghost.getName() + " haunts " + target.getName() + "!");
    }

     public static void castSpell(Lich lich, ArrayList<Undead> undeadList, Scanner scanner) {
         if (lich.isDead()) {
             System.out.println(lich.getName() + " is already dead.");
             return;
         }

         System.out.println("Choose an undead to cast a spell on:");

         for (int i = 0; i < undeadList.size(); i++) {
             if (undeadList.get(i) != lich && !undeadList.get(i).isDead()) {
                 System.out.println((i + 1) + ". " + undeadList.get(i).getName());
             }
         }

         System.out.print("Enter the number of the undead to cast a spell on: ");
         int targetIndex = scanner.nextInt();

         if (targetIndex < 1 || targetIndex > undeadList.size()) {
             System.out.println("Invalid target.");
             return;
         }

         Undead target = undeadList.get(targetIndex - 1);
         lich.castSpell(target);
         System.out.println(lich.getName() + " casts a spell on " + target.getName() + "!");
     }


    //method display
    public static void displayUndead(ArrayList<Undead> undeadList) {
        System.out.println("Undead List:");

        for (Undead undead : undeadList) {
            System.out.println(undead.getName());
            System.out.println("HP: " + undead.getHP());
            System.out.println("State: " + (undead.isDead() ? "dead" : "alive"));
        }
    }

    //attack ghost and reduce damage (ghost only receives 10% damage)
    public static int attackGhost(Ghost target, int damage) {
        int reducedDamage = (int) (damage * 0.10);
        target.setHP(target.getHP() - reducedDamage);
        if (target.getHP() <= 0) {
            target.setHP(0);
            target.isDead(true);
        }
        
        return reducedDamage;
    }
}