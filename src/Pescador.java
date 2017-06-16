
public class Pescador {
	
	public int temer;
	public int tokens;
	public int pontosDeVitoria;
	
	public Pescador()
	{
		temer = 0;
		tokens = 5;
		pontosDeVitoria = 0;
	}

	public int getPontosDeVitoria() {
		return pontosDeVitoria;
	}

	public void setPontosDeVitoria(int pontosDeVitoria) {
		this.pontosDeVitoria = pontosDeVitoria;
	}

	public int getTemer() {
		return temer;
	}

	public void setTemer(int temer) {
		this.temer = temer;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

}
