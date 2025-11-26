public abstract class AttackingUnit extends Unit implements Attacker {

    AttackingUnit() {
        super();
    }

    AttackingUnit(int teamInt, int hp) {
        super(teamInt, hp);
    }

    public double attack(Unit target) {
        if (target.getHp() <= 0) {
            System.out.println(target.getName() + " is already dead!");
            return 0;
        }

        if (this.teamInt == target.teamInt) {
            System.out.println("You can't attack allies!");
            return target.getHp();
        }

        double damage = this.attackPower;
        double newHp = target.getHp() - damage;
        target.setHp(Math.max(newHp, 0));

        if (target.getHp() == 0) {
            System.out.println("You damaged " + target.getName() + " for " + damage + " and it has died...");
        } else {
            System.out.println("You damaged " + target.getName() + " for " + damage + " and it has " + target.getHp() + " HP left");
        }

        return target.getHp();
    }

    public double shoot(Unit target) {
        if (this.teamInt == target.teamInt) {
            System.out.println("You can't attack allies!");
            return target.getHp();
        }

        target.setHp(target.getHp() - this.shootPower);
        System.out.println("You damaged " + target.getName() + " for " + this.shootPower + " and it has " + target.getHp());
        if (target.getHp() < 0) {
            System.out.println("RIP");
            System.out.println(target.getName() + " has died...");
        }
        return target.getHp();
    }
}