public class Creep extends Mob {
    private static final int creepMaxHp = 75;
    private static final int baseCreepAttackPower = 6;
    private static final int baseCreepShootPower = 12;

    Creep() {
        super();
        this.name = "Creep";
        this.maxHp = creepMaxHp;
        this.hp = creepMaxHp;
        this.shootPower = baseCreepShootPower;
        this.attackPower = baseCreepAttackPower;
    }

    Creep(int teamInt, int hp) {
        super(teamInt, hp);
        this.name = "Creep";
        this.hp = hp;
        this.maxHp = creepMaxHp;
        this.shootPower = baseCreepShootPower;
        this.attackPower = baseCreepAttackPower;
    }

    void print() {
        super.print();
    }
}
