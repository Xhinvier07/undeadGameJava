public class Lich extends Skeleton {
    public Lich(String name) {
        super(name);
        super.setHP(super.getHP());
    }

    // Override the attack method to implement Lich's attack behavior



    public void attack(Undead target) {
        if (!target.isDead() && getHP() != 0 ) {
            int damage = (int) (getHP() * 0.7); // Lich's attack damage
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
    public boolean isDead() {
        return false; // Vampire immortality
    }


    // New method to cast a spell and absorb HP from a target undead
    public void castSpell(Undead target) {
        if (!isDead() && !target.isDead()) {
            int hpAbsorb = (int) (target.getHP() * 0.1);
            target.setHP(target.getHP() - hpAbsorb);
            setHP(getHP() + hpAbsorb);
            System.out.println(getName() + " heals " + target.getName() + " with " + hpAbsorb + " HP. ");
            System.out.println(target.getName() + " HP: " + target.getHP());
        }
    }
}