public class Weapon {
    int damage = 10;

    public void attack(){
        System.out.println(String.format("对目标造成 %d 点伤害",damage));
    }

}
