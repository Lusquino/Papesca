import java.util.Random;

public class TragediaDosComunsAtualizada {
	
	static public Pescador[] pescadores = new Pescador[5];
	static public Peixe[] peixes = new Peixe[4];
	
	public static void main(String[] args) {
			int jogadores = 5;
			int partidas = 10;
			int turnos = 0;
			int vitoria = 0;
			int sustentabilidade = 0;
			int cooperacao = 0;
			int fracasso = 0;
			int peixeAPescado = 0;
			int peixeAExtinto = 0;
			int peixeBPescado = 0;
			int peixeBExtinto = 0;
			int peixeCPescado = 0;
			int peixeCExtinto = 0;
			int peixeDPescado = 0;
			int peixeDExtinto = 0;
			int[] resultados = new int[13];
			boolean regraAdicional = true;
			
			for(int j=0; j<partidas; j++)
			{
				resultados = jogo(jogadores, regraAdicional);
				turnos += resultados[0];
				vitoria += resultados[1];
				fracasso += resultados[2];
				sustentabilidade += resultados[3];
				cooperacao += resultados[4];
				peixeAPescado = resultados[9];
				peixeAExtinto = resultados[5];
				peixeBPescado = resultados[10];
				peixeBExtinto = resultados[6];
				peixeCPescado = resultados[11];
				peixeCExtinto = resultados[7];
				peixeDPescado = resultados[12];
				peixeDExtinto = resultados[8];
			}
		
			System.out.println("Com " + jogadores + " jogadores, a média de turnos para o jogo acabar foi de "
					+(turnos/partidas) + ", a média de pontos de vitória do melhor jogador foi de " +(vitoria/partidas)
					+ " \ne a do pior de " + (fracasso/partidas) + ". A sustentabilidade média foi " 
					+ (sustentabilidade/partidas) + " e o nível médio de cooperação foi " + (cooperacao/partidas) + ".");
			
			System.out.println("\nEstatísticas médias:");
			
			System.out.println("O peixe A foi pescado " + peixeAPescado + " vezes e atingiu a taxa de extinção " 
					+ peixeAExtinto);
			System.out.println("O peixe B foi pescado " + peixeBPescado + " vezes e atingiu a taxa de extinção " 
					+ peixeBExtinto);
			System.out.println("O peixe C foi pescado " + peixeCPescado + " vezes e atingiu a taxa de extinção " 
					+ peixeCExtinto);
			System.out.println("O peixe D foi pescado " + peixeDPescado + " vezes e atingiu a taxa de extinção " 
					+ peixeDExtinto);
	}
	
	public static int[] jogo(int jogadores, boolean regraAdicional)
	{
		Random rand = new Random();
		int turnos = 0;
		int defeso = 0;
		int cooperacao = 0;
		int cogestao = 0;
		int sustentabilidade = 0;
		int beneficiamento = 0;
		int projetoBloqueado = 100;
		boolean educacaoAmbiental = false;
		boolean incubadora = false;
		boolean[] cooperativa = new boolean[pescadores.length];
		boolean barcoAvariado = false;
		
		for(int i=0; i<cooperativa.length; i++)
		{
			cooperativa[i] = false;
		}
		
		pescadores = new Pescador[jogadores];
		
		//ADHOC Valores da pesca
		
		int[] extincao = {4, 5, 6, 7};	
		int[] valores = {11, 7, 5, 3};
		
		for(int i=0;i<pescadores.length;i++)
		{
			pescadores[i] = new Pescador();
		}
		
		for(int i=0;i<peixes.length;i++)
		{
			peixes[i] = new Peixe(extincao[i],valores[i], 5-i, jogadores);
		}
				
		while(!(faliu()||extinguiu()||(sustentabilidade>3)))
		{			
			int papesca = 0;
			beneficiamento = 0;
			
			peixes[defeso].setDefeso(true);
			
			//tirando cartas de eventos
			for(int i = 0; i < pescadores.length; i++)
			{
				int evento = rand.nextInt(12);
				
				if(evento == 0)
				{
					acidenteDeTrabalho(i);
				}
				if((evento == 1)&&!(educacaoAmbiental))
				{
					poluicao();
				}
				if(evento == 2)
				{
					barcoAvariado(barcoAvariado);
				}
				if(evento == 3)
				{
					trafico();
				}
				if(evento == 4)
				{
					problemasFamiliares1(i);
				}
				if(evento == 5)
				{
					problemasFamiliares2(i);
				}
				if(evento == 6)
				{
					problemasFamiliares3(i);
				}
				if(evento == 7)
				{
					projetoBloqueado = conflitosInteresseUFRJ(cooperacao);
				}
				if(evento == 8)
				{
					pescaPredatoriaA();
				}
				if(evento == 9)
				{
					pescaPredatoriaB();
				}
				if(evento == 10)
				{
					pescaPredatoriaC();
				}
				if(evento == 11)
				{
					pescaPredatoriaD();
				}
			}
			
			//decidindo as ações
			for(int i=0; i < pescadores.length; i++)
			{
				for(int j=0; j < pescadores[i].getTokens(); j++)
				{
					int jogada = rand.nextInt(5);
				
					//papesca
					if(jogada == 0)
					{
						papesca++;
						
						boolean ufrj = false;
						while(!ufrj)
						{
							int projeto = rand.nextInt(6);
							
							//gestão social da pesca
							if((projeto == 0)&&!(pescadores[i].isEes())&&!(projetoBloqueado==0))
							{
								pescadores[i].setEes(true);
								ufrj = true;
							}
							
							//curso de navegação
							if((projeto == 1)&&!(pescadores[i].isCapitao())&&!(projetoBloqueado==1))
							{
								pescadores[i].setCapitao(true);
								ufrj = true;
							}
							
							//beneficiamento de pescado
							if((projeto == 2)&&(pescadores[i].isEes())&&!(projetoBloqueado==1))
							{
								beneficiamento = 1;
								ufrj = true;
							}
							
							//educação ambiental
							if((projeto == 3)&&!(projetoBloqueado==2))
							{
								educacaoAmbiental = true;
								ufrj = true;
							}
							
							//beneficiamento de pescado
							if((projeto == 4)&&(beneficiamento == 1)&&!(projetoBloqueado==2))
							{
								beneficiamento = 2;
								ufrj = true;
							}
							
							//cooperativa
							if((projeto == 5)&&(pescadores[i].isRegularizado())&&(pescadores[i].isEes())&&(existeCapitao())&&!(projetoBloqueado==3))
							{
								incubadora = true;
								cooperativa[i] = true;
								ufrj = true;
							}
						}
					}
					
					//pescando
					if(jogada > 0)
					{
						peixes[jogada-1].setPescadores(i);
					}
				}
			}
			
			/*for(int i = 0; i < peixes.length; i++)
			{
				System.out.println(peixes[i].getPescados());
			}*/
				
			//ajustando cooperação, cogestão e sustentabilidade
			if(papesca >= pescadores.length/2){cooperacao++;}
			else
			{
				if(cooperacao > 0){cooperacao--;}
			}
			
			if(papesca == pescadores.length){cogestao--;}
			else
			{
				if(cogestao > 0){cogestao--;}
			}
			
			if(cogestao == 3)
			{
				cogestao = 0;
				sustentabilidade++;
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
							peixes[i].setPescados(peixes[i].getPescados()+1);
							peixes[i].setPescadosTotais(peixes[i].getPescadosTotais()+1);
							
							if((cooperativa[j])&&!(barcoAvariado))
							{
								pescadores[j].setTemer(pescadores[j].getTemer()+2*(peixes[i].getValor())+beneficiamento);
							}
							else
							{
								pescadores[j].setTemer(pescadores[j].getTemer()+peixes[i].getValor()+beneficiamento);
							}
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
				
				if(cooperativa[i])
				{
					if(pescadores[i].getTemer()>2)
					{
						pescadores[i].setTemer(pescadores[i].getTemer()-2);
					}
					else
					{
						pescadores[i].setTemer(0);
					}
				}
			}
			
			//
			if(regraAdicional)
			{
				for(int i=0; i< pescadores.length; i++)
				{
					pescadores[i].setPontosDeVitoria(pescadores[i].getTemer()/4);
					pescadores[i].setTemer(pescadores[i].getTemer()%4);
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
                if(extintos>peixes[i].getExtincao())
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
			barcoAvariado = false;
			
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
				
				peixes[i].setPescados(0);
				peixes[i].setPescadores(pescadoresZerados);
			}
		}
		
		int[] resultados =  new int[13];
		resultados[0]  = turnos;
		resultados[1]  = pescadores[obterMelhorJogador()].getPontosDeVitoria();
		resultados[2]  = pescadores[obterPiorJogador()].getPontosDeVitoria();
		resultados[3]  = sustentabilidade;
		resultados[4]  = cooperacao;
		resultados[5]  = peixes[0].getNivelAtual();
		resultados[6]  = peixes[1].getNivelAtual();
		resultados[7]  = peixes[2].getNivelAtual();
		resultados[8]  = peixes[3].getNivelAtual();
		resultados[9]  = peixes[0].getPescadosTotais();
		resultados[10] = peixes[1].getPescadosTotais();
		resultados[11] = peixes[2].getPescadosTotais();
		resultados[12] = peixes[3].getPescadosTotais();
		
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
			if(peixes[i].getNivelAtual()==4){return true;}
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
	
	public static void acidenteDeTrabalho(int pescador)
	{
		pescadores[pescador].setTokens(pescadores[pescador].getTokens()-1);
	}
	 
	public static void poluicao()
	{
		int especie = 0;
		
		for(int i=0; i<peixes.length; i++)
		{
			if(peixes[i].getNivelAtual()<=especie)
			{
				especie = i;
			}
		}
		
		peixes[especie].setNivelAtual(peixes[especie].getNivelAtual()+1);
	}
	
	public static void barcoAvariado(boolean barcoAvariado)
	{
		barcoAvariado = true;
	}
	
	public static void trafico()
	{
		for(int i=0; i<pescadores.length; i++)
		{
			if(pescadores[i].getTemer()>pescadores[i].getPontosDeCarencia())
			{
				pescadores[i].setTemer(pescadores[i].getTemer()-pescadores[i].getPontosDeCarencia());
			}
			else
			{
				pescadores[i].setTemer(0);
			}
		}
	}
	
	public static void problemasFamiliares1(int pescador)
	{
		pescadores[pescador].setTemer(pescadores[pescador].getTemer()-1);
	}
	
	public static void problemasFamiliares2(int pescador)
	{
		pescadores[pescador].setTemer(pescadores[pescador].getTemer()-2);
	}
	
	public static void problemasFamiliares3(int pescador)
	{
		pescadores[pescador].setTemer(pescadores[pescador].getTemer()-3);
	}
	
	public static int conflitosInteresseUFRJ(int projetoBloqueado)
	{
		if(projetoBloqueado == 0){return 0;}
		if(projetoBloqueado == 1){return 1;}
		if(projetoBloqueado == 2){return 1;}
		if(projetoBloqueado == 3){return 2;}
		if(projetoBloqueado == 4){return 2;}
		if(projetoBloqueado == 5){return 3;}
		return 0;
	}
	
	public static void pescaPredatoriaA()
	{
		if(peixes[0].getNivelAtual()<4)
		{
			peixes[0].setNivelAtual(peixes[0].getNivelAtual()+1);
		}
	}
	
	public static void pescaPredatoriaB()
	{
		if(peixes[1].getNivelAtual()<4)
		{
			peixes[1].setNivelAtual(peixes[1].getNivelAtual()+1);
		}
	}
	
	public static void pescaPredatoriaC()
	{
		if(peixes[2].getNivelAtual()<4)
		{
			peixes[2].setNivelAtual(peixes[2].getNivelAtual()+1);
		}
	}
	
	public static void pescaPredatoriaD()
	{
		if(peixes[3].getNivelAtual()<4)
		{
			peixes[3].setNivelAtual(peixes[3].getNivelAtual()+1);
		}
	}
	
	public static boolean existeCapitao()
	{
		for(int i=0; i<pescadores.length; i++)
		{
			if(pescadores[i].isCapitao()){return true;}
		}
		return false;
	}
}
