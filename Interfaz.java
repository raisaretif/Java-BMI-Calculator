import javax.swing.*;
import java.awt.*;

public class Interfaz extends Frame {

    //Labels
    JLabel etiquetaNombre;
    JLabel etiquetaSexo;
    JLabel etiquetaEstatura;
    JLabel etiquetaPeso;
    JLabel etiquetaIMC;
    JLabel etiquetaNivelIMC;

    //TextFields
    JTextField textoNombre;
    JTextField textoEstatura;
    JTextField textoPeso;
    JTextField textoIMC;
    JTextField textoNivelIMC;

    //Botones
    JButton botonCalculoIMC;
    JButton botonNuevoPerfil;
    JButton botonGuardarPerfil;

    //Opciones
    JComboBox comboBoxSexo;

    //Font
    Font font;

    // Singleton
    private static Interfaz interfaz;
    public static Interfaz getInterfaz() {
        if (interfaz == null) interfaz = new Interfaz();
        return interfaz;
    }

    private Interfaz() {
        setTitle("Calculadora de IMC");
        setBounds(400,100,700,700);
        setBackground(new Color(180, 215, 191));
        setLayout(null);
        construyeComponentes();
    }

    private void construyeComponentes(){

        //Font
        font = new Font("SansSerif", Font.BOLD, 30);

        //Labels
        etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setFont(font);
        etiquetaNombre.setBounds(10, 40, 400, 50);
        add(etiquetaNombre);
        etiquetaSexo = new JLabel("Sexo:");
        etiquetaSexo.setFont(font);
        etiquetaSexo.setBounds(10, 90, 400, 50);
        add(etiquetaSexo);
        etiquetaEstatura = new JLabel("Estatura:             cm");
        etiquetaEstatura.setFont(font);
        etiquetaEstatura.setBounds(10, 140, 400, 50);
        add(etiquetaEstatura);
        etiquetaPeso = new JLabel("Peso:             kg");
        etiquetaPeso.setFont(font);
        etiquetaPeso.setBounds(10,200,400,50);
        add(etiquetaPeso);
        etiquetaIMC = new JLabel("IMC:");
        etiquetaIMC.setFont(font);
        etiquetaIMC.setBounds(10,450,400,50);
        add(etiquetaIMC);
        etiquetaNivelIMC = new JLabel("Nivel de IMC:");
        etiquetaNivelIMC.setFont(font);
        etiquetaNivelIMC.setBounds(260,450,400,50);
        add(etiquetaNivelIMC);

        //TextFields
        textoNombre = new JTextField("");
        textoNombre.setBounds(160,40,400,40);
        add(textoNombre);
        textoEstatura = new JTextField("");
        textoEstatura.setBounds(170,140,110,40);
        add(textoEstatura);
        textoPeso = new JTextField("");
        textoPeso.setBounds(110,200,110,40);
        add(textoPeso);
        textoIMC = new JTextField("");
        textoIMC.setEditable(false);
        textoIMC.setBounds(110,450,130,40);
        add(textoIMC);
        textoNivelIMC = new JTextField("");
        textoNivelIMC.setEditable(false);
        textoNivelIMC.setBounds(500,450,130,40);
        add(textoNivelIMC);

        //Botones
        botonCalculoIMC = new JButton("Calcular Índice de Masa Corporal");
        botonCalculoIMC.setBounds(150,280,400,125);
        add(botonCalculoIMC);
        botonNuevoPerfil = new JButton("Nuevo Perfil");
        botonNuevoPerfil.setBounds(110,550,200,50);
        add(botonNuevoPerfil);
        botonGuardarPerfil = new JButton("Guardar Perfil");
        botonGuardarPerfil.setBounds(400,550,200,50);
        add(botonGuardarPerfil);

        //Opciones
        String[] opcionesSexo = {"Masculino", "Femenino"};
        comboBoxSexo = new JComboBox(opcionesSexo);
        comboBoxSexo.setBounds(115,90,120,40);
        add(comboBoxSexo);
    }

    private void setActionListener(Mediador aController){
        botonCalculoIMC.addActionListener(aController);
        botonGuardarPerfil.addActionListener(aController);
        botonNuevoPerfil.addActionListener(aController);
        textoNombre.addActionListener(aController);
        comboBoxSexo.addActionListener(aController);
        textoEstatura.addActionListener(aController);
        textoPeso.addActionListener(aController);
    }


    public void inicia(Mediador aController) {
        setActionListener(aController);
        setVisible(true);
    }
}