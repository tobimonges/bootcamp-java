package ejercicios.semana01;

public class Docente {
    private int codigo;
    private String nombre;
    private int horasTrabajadas;
    private double tarifa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public Docente(int codigo, String nombre, int horasTrabajadas, double tarifa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifa = tarifa;
    }
    public Docente() {
    }
    public double sueldoBruto() {
        return this.getHorasTrabajadas() * this.getTarifa();
    }
    public int descuento() {
        double sueldo = sueldoBruto();
        if (sueldo < 4500) {
            return 12;
        } else if (sueldo >= 6500) {
            return 16;
        }
        return 14;
    }
    public double sueldoNeto() {
        return sueldoBruto() - (sueldoBruto() * descuento() / 100);
    }

    @Override
    public String toString() {
        return "Docente{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", tarifa=" + tarifa +
                '}' +
                "\nSueldo Bruto: " + sueldoBruto() +
                "\nDescuento: " + descuento() + "%" +
                "\nSueldo Neto: " + sueldoNeto();
    }

    public static void main(String[] args) {
        Docente docente01 = new Docente(5378317,"Tobias",8,900);
        System.out.println(docente01.toString());
    }
}
