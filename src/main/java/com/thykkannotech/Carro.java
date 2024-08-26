package com.thykkannotech;

public class Carro {
    private String marca;
    private String placa;
    private String cor;
    private int horaEntrada;
    private int horaSaida;

    // Construtores
    public Carro() {
    }

    public Carro(String marca, String placa, String cor) {
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
    }

    public Carro(String marca, String placa, String cor, int horaEntrada, int horaSaida) {
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public Carro(String marca, String placa) {
        this.marca = marca;
        this.placa = placa;
    }

    public Carro(String placa, int horaEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(int horaSaida) {
        this.horaSaida = horaSaida;
    }
}
