package item.weapon;

public class Hand extends Weapon {

	public Hand() {
		super("HAND", 2, -1, 8); //durabilité négative pour traduire durabilité infinie
	}

}
