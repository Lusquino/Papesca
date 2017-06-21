
public class Pescador {
	
	public int temer;
	public int tokens;
	public int pontosDeVitoria;
	public int pontosDeCarencia;
	
	public Pescador()
	{
		temer = 0;
		tokens = 5;
		pontosDeVitoria = 0;
		pontosDeCarencia = 0;
	}

	public int getPontosDeCarencia() {
		return pontosDeCarencia;
	}

	public void setPontosDeCarencia(int pontosDeCarencia) {
		this.pontosDeCarencia = pontosDeCarencia;
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
