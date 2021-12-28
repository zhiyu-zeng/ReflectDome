public class Hero {
    private Weapon weaponMain;

    public Hero(Weapon weaponMain){
        this.weaponMain = weaponMain;

    }

    public void attack(){
        weaponMain.attack();
    }
}


