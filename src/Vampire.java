public class Vampire extends Undead {
    public Vampire(String name) {
        super.setName(name);
        super.setHP(super.getHP()+20);
    }

    public void attack(Undead target) {
        if (!target.isDead() && getHP() != 0 ) {
            int damage = getHP();
            if (target instanceof Ghost){//use instanceof instead of contains
                int reducedDamage = Main.attackGhost((Ghost) target, damage);

                System.out.println("\t\t"+getName() + " attacks " + target.getName() + " with "+ Main.ANSI_RED + reducedDamage + " damage "+ Main.ANSI_RESET);
                System.out.println("\t\t"+target.getName()+ Main.ANSI_GREEN + " HP: " + target.getHP()+ Main.ANSI_RESET);
            }
            else{
                target.setHP(target.getHP() - damage);
                if (target.getHP() <= 0) {
                    target.setHP(0);
                    target.isDead(true);
                }
                System.out.println("\t\t"+getName() + " attacks " + target.getName() + " with "+ Main.ANSI_RED + damage + " damage "+ Main.ANSI_RESET);
                System.out.println("\t\t"+target.getName() + Main.ANSI_GREEN+" HP: " + target.getHP()+Main.ANSI_RESET);
            }

        }

    }
    public boolean isDead() {
        return false; // Vampire immortality
    }


    public void bite(Undead target) {
        if (!isDead() && !target.isDead()) {
            int healAmount = (int) (target.getHP() * 0.8);
            setHP(getHP() + healAmount);
            System.out.println("\t\t"+getName() + " heals "  + "with " + Main.ANSI_BLUE + healAmount + " HP "+Main.ANSI_RESET);
            System.out.println("\t\t"+target.getName() + Main.ANSI_GREEN+ " HP: " + target.getHP()+Main.ANSI_RESET);
        }
    }
}
