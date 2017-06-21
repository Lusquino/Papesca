import java.util.Random;

public class TragediaDosComuns {
	
	static public Pescador[] pescadores = new Pescador[5];
	static public Peixe[] peixes = new Peixe[4];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//for(int i = 3; i < 11; i++)
		//{
		int i = 3;
		boolean regraAdicional = true;
			int turnos = 0;
			int vitoria = 0;
			int fracasso = 0;
			int[] resultados;
			for(int j=0; j<10; j++)
			{
				resultados = jogo(i, regraAdicional);
				turnos += resultados[0];
				vitoria += resultados[1];
				fracasso += resultados[2];
			}
		
			System.out.println("Com "+ i+ " jogadores, a média de turnos para o jogo acabar foi de "+(turnos/10)+
					", a média de pontos de vitória do melhor jogador foi de "+(vitoria/10)+" e a do pior de "+(fracasso/10));
		//}
	}
	
	public static int[] jogo(int jogadores, boolean regraAdicional)
	{
		Random rand = new Random();
		int turnos = 0;
		int defeso = 0;
		
		pescadores = new Pescador[jogadores];
		
		int[][] valoresPeixes = new int[4][4];
		
		//ADHOC Valores da pesca
		
		valoresPeixes[0][0] = 3;
		valoresPeixes[0][1] = 2;
		valoresPeixes[0][2] = 1;
		valoresPeixes[0][3] = 1;
		valoresPeixes[1][0] = 4;
		valoresPeixes[1][1] = 3;
		valoresPeixes[1][2] = 2;
		valoresPeixes[1][3] = 1;
		valoresPeixes[2][0] = 5;
		valoresPeixes[2][1] = 4;
		valoresPeixes[2][2] = 3;
		valoresPeixes[2][3] = 2;
		valoresPeixes[3][0] = 6;
		valoresPeixes[3][1] = 5;
		valoresPeixes[3][2] = 4;
		valoresPeixes[3][3] = 3;
		
		int[] valores = {11, 7, 5, 3};
		
		for(int i=0;i<pescadores.length;i++)
		{
			pescadores[i] = new Pescador();
		}
		
		for(int i=0;i<peixes.length;i++)
		{
			peixes[i] = new Peixe(valoresPeixes[i][0],valoresPeixes[i][1],valoresPeixes[i][2],
					valoresPeixes[i][3],valores[i], 5-i, jogadores);
		}
				
		while(!(faliu()||extinguiu()))
		{
			/*for(int i = 0; i < peixes.length; i++)
			{
				System.out.println("Peixe "+i);
				for(int j = 0; j < peixes[i].getPescadores().length; j++)
				{
					System.out.println(peixes[i].getPescadores()[j]);
				}
			}*/
			
			peixes[defeso].setDefeso(true);
			System.out.println(turnos+" "+pescadores[0].getTokens());
			//System.out.println(turnos+" "+ pescadores[0].getTemer()+" "+ pescadores[1].getTemer()+" "+ 
			//pescadores[2].getTemer()+" "+ pescadores[3].getTemer()+" "+ pescadores[4].getTemer());	
			
			//decidindo as ações
			for(int i=0; i < pescadores.length; i++)
			{
				for(int j=0; j < pescadores[i].getTokens(); j++)
				{
					int jogada = rand.nextInt(5);
					if(jogada > 0)
					{
						peixes[jogada-1].setPescadores(i);
						//System.out.println("Pescador "+i+" tentará pescar o peixe "+(jogada-1));
					}
					else
					{
						//System.out.println("Pescador "+i+" deixou de pescar");
					}
				}
			}
			
			for(int i = 0; i < peixes.length; i++)
			{
				//System.out.println("Peixe "+i);
				for(int j=0; j < peixes[i].getPescadores().length; j++)
				{
					//System.out.println("Pescador "+j+": "+ peixes[i].getPescadores()[j]);
				}
			}
			
			//pescando
			for(int i = 0; i < peixes.length; i++)
			{
				for(int j=0; j < peixes[i].getPescadores().length; j++)
				{
					for(int k=0; k <peixes[i].getPescadores()[j]; k++)
					{
						int dado = rand.nextInt(5);
						if(dado>= peixes[i].getDificuldade())
						{
							//System.out.println("Pescador "+j+" pescou o peixe "+i+" e ficou com "+(pescadores[j].getTemer()+peixes[i].getValor()));
							peixes[i].setPescados(peixes[i].getPescados()+1);
							pescadores[j].setTemer(pescadores[j].getTemer()+peixes[i].getValor());
						}
					}
				}
			}
			
			//pagando as despesas
			for(int i=0; i< pescadores.length; i++)
			{
				if(pescadores[i].getTemer()<4)
				{
					pescadores[i].setTemer(0);
					pescadores[i].setTokens(pescadores[i].getTokens()-1);
				}
				else
				{
					pescadores[i].setTemer(pescadores[i].getTemer()-4);
				}
			}
			
			//
			if(regraAdicional)
			{
				for(int i=0; i< pescadores.length; i++)
				{
					pescadores[i].setPontosDeVitoria(pescadores[i].getTemer());
					pescadores[i].setTemer(0);
				}
			}
			
			//verificando se desceu a taxa de extinção
			for(int i = 0; i < peixes.length; i++)
			{
				int extintos = 0;
				for(int j=0; j < peixes[i].getPescados(); j++)
				{
					int jogada = rand.nextInt(5);
					if(jogada <= 1) {extintos++;}
				}
                if(extintos>=peixes[i].getNiveis()[peixes[i].getNivelAtual()])
				{
					if(peixes[i].getNivelAtual()<3)
					{
						peixes[i].setNivelAtual(peixes[i].getNivelAtual()+1);
					}
				}
			}
			
			for(int i= 0; i < peixes.length; i++)
			{
				if(peixes[i].isDefeso())
				{
					boolean foiPescado = false;
					for(int j=0; j < peixes[i].getPescadores().length; j++)
					{
						if(peixes[i].getPescadores()[j] > 0)
						{
							foiPescado = true;
							break;
						}
					}
					if(!foiPescado)
					{
						if(peixes[i].getNivelAtual()>0)
						{
							peixes[i].setNivelAtual(peixes[i].getNivelAtual()-1);
						}
					}
				}
			}
			turnos++;
			
			peixes[defeso].setDefeso(false);
			
			if(defeso==3)
			{
				defeso = 0;
			}
			else
			{
				defeso++;
			}
			
			for(int i = 0; i < peixes.length; i++)
			{
				int[] pescadoresZerados = new int[jogadores];
				for(int j=0; j<jogadores; j++)
				{
					pescadoresZerados[j] = 0;
				}
				
				peixes[i].setPescadores(pescadoresZerados);
			}
		}
		
		int[] resultados =  new int[3];
		resultados[0] = turnos;
		resultados[1]= pescadores[obterMelhorJogador()].getPontosDeVitoria();
		resultados[2]= pescadores[obterPiorJogador()].getPontosDeVitoria();
		
		return resultados;
	}
	
	public static boolean faliu()
	{
		for(int i=0; i <pescadores.length;i++)
		{
			if(pescadores[i].getTokens()<1){return true;}
		}
		return false;
	}
	
	public static boolean extinguiu()
	{
		for(int i=0; i <peixes.length;i++)
		{
			if(peixes[i].getNivelAtual()>=peixes[i].getNiveis().length){return true;}
		}
		return false;
	}
	
	public static int obterMelhorJogador()
	{
		int melhorJogador = 0;
		
		for(int i=0; i < pescadores.length; i++)
		{
			if(pescadores[i].getPontosDeVitoria()>pescadores[melhorJogador].getPontosDeVitoria())
			{
				melhorJogador=i;
			}
		}
		
		return melhorJogador;
	}
	
	public static int obterPiorJogador()
	{
		int piorJogador = 0;
		
		for(int i=0; i < pescadores.length; i++)
		{
			if(pescadores[i].getPontosDeVitoria()<pescadores[piorJogador].getPontosDeVitoria())
			{
				piorJogador=i;
			}
		}
		
		return piorJogador;
	}
}
