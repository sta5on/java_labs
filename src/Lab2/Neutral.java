import java.util.Random;

public final class Neutral extends Unit implements Healer, SpecialAbbility {
    private static final String[] nameList =
            {"Mirana", "Shaman", "Shadow", "Lycan", "Circle", "Tango"};

    Neutral() {
        super();
        this.name = nameList[new Random().nextInt(nameList.length)];
    }

    public void heal(Unit target) {
        if ((target.getHp() + 12) > target.getMaxHp()) {
            target.setHp(target.getMaxHp());
            System.out.println("You healed " +
                    ((target == this) ? "yourself" : target.getName()) +
                    " to max health points - " + target.getMaxHp());
        } else {
            target.setHp(target.getHp() + 12);
            System.out.println("You healed " +
                    ((target == this) ? "yourself" : target.getName()) +
                    " for 12, now has " + target.getHp());
        }
    }

    public void specialAbbility(Unit target) {
        double randomAttack = new Random().nextDouble(100);
        double rounded = Math.round(randomAttack * 100.0) / 100.0;

        double leftHp = target.getHp() - rounded;

        target.setHp(leftHp);
        System.out.println(this.getName() + " has been used his special abbility and damaged "
                + target.getName() + " for " + rounded + " hp");
        System.out.println(target.getName() + " now has " + leftHp + " hp left");
    }
}
