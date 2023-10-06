public class Zombie extends Undead {
    public Zombie(String name) {
        super.setName(name);
        super.setHP(super.getHP());
    }


    public void attack(Undead target) {
        if (getHP() > 50 && !target.isDead()) {
            int damage = getHP() / 2;
            if (target.getName().contains("- Ghost")){
                int reducedDamage = Main.attackGhost((Ghost) target, damage);

                System.out.println(getName() + " attacks " + target.getName() + " with " + reducedDamage + " damage. ");
                System.out.println(target.getName() + " HP: " + target.getHP());
            }
            else{
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
