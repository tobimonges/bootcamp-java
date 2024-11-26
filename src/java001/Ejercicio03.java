package java001;

public class Ejercicio03 {
    protected String nombre = "Tobias";

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        Ejercicio03 ejercicio3 = new Ejercicio03();
        System.out.println("Bienvenido " + ejercicio3.getNombre());
    }
}
