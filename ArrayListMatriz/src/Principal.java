import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Principal {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

 
		ArrayList<mazoDeCartas> arrayMazo = new ArrayList<mazoDeCartas>();
		
		int quienEsMano=0;
		//creacion del mazo
		
		llenarArray(arrayMazo," de Basto");
		llenarArray(arrayMazo," de Oro");
		llenarArray(arrayMazo," de Espada");
		llenarArray(arrayMazo," de Copa");
		asignarValores(arrayMazo);
	//	Collections.shuffle(arrayMazo);
		//puntos
		

		
		
//		mazoDeCartas cartaTest0 = new mazoDeCartas(11," de Espada",9);
//		mazoDeCartas cartaTest1 = new mazoDeCartas(10," de Espada",9);
//		mazoDeCartas cartaTest2 = new mazoDeCartas(6," de Espada", 7);
//		
//		mazoDeCartas cartaTest3= new mazoDeCartas(2," de Copa",9);
//		mazoDeCartas cartaTest4 = new mazoDeCartas(2," de Oro", 9);
//		mazoDeCartas cartaTest5 = new mazoDeCartas(12," de Basto", 7);
//		
//		
//		
//		mazoDeCartas cartaTest6 = new mazoDeCartas(12,"de XD", 7);

		
		Manos manoPar1 = new Manos("player1",arrayMazo.get(0),arrayMazo.get(2),arrayMazo.get(4),0);
		Manos manoImpar1 = new Manos("player2",arrayMazo.get(1), arrayMazo.get(3), arrayMazo.get(5),1);
		
//		Manos manoTest = new Manos("player3",cartaTest0,cartaTest1,cartaTest2,0);
//		Manos manoTest1 = new Manos("player4",cartaTest3,cartaTest4,cartaTest5,1);
//		
		
		

		
//		System.out.println("Mano Par");
//		manoPar1.mostrarMano();
//		System.out.println("Mano Impar");
//		manoImpar1.mostrarMano();
		

//		
	//	jugar(manoPar1,manoImpar1);
		
		
		while(manoPar1.getPuntos()<30 && manoImpar1.getPuntos()<30)
		{
			
		Collections.shuffle(arrayMazo);
		
		manoPar1.setCarta0(arrayMazo.get(0));
		manoPar1.setCarta1(arrayMazo.get(2));
		manoPar1.setCarta2(arrayMazo.get(4));
		
		manoPar1.agregarAlArray();
		
		manoImpar1.setCarta0(arrayMazo.get(1));
		manoImpar1.setCarta1(arrayMazo.get(3));
		manoImpar1.setCarta2(arrayMazo.get(5));
		
		manoImpar1.agregarAlArray();
		int decidir=0;
		if(decidir%2==0)
		{
			jugar(manoPar1,manoImpar1);
			
		}
		else
		{
			jugar(manoImpar1,manoPar1);
		}
		decidir++;
		manoPar1.setEsMano(manoPar1.getEsMano()+1);
		manoImpar1.setEsMano(manoImpar1.getEsMano()+1);
		
		for(int i=0;i<3;i++)
		{
			manoPar1.arrayMano.get(i).setFueJugada(false);
			manoImpar1.arrayMano.get(i).setFueJugada(false);
		}
		
		}
		
		


	//	jugar(manoPar1,manoImpar1);
		
		
		
//	System.out.println();
//		for (int contador=0;contador<manoPar1.arrayMano.size();contador++)
//		{
//			System.out.println(manoPar1.arrayMano.get(contador).Devolver());
//		}
		
		
			
		
		
		
		
		//VER MAZO
//	for(int i=0;i<arrayMazo.size();i++)
//		{
//			System.out.println(arrayMazo.get(i).Devolver());
//		}
//	
//		
		System.exit(0);


	}

public static void jugar(Manos manoPar1, Manos manoImpar1)
{
	
	int jugadaPar;
	int jugadaImpar;
	int rondasPar=0;
	int rondasImpar=0;
	boolean esParda=false;
	boolean dobleParda=false;
	String canto="asdasd";
	boolean envidoDone=false;
	boolean trucoNoQuerido=false;
	int trucoPuntos=1;
	boolean trucoCantado=false;
	boolean reTrucoCantado=false;
	boolean valeCuatroCantado=false;
	boolean parTieneElQuiero=false;
	
	
	
	
	Scanner scan = new Scanner(System.in);

	
	
	
	
	System.out.println(manoPar1.getNombre());
	manoPar1.mostrarMano();
	System.out.println(manoImpar1.getNombre());
	manoImpar1.mostrarMano();

	while(rondasPar<2 && rondasImpar<2 && trucoNoQuerido==false)
	{
	//ENVIDO PAR
		
		if(rondasPar==0 && rondasImpar==0)
		{
			System.out.println("queres cantar envido");
			
			canto=scan.nextLine();
			if(canto.contentEquals("envido") || canto.contentEquals("real envido") || canto.contentEquals("falta envido"))
			{
			Cantar.envido(manoPar1, manoImpar1,canto);
			envidoDone=true;
			}
		}
	while(true)
	{
		
		
			//JUGADA PAR
		System.out.println("canta o juga");
		while(true)
		{
			

			canto=scan.nextLine();
		
			
			//TRUCO
		if(canto.contentEquals("truco") && trucoCantado==false)
		{
			trucoPuntos++;
			canto=Responder();
			if(canto.contentEquals("quiero"))
			{
				System.out.println("juga tu carta");
				envidoDone=true;
				trucoCantado=true;

			}
			if(canto.contentEquals("no quiero"))
			{
				System.out.println("no querido");

				aplicarPuntosNoQuerido(trucoPuntos,parTieneElQuiero,manoPar1,manoImpar1);
				return;
				
			}
			

			canto=scan.nextLine();
			
		}
		//RETRUCO
		if(canto.contentEquals("quiero retruco") && trucoCantado==true && reTrucoCantado==false)
		{
			System.out.println("te cantaron retruco");
			parTieneElQuiero=!parTieneElQuiero;
			trucoPuntos++;
			canto=Responder();
			if(canto.contentEquals("quiero"))
			{
				System.out.println("juga entonces");
				reTrucoCantado=true;

			}
			if(canto.contentEquals("no quiero"))
			{
				System.out.println("no querido");				

				aplicarPuntosNoQuerido(trucoPuntos,parTieneElQuiero,manoPar1,manoImpar1);
				return;
				
			}
			
			canto=scan.nextLine();
			
			
		}	
		//VALE CUATRO
		if(canto.contentEquals("quiero vale cuatro") && trucoCantado==true && reTrucoCantado==true && valeCuatroCantado==false)
		{
			System.out.println("te cantaron vale cuatro");
			parTieneElQuiero=!parTieneElQuiero;
			trucoPuntos++;
			canto=Responder();
			if(canto.contentEquals("quiero"))
			{
				System.out.println("juga");
				valeCuatroCantado=true;

				
			}
			if(canto.contentEquals("no quiero"))
			{
				System.out.println("no querido");
				aplicarPuntosNoQuerido(trucoPuntos,parTieneElQuiero,manoPar1,manoImpar1);
				return;
			}
			
			canto=scan.nextLine();
			
		}

		
		if(canto.contentEquals("0") || canto.contentEquals("1") || canto.contentEquals("2"))
		{

		jugadaPar=Integer.parseInt(canto);
		break;
		}
		else
		{
			System.out.println("jugada invalida");
		}
		}
		
		if(manoPar1.arrayMano.get(jugadaPar).isFueJugada()==true)
		{
			System.out.println("esa carta ya fue jugada");
		}
		else
		{
			manoPar1.arrayMano.get(jugadaPar).setFueJugada(true);
			System.out.println("el jugador par juega la carta: " +manoPar1.arrayMano.get(jugadaPar).getNumero() + manoPar1.arrayMano.get(jugadaPar).getNombre());
			break;
		}
	}
	
	if (rondasPar==0 && rondasImpar==0 && envidoDone==false)
	{
		System.out.println("queres cantar envido");

		canto=scan.nextLine();
		if(canto.contentEquals("envido") || canto.contentEquals("real envido") || canto.contentEquals("falta envido"))
		{
		Cantar.envido(manoImpar1,manoPar1,canto);
		envidoDone=true;
		}

	}
	//pedir jugada impar	
	while(true)
	{

		System.out.println("canta o juga");

		while(true)
		{
			
			canto=scan.nextLine();
			
			//TRUCO
			if(canto.contentEquals("truco") & trucoCantado==false)
			{
				parTieneElQuiero=true;
				trucoPuntos++;
				canto=Responder();
				if(canto.contentEquals("quiero"))
				{
					System.out.println("juga tu carta");
					envidoDone=true;
					trucoCantado=true;
				}
				if(canto.contentEquals("no quiero"))
				{
					System.out.println("no querido");
					aplicarPuntosNoQuerido(trucoPuntos,parTieneElQuiero,manoPar1,manoImpar1);
					return;
				}
				canto=scan.nextLine();
				
			}
			
			//RETRUCO
			if(canto.contentEquals("quiero retruco") && trucoCantado==true && reTrucoCantado==false)
			{
				parTieneElQuiero=!parTieneElQuiero;
				trucoPuntos++;
				canto=Responder();
				if(canto.contentEquals("quiero"))
				{
					System.out.println("juga tu carta");
					reTrucoCantado=true;
				}
				if(canto.contentEquals("no quiero"))
				{
					System.out.println("no querido");
					aplicarPuntosNoQuerido(trucoPuntos,parTieneElQuiero,manoPar1,manoImpar1);
					return;
				}
				
				canto=scan.nextLine();
			}
			
			// VALE CUATRO
			if(canto.contentEquals("quiero vale cuatro") && trucoCantado==true && reTrucoCantado==true && valeCuatroCantado==false)
			{
				parTieneElQuiero=!parTieneElQuiero;
				trucoPuntos++;
				canto=Responder();
				if(canto.contentEquals("quiero"))
				{
					System.out.println("juga entonces");
					valeCuatroCantado=true;
				}
				if(canto.contentEquals("no quiero"))
				{
					System.out.println("no QUERido");
					aplicarPuntosNoQuerido(trucoPuntos,parTieneElQuiero,manoPar1,manoImpar1);
					return;
				}
				
				canto=scan.nextLine();
			
			}
			
			
			
			
			
			
			
			
			if(canto.contentEquals("0") || canto.contentEquals("1") || canto.contentEquals("2"))
			{

			jugadaImpar=Integer.parseInt(canto);
			break;
			}
			else
			{
				System.out.println("jugada invalida");
			}
			
		}

		
		if(manoImpar1.arrayMano.get(jugadaImpar).isFueJugada()==true)
		{
			System.out.println("esa carta ya fue jugada");
		}
		else
		{ 
			manoImpar1.arrayMano.get(jugadaImpar).setFueJugada(true);
			System.out.println(manoImpar1.getNombre()+" juega la carta: " +manoImpar1.arrayMano.get(jugadaImpar).getNumero() + manoImpar1.arrayMano.get(jugadaImpar).getNombre());
			break;
		}
	}
		
		
		if (dobleParda==true){
			if(manoPar1.arrayMano.get(jugadaPar).getValor() > manoImpar1.arrayMano.get(jugadaImpar).getValor())
			{
				System.out.println(manoPar1.getNombre()+" gana la ronda: ");
				rondasPar++;
			}
			else if	(manoPar1.arrayMano.get(jugadaPar).getValor() < manoImpar1.arrayMano.get(jugadaImpar).getValor())
			{
				System.out.println(manoImpar1.getNombre()+ " gana la ronda: ");
				rondasImpar++;	
			}
			else
			{
				System.out.println("triple parda, gana el jugador que fue mano");
				if(manoPar1.esMano%2==0)
				{
					rondasPar++;
				}
				else
				{
					rondasImpar++;
				}
			}
			
		}
		
		
		
		else if(esParda==true) {
			if(manoPar1.arrayMano.get(jugadaPar).getValor() > manoImpar1.arrayMano.get(jugadaImpar).getValor())
			{
				System.out.println(manoPar1.getNombre()+" gana la ronda: ");
				rondasPar++;
			}
			else if	(manoPar1.arrayMano.get(jugadaPar).getValor() < manoImpar1.arrayMano.get(jugadaImpar).getValor())
			{
				System.out.println(manoImpar1.getNombre()+ " gana la ronda: ");
				rondasImpar++;	
			}
			else {
				System.out.println("doble empate");
				dobleParda=true;
				
				
				
			}
			
			
		}
		else 
		{
			
		
		//quien gana
		if(manoPar1.arrayMano.get(jugadaPar).getValor() > manoImpar1.arrayMano.get(jugadaImpar).getValor())
		{
			System.out.println(manoPar1.getNombre()+ " gana la ronda: ");
			rondasPar++;
		}
		else if	(manoPar1.arrayMano.get(jugadaPar).getValor() < manoImpar1.arrayMano.get(jugadaImpar).getValor())
		{
			System.out.println(manoImpar1.getNombre()+" gana la ronda: ");
			rondasImpar++;			
		}
		else {
			
			System.out.println("Parda");	
			esParda=true;
			rondasPar++;
			rondasImpar++;
		}
		}

			
				
	
			
	

	
	}
	System.out.println("termine");
	
	if(rondasPar>rondasImpar)
	{
		manoPar1.aplicarPuntos(trucoPuntos);
	}
	else {
		manoImpar1.aplicarPuntos(trucoPuntos);
	}
	
	System.out.println(manoPar1.getNombre()+ " puntaje: " +manoPar1.getPuntos());
	System.out.println(manoImpar1.getNombre()+ " puntaje: "+ manoImpar1.getPuntos());
	
	
	
	
	

	
	

	
}


public static void aplicarPuntosNoQuerido(int trucoPuntos,boolean parTieneElQuiero, Manos manoPar1, Manos manoImpar1)
{
	if(parTieneElQuiero==true)
	{
		manoImpar1.aplicarPuntos(trucoPuntos-1);
	}
	else
	{
		manoPar1.aplicarPuntos(trucoPuntos-1);
	}
}


public static String Responder()
{
	String canto="AAAA_AAAAA";
	Scanner scan = new Scanner(System.in);
	while(!canto.contentEquals("quiero") && !canto.contentEquals("no quiero"))
	{
		System.out.println("Responde quiero o no quiero");
		canto=scan.nextLine();
		
	}
	return canto;
}


public static void llenarArray(ArrayList arrayMazo, String palo) 
{
int valorDefault=-500;
for (int i=1;i<13;i++) {
		
	if (i==8)
	{
		i=10;
	}
		arrayMazo.add(new mazoDeCartas(i,palo,valorDefault));
		
		
	}
	

}

public static void asignarValores(ArrayList<mazoDeCartas> arrayMazo)
{
	// 4
	arrayMazo.get(3).setValor(1);
	arrayMazo.get(13).setValor(1);
	arrayMazo.get(23).setValor(1);
	arrayMazo.get(33).setValor(1);
	// 5
	arrayMazo.get(4).setValor(2);
	arrayMazo.get(14).setValor(2);
	arrayMazo.get(24).setValor(2);
	arrayMazo.get(34).setValor(2);
	// 6
	arrayMazo.get(5).setValor(3);
	arrayMazo.get(15).setValor(3);
	arrayMazo.get(25).setValor(3);
	arrayMazo.get(35).setValor(3);
	// 7 malos
	arrayMazo.get(6).setValor(4);
	arrayMazo.get(36).setValor(4);
	// sotas
	arrayMazo.get(7).setValor(5);
	arrayMazo.get(17).setValor(5);
	arrayMazo.get(27).setValor(5);
	arrayMazo.get(37).setValor(5);
	// caballos
	arrayMazo.get(8).setValor(6);
	arrayMazo.get(18).setValor(6);
	arrayMazo.get(28).setValor(6);
	arrayMazo.get(38).setValor(6);
	// reyes
	arrayMazo.get(9).setValor(7);
	arrayMazo.get(19).setValor(7);
	arrayMazo.get(29).setValor(7);
	arrayMazo.get(39).setValor(7);
	// anchos falsos
	arrayMazo.get(10).setValor(8);
	arrayMazo.get(30).setValor(8);
	// 2
	arrayMazo.get(1).setValor(9);
	arrayMazo.get(11).setValor(9);
	arrayMazo.get(21).setValor(9);
	arrayMazo.get(31).setValor(9);
	// 3
	arrayMazo.get(2).setValor(10);
	arrayMazo.get(12).setValor(10);
	arrayMazo.get(22).setValor(10);
	arrayMazo.get(32).setValor(10);
	// 7 de oro
	arrayMazo.get(16).setValor(11);
	// 7 de espada
	arrayMazo.get(26).setValor(12);
	// ancho de basto
	arrayMazo.get(0).setValor(13);
	// ancho de espada
	arrayMazo.get(20).setValor(14);
	//System.out.println("valores asignados");
}

}


