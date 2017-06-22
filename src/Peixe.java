public class Peixe {
	
	public int[] niveis;
	public int valor;
	public boolean defeso;
	public int nivelAtual;
	public int[] pescadores;
	public int pescados;
	public int dificuldade;
	public int extincao;
	public int pescadosTotais;
	
	public Peixe(int nivel0, int nivel1, int nivel2, int nivel3, int valor, int dificuldade, int jogadores)
	{
		niveis = new int[4];
		niveis[0] = nivel0;
		niveis[1] = nivel1;
		niveis[2] = nivel2;
		niveis[3] = nivel3;
		this.valor = valor;
		defeso = false;
		nivelAtual = 1;
		pescadores = new int[jogadores];
		pescados = 0;
		pescadosTotais = 0;
		this.dificuldade = dificuldade;
	}
	
	public Peixe(int extincao, int valor, int dificuldade, int jogadores)
	{
		niveis = new int[4];
		this.extincao = extincao;
		this.valor = valor;
		defeso = false;
		nivelAtual = 1;
		pescadores = new int[jogadores];
		pescados = 0;
		this.dificuldade = dificuldade;
	}
	
	public int getPescadosTotais() {
		return pescadosTotais;
	}

	public void setPescadosTotais(int pescadosTotais) {
		this.pescadosTotais = pescadosTotais;
	}

	public int getExtincao() {
		return extincao;
	}

	public void setExtincao(int extincao) {
		this.extincao = extincao;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public int[] getNiveis() {
		return niveis;
	}

	public void setNiveis(int[] niveis) {
		this.niveis = niveis;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isDefeso() {
		return defeso;
	}

	public void setDefeso(boolean defeso) {
		this.defeso = defeso;
	}

	public int getNivelAtual() {
		return nivelAtual;
	}

	public void setNivelAtual(int nivelAtual) {
		this.nivelAtual = nivelAtual;
	}

	public int[] getPescadores() {
		return pescadores;
	}

	public void setPescadores(int pescador) {
		pescadores[pescador]++;
	}
	
	public void setPescadores(int[] pescadores) {
		this.pescadores = pescadores;
	}

	public int getPescados() {
		return pescados;
	}

	public void setPescados(int pescados) {
		this.pescados = pescados;
	}
}
