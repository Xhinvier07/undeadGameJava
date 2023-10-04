class Undead {
    private String name;
    private  int hp;
    private  boolean isDead;

    //default constructor
    public Undead() {
        name = "Undead";
        hp = 100;
        isDead = false;
    }

    // constructor
    public Undead(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.isDead = false;
    }

    //getter
    public boolean isDead() {
        return isDead;
    }


    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }
    public void isDead(boolean isDead) {
        this.isDead = isDead;
    }



    public void attack(Undead target) {
        target.setHP(target.getHP() - hp);
    }


}