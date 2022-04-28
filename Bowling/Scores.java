package Bowling;

public class Scores {

	private Integer player;
	
	private Integer score;
	

	public Scores(Integer player,Integer score){
		this.player=player;
		this.score=score;
	}


	public Integer getPlayer() {
		return player;
	}
	public void setPlayer(Integer player) {
		this.score = player;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
