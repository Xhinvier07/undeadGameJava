public class Skeleton extends Undead {
    public Skeleton(String name) {
        super.setName(name);
        super.setHP(super.getHP() - 20);
    }

    @Override
    public void attack(Undead target) {
        if (!isDead() && !target.isDead()) {
            int damage = (int) (getHP() * 0.7);

            if (target instanceof Ghost) {//use instanceof instead of contains
                int reducedDamage = Main.attackGhost((Ghost) target, damage);

                System.out.println(getName() + " attacks " + target.getName() + " with " + reducedDamage + " damage. ");
                System.out.println(target.getName() + " HP: " + target.getHP());
            } else {
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
}
