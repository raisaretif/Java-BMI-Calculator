import java.io.*;
import java.util.Vector;

public class EstructuraDeDatos {

    UdlapSequentialFile repositorio;
    Perfil perf;

    public EstructuraDeDatos(Perfil p) {
        perf = p;
    }

    public void archivarPerfil() throws IOException {

        String nombre;
        String sexo;
        int estatura;
        int peso;
        repositorio = new UdlapSequentialFile("/home/raisa/Escritorio/ModelViewController_IMC/src","archivo","txt");
        repositorio.create();

        nombre = perf.getNombre();
        sexo = perf.getSexo();
        estatura = perf.getEstatura();
        peso = perf.getPeso();

        repositorio.writeString("Nombre: ");
        repositorio.writeString(nombre);
        repositorio.writeString("Sexo: ");
        repositorio.writeString(sexo);
        repositorio.writeString("Estatura: ");
        repositorio.writeInt(estatura);
        repositorio.writeString("Peso: ");
        repositorio.writeInt(peso);
    }

    public String[] getIMC() {

        int peso = perf.getPeso();
        double estatura = perf.getEstatura()/100.0;
        double imc = peso/(estatura*estatura);
        imc = Math.round(imc * 100);
        imc = imc/100;
        String imcTexto = Double.toString(imc);

        String nivel = "";
        if (imc < 18) nivel = "Peso bajo";
        else if (imc < 25) nivel = "Normal";
        else if (imc < 27) nivel = "Sobrepeso";
        else if (imc < 30) nivel = "Obesidad, grado I";
        else if (imc < 40) nivel = "Obesidad, grado II";
        else if (imc >= 40) nivel = "Obesidad, grado III";

        String[] calculoIMC = {imcTexto,nivel};
        return calculoIMC;
    }
}
