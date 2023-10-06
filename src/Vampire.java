public class Vampire extends Undead {
    public Vampire(String name) {
        super.setName(name);
        super.setHP(super.getHP()+20);
    }

    public void attack(Undead target) {
        if (!target.isDead() && getHP() != 0 ) {
            int damage = getHP();
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


    public void bite(Undead target) {
        if (!isDead() && !target.isDead()) {
            int healAmount = (int) (target.getHP() * 0.8);
            setHP(getHP() + healAmount);
            System.out.println(getName() + " heals " + target.getName() + " with " + healAmount + " HP. ");
            System.out.println(target.getName() + " HP: " + target.getHP());
        }
    }
}
