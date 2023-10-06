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

            if (target.getName().contains("- Ghost")) {
                int reducedDamage = Main.attackGhost((Ghost) target, damage);

                System.out.println(getName() + " attacks " + target.getName() + " with " + reducedDamage + " damage. ");
                System.out.println(target.getName() + " HP: " + target.getHP());
            }
            else if(target.getName().contains("- Mummy")){
                System.out.println("Can't attack own kind.");
            }

            else {
                target.setHP(target.getHP() - damage);
                if (target.getHP() <= 0) {
                    target.setHP(0);
                    target.isDead(true);
                }
                System.out.println(getName() + " attacks " + target.getName() + " with " + damage + " damage. ");
                System.out.println(target.getName() + " HP: " + target.getHP());
            }
        }
    }

    public void revive() {
        if (!revived) {
            if (isDead()) {
                super.setHP(initialHP);
                isDead(false);
                System.out.println(getName() + " has been revived with " + initialHP + " HP.");
                revived = true;
            } else {
                System.out.println(getName() + " is not dead and cannot be revived.");
            }
        } else {
            System.out.println(getName() + " has already been revived.");
        }
    }




}

