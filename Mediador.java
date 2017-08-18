import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Mediador implements ActionListener {

    EstructuraDeDatos model;
    Interfaz view;

    public Mediador(EstructuraDeDatos aModel, Interfaz aView){

        model = aModel;
        view = aView;
    }

    public Perfil obtieneDatosDelView(){
        Perfil dato;
        String nombre;
        String sexo;
        String textoPeso;
        String textoEstatura;
        Integer objetoInt;
        int peso;
        int estatura;

        nombre = view.textoNombre.getText();
        sexo = (String) view.comboBoxSexo.getSelectedItem();
        textoPeso = view.textoPeso.getText();
        textoEstatura = view.textoEstatura.getText();

        objetoInt = new Integer(textoPeso);
        peso = objetoInt.intValue();
        objetoInt = new Integer(textoEstatura);
        estatura = objetoInt.intValue();

        if (sexo.equals("Masculino"))
            dato = Perfil.makeMan(nombre, estatura, peso);
        else if (sexo.equals("Femenino"))
            dato = Perfil.makeWoman(nombre, estatura, peso);
        else dato = Perfil.makeSomething(nombre, estatura, peso);
        return dato;
    }

    public void limpiaInterfaz(){
        view.textoNombre.setText("");
        view.textoPeso.setText("");
        view.textoEstatura.setText("");
        view.textoIMC.setText("");
        view.textoNivelIMC.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        JButton botonAccionado;
        model = new EstructuraDeDatos(obtieneDatosDelView());
        botonAccionado = (JButton) evento.getSource();
        if(botonAccionado==view.botonCalculoIMC){
            String[] imc = model.getIMC();
            view.textoIMC.setText(imc[0]);
            view.textoNivelIMC.setText(imc[1]);
        }
        if(botonAccionado==view.botonNuevoPerfil){
            limpiaInterfaz();
        }
        if(botonAccionado==view.botonGuardarPerfil){
            try {
                guardarPerfil();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void guardarPerfil() throws IOException {
        model.archivarPerfil();
    }
}