public class Ghost extends Undead { //Ghost Undead
    public Ghost(String name) {
        super.setName(name);
        super.setHP(super.getHP()/2);
    }


    public void attack(Undead target) {
        if (!isDead() && !target.isDead()) {
            int damage = (int) (getHP()* 0.2);
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

    public void haunt(Undead target) {
        if (!isDead() && !target.isDead()) {
            int healAmount = (int) (target.getHP() * 0.1);
            setHP(getHP() + healAmount);
            System.out.println("\t\t"+getName() + " heals "  + "with " + Main.ANSI_BLUE + healAmount + " HP "+Main.ANSI_RESET);
            System.out.println("\t\t"+target.getName() + Main.ANSI_GREEN+ " HP: " + target.getHP()+Main.ANSI_RESET);
        }
    }
}
