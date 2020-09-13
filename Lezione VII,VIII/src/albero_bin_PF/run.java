package albero_bin_PF;
import java.util.*;

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlberoBinPF<String> T=new AlberoBinPF<String>();
		
		
		NodoBinPF<String> R=T.aggiungiRadice("Pippo");	
		
		System.out.println("Foglie="+T.numFoglie());

		NodoBinPF<String> pippone =T.aggiungiFiglioSin(R,"pippone");
		
//		System.out.println(T.altezza());
		
		NodoBinPF<String> pippetto=T.aggiungiFiglioDes(R,"pippetto");
		
//		System.out.println(T.altezza());
		
		NodoBinPF<String> pluto=T.aggiungiFiglioDes(pippone, "pluto");
		System.out.println("Foglie="+T.numFoglie());

		System.out.println(T.altezza());
		System.out.println(T.livello(pluto));
		System.out.println(R.getSin().toString());
		System.out.println("Altezza: "+T.altezza_());
		NodoBinPF<String> carlo=T.aggiungiFiglioSin(pippone, "carlo");
		System.out.println("Foglie="+T.numFoglie());

		NodoBinPF<String> lapo=T.aggiungiFiglioDes(carlo, "lapo");		
		System.out.println("Foglie="+T.numFoglie());
		
		System.out.println("Livello:"+ R.livello());
		
		T.aggiungiFiglioSin(pippetto, "Luca");
		System.out.println("Foglie="+T.numFoglie());
		
		T.aggiungiFiglioDes(pluto, "Gino");
		System.out.println("Foglie="+T.numFoglie());
		
		System.out.println("Foglie: "+T.contaFoglie(R));
		
		LinkedList<String> VA=T.innesco_visita("anticipata");
		System.out.println(VA.toString());
		
		System.out.println(T.visitaDFS().toString());

		System.out.println(T.toString());
		System.out.println(T.toString ());
		System.out.println("Altezza: "+T.altezza_());
		
		System.out.println(pippone.getDes());
		
		System.out.println("Foglie="+T.numFoglie());
	
	
		
	////////////////////////////////////
		
/*		AlberoBinPF<String> T=new AlberoBinPF<String>();
		System.out.println("Foglie="+T.numFoglie());

		NodoBinPF<String> Ruggero=T.aggiungiRadice("Ruggero");
		System.out.println("Foglie="+T.numFoglie());
		
		NodoBinPF<String> Giancarlo=T.aggiungiFiglioSin(Ruggero,"Giancarlo");
		System.out.println("Foglie="+T.numFoglie());
		
		NodoBinPF<String> Rosanna=T.aggiungiFiglioDes(Ruggero,"Rosanna");
		System.out.println("Foglie="+T.numFoglie());
		
		NodoBinPF<String> Lorenzo=T.aggiungiFiglioSin(Giancarlo,"Lorenzo");
		System.out.println("Foglie="+T.numFoglie());

		NodoBinPF<String> Antonio=T.aggiungiFiglioDes(Giancarlo,"Antonio");
		System.out.println("Foglie="+T.numFoglie());
		
*/	}
}

