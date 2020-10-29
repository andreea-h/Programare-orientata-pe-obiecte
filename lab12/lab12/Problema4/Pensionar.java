
public class Pensionar {
	int aniVechime;
	float salariu;
	Strategy strategy;
	
	public Pensionar(int aniVechime, float salariu) {
		this.aniVechime = aniVechime;
		this.salariu = salariu;
		if(aniVechime < 30) {
			strategy = new TwentyStrategy();
		}
		else if(aniVechime < 40 && aniVechime > 30) {
			strategy = new ThirtyStrategy();
		}
		else if(aniVechime > 40) {
			strategy = new FortyStrategy();
		}
	}
	
	float getPensie() {
		return strategy.calcul(aniVechime, salariu);
	}
}
