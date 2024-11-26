package ejercicios.semana01;

public class Reloj {
    private int hora;
    private int minuto;
    private int segundo;

    public Reloj() {
        this.hora = 12;
        this.minuto = 0;
        this.segundo = 0;
    }

    public Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    public Reloj(int segundo) {
        relojHoras(segundo);
    }

    public void setReloj(int segundo) {
        Reloj reloj = new Reloj(segundo);
        this.hora = reloj.hora;
        this.minuto = reloj.minuto;
        this.segundo = reloj.segundo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public void tick() {
        this.segundo++;
        if (this.segundo == 60) {
            this.segundo = 0;
            this.minuto++;
            if (this.minuto == 60) {
                this.minuto = 0;
                this.hora++;
                if (this.hora == 24) {
                    this.hora = 0;
                }
            }
        }
    }
    public void tickDecrement() {
        this.segundo--;
        if (this.segundo == -1) {
            this.segundo = 59;
            this.minuto--;
            if (this.minuto == -1) {
                this.minuto = 59;
                this.hora--;
                if (this.hora == -1) {
                    this.hora = 23;
                }
            }
        }
    }
    public void addReloj(Reloj reloj){
        this.hora = reloj.hora;
        this.minuto = reloj.minuto;
        this.segundo = reloj.segundo;
    }
    public Reloj restaReloj(Reloj reloj) {
        int i = relojSegundos(new Reloj(this.hora, this.minuto, this.segundo)) - relojSegundos(reloj);
        if (i >= 0) {
            return new Reloj(i);
        } else {
            return new Reloj(i * -1);
        }
    }
    public int relojSegundos(Reloj reloj) {
        return reloj.segundo + (reloj.minuto * 60) + (reloj.hora*60*60);
    }
    private void relojHoras(int segundo) {
        int minuto = 0, hora = 0;
        this.hora = hora;
        this.minuto = minuto;
        if (segundo > 59) {
            minuto = segundo / 60;
            this.segundo = segundo % 60;
            this.minuto = minuto;
            if (this.minuto > 59) {
                hora = minuto / 60;
                this.minuto = minuto % 60;
                this.hora = hora;
                if (hora > 23) {
                    hora = hora % 24;
                    this.hora = hora;
                }
            }
        } else {
            this.segundo = segundo;
        }
    }


    @Override
    public String toString() {
        String hora = String.valueOf(this.hora);
        String minuto = String.valueOf(this.minuto);
        String segundo = String.valueOf(this.segundo);

        if (this.hora < 10) {;
            hora = "0" + hora;
        }
        if (this.minuto < 10) {
            minuto = "0" + minuto;
        }
        if (this.segundo < 10) {
            segundo = "0" + segundo;
        }
        return "[" + hora + ":" + minuto + ":" + segundo + "]";
    }
}
