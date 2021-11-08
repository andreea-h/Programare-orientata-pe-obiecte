
interface Strategy {
	float calcul(int aniVechime, float salariu);
}

class TwentyStrategy implements Strategy {
	public float calcul(int aniVechime, float salariu) {
		float i=(float)aniVechime/20;
		return i*salariu;
	}
}

class ThirtyStrategy implements Strategy {
	public float calcul(int aniVechime, float salariu) {
		float i=(float)aniVechime/30;
		return i*salariu;
	}
}

class FortyStrategy implements Strategy {
	public float calcul(int aniVechime, float salariu) {
		float i=(float)aniVechime/40;
		return i*salariu;
	}
}
