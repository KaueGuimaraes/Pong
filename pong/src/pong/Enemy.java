package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	public double x,y;
	public int width,height;
	
	public String dificutity;
	
	public static int points = 0;
	
	public Enemy(int x,int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	
	public void tick() {
		if(dificutity == "Easy") {
			x += (Game.ball.x - x - 6) * 0.04;
		}
		if(dificutity == "Medium") {
			x += (Game.ball.x - x - 6) * 0.06;
		}
		if(dificutity == "Hard") {
			x += (Game.ball.x - x - 6) * 0.10;
		}
		if(dificutity == "IMPOSSIBLE") {
			x += (Game.ball.x - x - 6) * 0.30;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,width,height);
	}
	
}
