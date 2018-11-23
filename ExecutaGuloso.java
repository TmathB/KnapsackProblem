import ep2.*;

/**
	Class used to test the implemented algorithms.

*/
public class ExecutaGuloso {
	/**
		Hare you can put your tests 
	**/
	public static void main(String[] args) {
		Objeto[] listaDeObjetos = new Objeto[7];
		listaDeObjetos[0] = new Objeto(7,7);
		listaDeObjetos[1] = new Objeto(4,6);
		listaDeObjetos[2] = new Objeto(3,6);
		listaDeObjetos[3] = new Objeto(2,3);
		listaDeObjetos[4] = new Objeto(2,4);
		listaDeObjetos[5] = new Objeto(1,1);
		listaDeObjetos[6] = new Objeto(2,1);
		
		System.out.println("Testing Selection by : 'Small Value'");
		Mochila mochila = MetodosGulosos.utilizaMenorPeso(9, listaDeObjetos);
		mochila.imprimirDados();
		
		
		listaDeObjetos = new Objeto[7];
		listaDeObjetos[0] = new Objeto(7,7);
		listaDeObjetos[1] = new Objeto(4,6);
		listaDeObjetos[2] = new Objeto(3,6);
		listaDeObjetos[3] = new Objeto(2,3);
		listaDeObjetos[4] = new Objeto(2,4);
		listaDeObjetos[5] = new Objeto(1,1);
		listaDeObjetos[6] = new Objeto(2,1);
		
		
		System.out.println();
		System.out.println("Testing Selection by: 'Bigest Value'");
		mochila = MetodosGulosos.utilizaMaiorValor(9, listaDeObjetos);
		mochila.imprimirDados();
		
		listaDeObjetos = new Objeto[7];
		listaDeObjetos[0] = new Objeto(7,7);
		listaDeObjetos[1] = new Objeto(4,6);
		listaDeObjetos[2] = new Objeto(3,6);
		listaDeObjetos[3] = new Objeto(2,3);
		listaDeObjetos[4] = new Objeto(2,4);
		listaDeObjetos[5] = new Objeto(1,1);
		listaDeObjetos[6] = new Objeto(2,1);
		
		System.out.println();
		System.out.println("Testing Selection by: 'Relation between Bigest value / Bigest Weight'");
		mochila = MetodosGulosos.utilizaMaiorValorDivididoPorPeso(9, listaDeObjetos);
		mochila.imprimirDados();
		/**/
		
	}
}
