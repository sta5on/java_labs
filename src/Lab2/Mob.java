public class Mob extends AttackingUnit implements Attacker {
    private static final int mobMaxHp = 75;
    private static final int baseMobAttackPower = 6;
    private static final int baseMobShootPower = 10;

    Mob() {
        super();
        this.maxHp = mobMaxHp;
        this.shootPower = baseMobShootPower;
        this.attackPower = baseMobAttackPower;
    }

    Mob(int teamInt, int hp) {
        super(teamInt, hp);
        this.maxHp = mobMaxHp;
        this.shootPower = baseMobShootPower;
        this.attackPower = baseMobAttackPower;
    }

    void mobHello() {
        System.out.println("Im mob");
    }
}
