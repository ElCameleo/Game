package utils;

public class Vector {

	public float x, y;
	
	public Vector (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector multiply (float val) {
		this.x *= val;
		this.y *= val;
		return this;
	}
	
	public Vector add (float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vector add (Vector pos) {
		this.x += pos.x;
		this.y += pos.y;
		return this;
	}
	
	public static boolean compare (Vector vec1, Vector vec2) {
		return (int) vec1.x == (int) vec2.x && (int) vec1.y == (int) vec2.y;
	}
	
	public static float dist (Vector vec1, Vector vec2) {
		return (float) Math.sqrt(Math.pow(vec1.x - vec2.x, 2) + Math.pow(vec1.y - vec2.y, 2));
	}
	
}
