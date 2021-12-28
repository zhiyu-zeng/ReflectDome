import java.lang.reflect.Field;

public class WeaponHook extends Weapon{

    private OnUseWeaponAttackListener onUseWeaponAttackListener;

    @Override
    public void attack() {
        try {
            Field damage = Weapon.class.getDeclaredField("damage");
            damage.setAccessible(true);
            damage.set(this,20);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        super.attack();

        if (onUseWeaponAttackListener != null){
            onUseWeaponAttackListener.onUseWeaponAttack(damage);
        }
        
    }

    public void setOnUseWeaponAttackListener(OnUseWeaponAttackListener onUseWeaponAttackListener) {
        this.onUseWeaponAttackListener = onUseWeaponAttackListener;
    }
}
