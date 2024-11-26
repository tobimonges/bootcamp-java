package ejercicios.semana01;

import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private float estatura;
    private float peso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Persona(String nombre, String apellido, int edad, float estatura, float peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.estatura = estatura;
        this.peso = peso;
    }

    public Persona() {
    }
    public String estadoPersona() {
        return  (getEdad() >= 18 ? "Mayor de edad" : "Menor de edad");
    }
    public float masaCorporal() {
        return (getPeso() / getEstatura() / getEstatura());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", estatura=" + estatura +
                ", peso=" + peso +
                ", estado=" + estadoPersona() +
                ", masa corporal=" + masaCorporal() +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona01 = new Persona();
        System.out.print("Nombre: ");
        persona01.setNombre(scanner.nextLine());
        System.out.print("Apellido: ");
        persona01.setApellido(scanner.nextLine());
        System.out.print("Edad: ");
        persona01.setEdad(scanner.nextInt());
        System.out.print("Estatura: ");
        persona01.setEstatura(scanner.nextFloat());
        System.out.print("Peso: ");
        persona01.setPeso(scanner.nextFloat());
        System.out.println(persona01);
    }
}
