import java.lang.reflect.Field;

public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero(new Weapon());
        hero.attack();

        try {

            Field weapon = Hero.class.getDeclaredField("weaponMain");
            weapon.setAccessible(true);
            WeaponHook weaponHook = new WeaponHook();
            weaponHook.setOnUseWeaponAttackListener(damage -> {
                System.out.println("damage = " + damage);
                return damage;
            });

            weapon.set(hero,weaponHook);
            hero.attack();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Hero hero1 = new Hero(new Weapon());
        hero.attack();
    }
}
