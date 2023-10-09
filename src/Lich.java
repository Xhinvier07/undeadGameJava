public class Lich extends Skeleton {
    public Lich(String name) {
        super(name);
        super.setHP(super.getHP());
    }

    // Override the attack method to implement Lich's attack behavior



    public void attack(Undead target) {
        if (!target.isDead() && getHP() != 0 ) {
            int damage = (int) (getHP() * 0.7); // Lich's attack damage
            if (target instanceof Ghost){
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


    // New method to cast a spell and absorb HP from a target undead
    public void castSpell(Undead target) {
        if (!isDead() && !target.isDead()) {
            int hpAbsorb = (int) (target.getHP() * 0.1);
            setHP(getHP() + hpAbsorb);
            System.out.println("\t\t"+getName() + " heals "  + "with " + Main.ANSI_BLUE + hpAbsorb + " HP "+Main.ANSI_RESET);
            System.out.println("\t\t"+target.getName() + Main.ANSI_GREEN+ " HP: " + target.getHP()+Main.ANSI_RESET);
        }
    }
}