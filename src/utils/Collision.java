package utils;

public class Collision {

	public static boolean rect(Border border1, Border border2) {
		return border1.topLeft.x < border2.topRight.x && border1.topRight.x > border2.topLeft.x &&
				border1.topLeft.y < border2.downLeft.y && border1.downLeft.y > border2.topLeft.y;
	}
	
}
