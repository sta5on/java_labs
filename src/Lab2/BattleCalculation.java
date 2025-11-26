public class BattleCalculation {
    public static int calculateCountToDie(Unit attacker, Unit target) {
        double count = target.getHp() / attacker.getAttackPower();
//      100 hp / 10 = 10 times to attack
        return (int) count;
    }
}
