public class Mummy extends Zombie {
    private boolean revived;
    private int initialHP;

    public Mummy(String name) {
        super(name);
        this.initialHP = super.getHP();
        this.revived = false;
    }

    @Override
    public void attack(Undead target) {
        if (!isDead() && !target.isDead()) {
            int damage = (int) ((getHP() / 2) + (target.getHP() * 0.10)); // Mummy's attack damage

            if (target instanceof Ghost) { //use instanceof instead of contains
                int reducedDamage = Main.attackGhost((Ghost) target, damage);

                System.out.println("\t\t"+getName() + " attacks " + target.getName() + " with "+ Main.ANSI_RED + reducedDamage + " damage "+ Main.ANSI_RESET);
                System.out.println("\t\t"+target.getName()+ Main.ANSI_GREEN + " HP: " + target.getHP()+ Main.ANSI_RESET);
            }
            else if(target instanceof Mummy){//use instanceof instead of contains
                System.out.println(Main.ANSI_RED+"\t\t"+"Can't attack own kind."+ Main.ANSI_RESET);
            }

            else {
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

    public void revive() {
        if (!revived) {
            if (isDead()) {
                super.setHP(initialHP);
                isDead(false);
                System.out.println("\t\t"+getName() + " has been revived with "+ Main.ANSI_GREEN+ initialHP + " HP."+Main.ANSI_RESET);
                revived = true;
            } else {
                System.out.println(Main.ANSI_RED+"\t\t"+getName() + " is not dead and cannot be revived."+Main.ANSI_RESET);
            }
        } else {
            System.out.println(Main.ANSI_BLUE+"\t\t"+getName() + " has already been revived."+Main.ANSI_RESET);
        }
    }




}

