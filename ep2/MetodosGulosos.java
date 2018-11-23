package ep2;


public abstract class MetodosGulosos {


	/*This section is all the auxiliaries sort function 
	for the three methods of ordering the insertion on the bagpack*/

	//Oganizes the values according with their weights from the smallest to bigest using a selection sort algorithm
	static void selecaoCresc(Objeto[] listaDeObjetosDisponiveis){
		for(int i = 0; i<listaDeObjetosDisponiveis.length-1; i++){
			
			int posMenor = i;
			
			for(int p = i+1; p < listaDeObjetosDisponiveis.length; p++){
				if(listaDeObjetosDisponiveis[p].getPeso() < listaDeObjetosDisponiveis[posMenor].getPeso())
				    posMenor = p;
		    }
			if(listaDeObjetosDisponiveis[posMenor].getPeso() < listaDeObjetosDisponiveis[i].getPeso()){
				
				Objeto aux = listaDeObjetosDisponiveis[i];
				listaDeObjetosDisponiveis[i] = listaDeObjetosDisponiveis[posMenor];
				listaDeObjetosDisponiveis[posMenor] = aux;
				
			}
		}
	}
	//Oganizes the values according with their weights from the bigest to smallest using a selection sort algorithm
	static void selecaoDecresc(Objeto[] listaDeObjetosDisponiveis){
		for(int i = 0; i<listaDeObjetosDisponiveis.length-1; i++){
			
			int posMenor = i;
			
			for(int p = i+1; p < listaDeObjetosDisponiveis.length; p++){
				if(listaDeObjetosDisponiveis[p].getPeso() > listaDeObjetosDisponiveis[posMenor].getPeso())
				    posMenor = p;
		    }
			if(listaDeObjetosDisponiveis[posMenor].getPeso() > listaDeObjetosDisponiveis[i].getPeso()){
				
				Objeto aux = listaDeObjetosDisponiveis[i];
				listaDeObjetosDisponiveis[i] = listaDeObjetosDisponiveis[posMenor];
				listaDeObjetosDisponiveis[posMenor] = aux;
				
			}
		}
	}
	//Oganizes the values according with the relation of value and weight from the bigest to smallest using a selection sort algorithm
	static void selecaoCresRela(Objeto[] listaDeObjetosDisponiveis){
		for(int i = 0; i<listaDeObjetosDisponiveis.length-1; i++){
			int posMenor = i;
			
			for(int p = i+1; p < listaDeObjetosDisponiveis.length; p++){
				if(listaDeObjetosDisponiveis[p].getValor()/listaDeObjetosDisponiveis[p].getPeso()  > listaDeObjetosDisponiveis[posMenor].getValor()/listaDeObjetosDisponiveis[posMenor].getPeso() )
				    posMenor = p;
		    }
			if(listaDeObjetosDisponiveis[posMenor].getValor()/listaDeObjetosDisponiveis[posMenor].getPeso() > listaDeObjetosDisponiveis[i].getValor()/listaDeObjetosDisponiveis[i].getPeso()){
				
				Objeto aux = listaDeObjetosDisponiveis[i];
				listaDeObjetosDisponiveis[i] = listaDeObjetosDisponiveis[posMenor];
				listaDeObjetosDisponiveis[posMenor] = aux;
				
			}
		}
	}
	//Oganizes the values according with their values from the bigest to smallest using a insertion sort algorithm
	static void selecaoOrdenaVal(Objeto[] listaDeObjetosDisponiveis){
		for(int ult = listaDeObjetosDisponiveis.length-1; ult>0; ult--){
			for(int i = 0; i < ult; i++){
				if(listaDeObjetosDisponiveis[i].getPeso() == listaDeObjetosDisponiveis[i+1].getPeso()){
					if(listaDeObjetosDisponiveis[i].getValor() < listaDeObjetosDisponiveis[i+1].getValor()){
						Objeto aux = listaDeObjetosDisponiveis[i];
						listaDeObjetosDisponiveis[i]= listaDeObjetosDisponiveis[i+1];
						listaDeObjetosDisponiveis[i+1] = aux;
					}
				}
			}
		}
	}
	//Oganizes the values according with their weights from the bigest to smallest using a insertion sort algorithm
	static void selecaoOrdenaPeso(Objeto[] listaDeObjetosDisponiveis){
		for(int ult = listaDeObjetosDisponiveis.length-1; ult>0; ult--){
			for(int i = 0; i < ult; i++){
				if(listaDeObjetosDisponiveis[i].getValor()/listaDeObjetosDisponiveis[i].getPeso()  == listaDeObjetosDisponiveis[i+1].getValor()/listaDeObjetosDisponiveis[i+1].getPeso()){
					if(listaDeObjetosDisponiveis[i].getPeso() < listaDeObjetosDisponiveis[i+1].getPeso()){
						Objeto aux = listaDeObjetosDisponiveis[i];
						listaDeObjetosDisponiveis[i]= listaDeObjetosDisponiveis[i+1];
						listaDeObjetosDisponiveis[i+1] = aux;
					}
				}
			}
		}
	}
	

	/*This section is all the main functions 
	for the three methods of ordering the insertion on the bagpack*/


	//This method insert on the bagpack trying to minimizes the weight according with the biggest values
	public static Mochila utilizaMenorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		selecaoCresc(listaDeObjetosDisponiveis);
		selecaoOrdenaVal(listaDeObjetosDisponiveis);

		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		
		double carga = 0;
		double valor = 0;
		int numObjetosNaMochila = 0;
        int i =0;
		

		while(carga<pesoMaximoDaMochila &&i < listaDeObjetosDisponiveis.length-1 ){

            if(  carga >= pesoMaximoDaMochila || i > listaDeObjetosDisponiveis.length-1 ) 
					break;
            
            if( listaDeObjetosDisponiveis[i].getPeso()<= pesoMaximoDaMochila-carga ){
				carga +=listaDeObjetosDisponiveis[i].getPeso();
				valor +=listaDeObjetosDisponiveis[i].getValor();
                numObjetosNaMochila++;
			
                i++;
				
            }else{
				
                break;
            }
			
		}
		mochila.setValorDentroDaMochila(valor);
		mochila.setNumObjetosNaMochila(numObjetosNaMochila);
		mochila.setPesoUsado(carga);
		
		
		return mochila;
	}

	//This method insert on the bagpack trying to maximizes the weight according with the biggest weights 
	
	public static Mochila utilizaMaiorValor(double pesoMaximoDaMochila,	Objeto[] listaDeObjetosDisponiveis) {
		
		selecaoDecresc(listaDeObjetosDisponiveis);
		selecaoOrdenaVal(listaDeObjetosDisponiveis);
		
		Mochila mochila = new Mochila(pesoMaximoDaMochila);


		double carga = 0;
		double valor = 0;
		int numObjetosNaMochila = 0;
        int i =0;

		while(carga<pesoMaximoDaMochila &&i < listaDeObjetosDisponiveis.length-1 ){

            if( listaDeObjetosDisponiveis[i].getPeso()<= pesoMaximoDaMochila-carga ){
				carga +=listaDeObjetosDisponiveis[i].getPeso();
				valor +=listaDeObjetosDisponiveis[i].getValor();
                numObjetosNaMochila++;
			
                
				
            }else if(  carga >= pesoMaximoDaMochila || i > listaDeObjetosDisponiveis.length-1 ) {
                break;
            }
			i++;
		}
		mochila.setValorDentroDaMochila(valor);
		mochila.setNumObjetosNaMochila(numObjetosNaMochila);
		mochila.setPesoUsado(carga);
		
		return mochila;
	}

	//This method insert on the bagpack according value/weight  
	
	public static Mochila utilizaMaiorValorDivididoPorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {

		selecaoCresRela(listaDeObjetosDisponiveis);
		selecaoOrdenaPeso(listaDeObjetosDisponiveis);

		Mochila mochila = new Mochila(pesoMaximoDaMochila);

		

		double carga = 0;
		double valor = 0;
		int numObjetosNaMochila = 0;
        int i =0;

		while(carga<pesoMaximoDaMochila &&i < listaDeObjetosDisponiveis.length-1 ){

            if( listaDeObjetosDisponiveis[i].getPeso()<= pesoMaximoDaMochila-carga ){
				carga +=listaDeObjetosDisponiveis[i].getPeso();
				valor +=listaDeObjetosDisponiveis[i].getValor();
                numObjetosNaMochila++;
			
                
				
            }else if(  carga >= pesoMaximoDaMochila || i > listaDeObjetosDisponiveis.length-1 ) {
                break;
            }
			i++;
		}
		mochila.setValorDentroDaMochila(valor);
		mochila.setNumObjetosNaMochila(numObjetosNaMochila);
		mochila.setPesoUsado(carga);

		return mochila;
	}

	
}
