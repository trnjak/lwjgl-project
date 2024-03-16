package entities;

import org.lwjgl.input.*;
import org.lwjgl.util.vector.*;

public class Camera {
	private Vector3f pos = new Vector3f(0,0,0);
	private float pitch;
	private float yaw;
	private float roll;
	public Camera(){}
	public void move(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			pos.z-=0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			pos.z+=0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			pos.x+=0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			pos.x-=0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			pos.y-=0.02f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			pos.y+=0.02f;
		}
	}
	public Vector3f getPos() {
		return pos;
	}
	public float getPitch() {
		return pitch;
	}
	public float getYaw() {
		return yaw;
	}
	public float getRoll() {
		return roll;
	}
}