
public class Pescador {
	
	public int temer;
	public int tokens;
	public int pontosDeVitoria;
	public int pontosDeCarencia;
	public int[] seguroDefeso;
	public boolean ees;
	public boolean capitao;
	public boolean regularizado;
	public boolean alfabetizacao;
	public boolean alfabetizando;
	
	public Pescador()
	{
		temer = 0;
		tokens = 5;
		pontosDeVitoria = 0;
		pontosDeCarencia = 0;
		ees = false;
		capitao = false;
		regularizado = false;
		alfabetizacao = false;
		alfabetizando = false;
		seguroDefeso = new int[4];
		for(int i = 0; i<seguroDefeso.length; i++)
		{
			seguroDefeso[i] = 0;
		}
	}

	public int getSeguroDefeso(int peixe) {
		return seguroDefeso[peixe];
	}

	public void setSeguroDefeso(int peixe, int quantidade) {
		seguroDefeso[peixe] = quantidade;
	}

	public boolean isAlfabetizando() {
		return alfabetizando;
	}

	public void setAlfabetizando(boolean alfabetizando) {
		this.alfabetizando = alfabetizando;
	}

	public boolean isAlfabetizacao() {
		return alfabetizacao;
	}

	public void setAlfabetizacao(boolean alfabetizacao) {
		this.alfabetizacao = alfabetizacao;
	}

	public boolean isCapitao() {
		return capitao;
	}

	public void setCapitao(boolean capitao) {
		this.capitao = capitao;
	}

	public boolean isRegularizado() {
		return regularizado;
	}

	public void setRegularizado(boolean regularizado) {
		this.regularizado = regularizado;
	}

	public boolean isEes() {
		return ees;
	}

	public void setEes(boolean ees) {
		this.ees = ees;
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
