package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {
	
	public static String[] options = {"", "New Game - Easy", "New Game - Medium", "New Game - Hard", "New Game - IMPOSSIBLE", "Commands", "Exit"};
	
	public static int changer = 0;
	
	public static boolean pause = false;
	public static boolean ENTER = false;
	public static boolean up, down;
	
	public static void tick() {
		if(up) {
			changer--;
			
			up = false;
		}
		
		if(down) {
			changer++;
			
			down = false;
		}
		
		if(changer > options.length - 1) {
			changer = 0;
		}
		if(changer < 0) {
			changer = options.length - 1;
		}
		
		if(pause) {
			options[0] = "Continue";
			options[1] = "Change to Easy";
			options[2] = "Change to Medium";
			options[3] = "Change to Hard";
			options[4] = "Change to IMPOSSIBLE";
		}
		
		if(ENTER) {
			if(options[changer] == "Continue") {
				//Continue
				
				pause = false;
				Game.State = "Normal";
			}else if(options[changer] == "New Game - Easy" ||
					options[changer] == "Change to Easy") {
				//Easy
				
				Game.enemy.dificutity = "Easy";
				pause = false;
				Game.State = "Normal";
			}else if(options[changer] == "New Game - Medium" ||
					options[changer] == "Change to Medium") {
				//Medium
				
				Game.enemy.dificutity = "Medium";
				pause = false;
				Game.State = "Normal";
			}else if(options[changer] == "New Game - Hard" ||
					options[changer] == "Change to Hard") {
				//Hard
				
				Game.enemy.dificutity = "Hard";
				pause = false;
				Game.State = "Normal";
			}else if(options[changer] == "New Game - IMPOSSIBLE" ||
					options[changer] == "Change to IMPOSSIBLE") {
				//Impossible
				
				Game.enemy.dificutity = "IMPOSSIBLE";
				pause = false;
				Game.State = "Normal";
			}else if(options[changer] == "Commands") {
				//Commands
				
				
			}else if(options[changer] == "Exit") {
				System.exit(1);
			}
			
			ENTER = false;
		}
	}
	
	public static void render(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("arial", Font.BOLD, 23));
		g.drawString("Pong", Game.WIDTH + 45, 60);
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 13));
		
		for(int i = 0; i < options.length; i++) {
			if(options[changer] == options[i]) {
				g.drawString(">", 51 * Game.SCALE, (50 * Game.SCALE) + (13 * i));
			}
			g.drawString(options[i], 55* Game.SCALE, (50 * Game.SCALE) + (13 * i));
		}
	}
	
}
