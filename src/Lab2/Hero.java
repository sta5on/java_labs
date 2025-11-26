import java.util.Random;

public class Hero extends AttackingUnit implements Attacker, SpecialAbbility, Healer {
    private static final int HERO_MAX_HP = 500;
    private static final int baseHeroAttackPower = 12;
    private static final int baseHeroShootPower = 20;
    private static final String[] nameList = {"Herald", "Arnold", "Lina", "Drow", "Dawnbreaker", "Techies"
    };

    Hero() {
        super();
        this.attackPower = baseHeroAttackPower;
        this.shootPower = baseHeroShootPower;
        this.maxHp = HERO_MAX_HP;
        this.hp = HERO_MAX_HP;
        this.name = nameList[new Random().nextInt(nameList.length)];
    }

    Hero(int teamInt, int hp) {
        super(teamInt, hp);
        this.attackPower = baseHeroAttackPower;
        this.shootPower = baseHeroShootPower;
        this.maxHp = HERO_MAX_HP;
        this.hp = hp;
        this.name = nameList[new Random().nextInt(nameList.length)];
    }

    public void heroHello() {
        System.out.println("Im a hero!");
    }

    public void heal(Unit target) {
        if (target.getHp() <= 0) {
            System.out.println("You revived " + ((target == this) ? "yourself" : target.getName()));
        }
        if ((target.getHp() + 25) > target.getMaxHp()) {
            target.setHp(target.getMaxHp());
            System.out.println("You healed " +
                    ((target == this) ? "yourself" : target.getName()) +
                    " to max health points - " + target.getMaxHp());
        } else {
            target.setHp(target.getHp() + 25);
            System.out.println("You healed " +
                    ((target == this) ? "yourself" : target.getName()) +
                    " for 25, now has " + target.getHp());
        }
    }

    public void specialAbbility(Unit target) {
        int randomAttack = new Random().nextInt(100);
        int cachedAttack = this.getAttackPower();
        this.setAttackPower(randomAttack);
        System.out.println(this.getName() + " has " + randomAttack + " hp attack for next hit!");

        this.attack(target);
        this.setAttackPower(randomAttack);
    }
}
