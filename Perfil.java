
public class Perfil{

    String nombre;
    int peso;
    int sexo;
    int estatura;

    public int getEstatura(){
        return estatura;
    }

    public int getPeso(){
        return peso;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSexo() {
        if (sexo == 1){
            return "Masculino";
        }
        else if (sexo == 2){
            return "Femenino";
        }
        else return "0";
    }

    public void setNombre(String aNombre){
        nombre = aNombre;
    }


    public void setEstatura(int aEstatura){
        if((aEstatura >=140)&&(aEstatura<=200)){
            estatura = aEstatura;
        }
    }

    public void setPeso(int aPeso){
        if((aPeso>=20)&&(aPeso<=200)){
            peso = aPeso;
        }
    }

    private Perfil(String aNombre, int aSexo,int aEstatura,int aPeso){
        super();
        setNombre(aNombre);
        sexo = aSexo;
        setEstatura(aEstatura);
        setPeso(aPeso);
    }

    //Factory Method
    public static Perfil makeMan(String aNombre, int aEstatura, int aPeso) {
        return new Perfil(aNombre, 1, aEstatura, aPeso);
    }
    public static Perfil makeWoman(String aNombre, int aEstatura, int aPeso) {
        return new Perfil(aNombre, 2, aEstatura, aPeso);
    }
    public static Perfil makeSomething(String aNombre, int aEstatura, int aPeso) {
        return new Perfil(aNombre, 0, aEstatura, aPeso);
    }

}