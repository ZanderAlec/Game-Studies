package main;

import java.awt.Rectangle;

//Essa classe instancia todas as colisões dos elementos do jogo.
public class Colisoes {
	
	//Rectangle é uma classe nativa que permitirá criar as colisões.
	//Ela cria um retangulo de um tamanho determinado e permite verificar se esses retangulos se cruzam.
	public static Rectangle boundBall;
	public static Rectangle boundPlayer;
	public static Rectangle boundEnemy;
	
	public Colisoes(){
		this.tick();
	}
	
	
	public static void tick() {
		boundBall = new Rectangle((int)Game.ball.x, (int)Game.ball.y, Game.ball.width, Game.ball.height);
		boundPlayer = new Rectangle(Game.player1.posicaoX, Game.player1.posicaoY, Game.player1.width, Game.player1.height);
		boundEnemy = new Rectangle(Game.enemy.posicaoX, Game.enemy.posicaoY, Game.enemy.width, Game.enemy.height);
	}
	
	
}
