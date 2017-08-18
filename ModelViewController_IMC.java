import java.io.IOException;

public class ModelViewController_IMC {

    public static void main(String[] args) throws IOException {

        Interfaz view;
        EstructuraDeDatos model;
        Mediador controller;

        model = new EstructuraDeDatos(null);
        view = Interfaz.getInterfaz();
        controller = new Mediador(model, view);
        view.inicia(controller);
    }
}