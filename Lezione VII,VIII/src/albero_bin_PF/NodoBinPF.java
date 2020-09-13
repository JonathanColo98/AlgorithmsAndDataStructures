package albero_bin_PF;


public class NodoBinPF<T> {

//	Si mantiene un puntatore a ciascun figlio e al padre.
	private T info;
	private NodoBinPF<T> sin,padre,des;


	//costruttore	
	public NodoBinPF(T x){
		info=x;
	}
	
//	Accessori
	
        public T getInfo(){
                return info;
        }
	
	public NodoBinPF<T> getSin(){
		return sin;
	}
	
	public NodoBinPF<T> getDes(){
		return des;
	}
	
	public NodoBinPF<T> getPadre(){
		return padre;
	}
	
//	Mutatori
	
	public void setInfo(T x){
                info=x;
        }

	public void setSin(NodoBinPF<T> v){
		sin=v;
	}
	
	public void setDes(NodoBinPF<T> v){
		des=v;
	}
	
	public void setPadre(NodoBinPF<T> v){
		padre=v;
	}
	

/////////////////////////////////////////
	
	public String toString(){
		return info.toString();
	}

	public int livello(){
		int livello=0;
		NodoBinPF<T> temp=this.getPadre();
		while(temp!=null){
			livello++;
			temp=temp.getPadre();
		}
		return livello;
	
	}
}