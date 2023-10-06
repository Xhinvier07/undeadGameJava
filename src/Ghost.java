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

    public void haunt(Undead target) {
        if (!isDead() && !target.isDead()) {
            int healAmount = (int) (target.getHP() * 0.1);
            setHP(getHP() + healAmount);
            System.out.println(getName() + " heals " + target.getName() + " with " + healAmount + " HP. ");
            System.out.println(target.getName() + " HP: " + target.getHP());
        }
    }
}
