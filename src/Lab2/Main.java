import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        System.out.println(hero.getHp());

        Creep creep1 = new Creep();
        Creep creep2 = new Creep();

        creep1.print();
        creep2.print();

        Hero hero1 = new Hero(0, 111);
        Creep creep0 = new Creep(1, 100);
        System.out.println(hero1.getHp());
        hero1.attack(creep0);
        hero1.shoot(creep0);
        System.out.println(creep0.getHp());
        Mob mob1 = new Mob(1, 100);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);
        mob1.attack(hero1);

        hero1.heal(hero1);
        hero1.heal(hero1);
        hero1.heal(hero1);
        mob1.attack(creep0);

        System.out.println(mob1.getAttackPower());


        System.out.println("You have " + BattleCalculation.calculateCountToDie(mob1, hero1) + " times, to attack " + hero1.getName() + " to make his hp less than 0" );



        hero1.specialAbbility(creep0);

        Neutral neutral0 = new Neutral();
        neutral0.specialAbbility(hero1);
        //+ final функции
        //+ static function
        // + доделать спец абилку,
        // + сделать логику умирания и проверки перед ударом если чел не умер

        hero1.inputUnit();
        hero1.print();

        Functions.exportJson(hero1.getName(),hero1);

        Hero hero20 = new Hero();
        Creep creep = new Creep();
        Neutral neutral = new Neutral();

        Vector<Unit> units = new Vector<>();
        units.add(hero20);
        units.add(creep);
        units.add(neutral);

        Vector<Healer> healers = new Vector<>();
        healers.add(hero);
        healers.add(neutral);

        Vector<SpecialAbbility> specials = new Vector<>();
        specials.add(hero);
        specials.add(neutral);

        for (int i = 0; i < units.size(); i++) {
            System.out.println(units.get(i).getName() + " hp: " + units.get(i).getHp());
        }

        healers.get(0).heal(creep);
        specials.get(1).specialAbbility(hero);

        Unit a = new Mob();
        ((Mob) a).mobHello();
    }
}
