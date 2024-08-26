package com.thykkannotech;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private Connection connection;

    public CarroDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarCarro(Carro carro) throws SQLException {
        String sql = "INSERT INTO carros (marca, placa, cor, horaEntrada, horaSaida) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getPlaca());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getHoraEntrada());
            stmt.setInt(5, carro.getHoraSaida());
            stmt.executeUpdate();
        }
    }

    public List<Carro> listarCarros() throws SQLException {
        String sql = "SELECT * FROM carros";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            List<Carro> carros = new ArrayList<>();
            while (rs.next()) {
                Carro carro = new Carro(
                        rs.getString("marca"),
                        rs.getString("placa"),
                        rs.getString("cor"),
                        rs.getInt("horaEntrada"),
                        rs.getInt("horaSaida")
                );
                carros.add(carro);
            }
            return carros;
        }
    }

    public void atualizarCarro(Carro carro) throws SQLException {
        String sql = "UPDATE carros SET marca = ?, cor = ?, horaEntrada = ?, horaSaida = ? WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getCor());
            stmt.setInt(3, carro.getHoraEntrada());
            stmt.setInt(4, carro.getHoraSaida());
            stmt.setString(5, carro.getPlaca());
            stmt.executeUpdate();
        }
    }

    public void excluirCarro(String placa) throws SQLException {
        String sql = "DELETE FROM carros WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.executeUpdate();
        }
    }
}
