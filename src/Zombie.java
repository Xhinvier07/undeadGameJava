public class Zombie extends Undead {
    public Zombie(String name) {
        super.setName(name);
        super.setHP(super.getHP());
    }


    public void attack(Undead target) {
        if (getHP() > 50 && !target.isDead()) {
            int damage = getHP() / 2;
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
        else{
            System.out.println("\t\t"+getName() + "Can't attack HP is low"+ Main.ANSI_GREEN + " HP: " + target.getHP()+ Main.ANSI_RESET);
        }
    }
}
