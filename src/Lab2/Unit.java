import java.util.Random;

public abstract class Unit {
    static String teams[] = {"Ally", "Enemy", "Neutral"}; // 0 - ally, 1 - enemy, 3 - neutral

    int teamInt;

    String team = teams[teamInt];

    String name;
    double maxHp = 100;
    double hp = maxHp;

    int attackPower;
    int shootPower;

    Unit() {
        this.team = ((new Random().nextInt(100)) >= 50 ? teams[0] : teams[1]);
        this.hp = maxHp;
    }

    Unit(int teamInt, int hp) {
        if (teamInt > 2) {
            this.teamInt = ((new Random().nextInt(100)) >= 50 ? 0 : 1);
        } else {
            this.teamInt = teamInt;
        }
        if (hp > maxHp) {
            this.hp = maxHp;
        } else {
            this.hp = hp;
        }
    }

    public void inputUnit() {
        System.out.print("Enter name: ");
        this.name = Functions.inString();

        while (true) {
            System.out.print("Enter HP: ");
            this.maxHp = Functions.inDouble();
            if (maxHp > 0) {
                this.hp = maxHp;
                break;
            }
            System.out.println("HP must be greater than 0");
        }

        while (true) {
            System.out.print("Enter team (0 - Ally, 1 - Enemy, 2 - Neutral): ");
            this.teamInt = Functions.inInt();
            if (teamInt >= 0 && teamInt <= 2) {
                this.team = teams[teamInt];
                break;
            }
            System.out.println("Team must be 0, 1, or 2");
        }
    }

    public final double getHp() {
        return this.hp;
    }

    public final double getMaxHp() {
        return this.maxHp;
    }

    public final int getAttackPower() {
        return attackPower;
    }

    public final int getShootPower() {
        return shootPower;
    }

    public final String getTeam() {
        return this.team;
    }

    public final String getName() {
        return this.name;
    }

    public final void setHp(double hp) {
        this.hp = hp;
    }

    public final void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public final void setShootPower(int shootPower) {
        this.shootPower = shootPower;
    }


    void print() {
        System.out.println("My team is " + team + ", and my name is: " + name);
        System.out.println("My hp is " + this.getHp());
    }

}
