package com.thykkannotech;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstacionamentoGUI extends JFrame {
    private JTextField txtMarca, txtPlaca, txtCor, txtHoraEntrada, txtHoraSaida;
    private JButton btnAdicionar, btnListar, btnAtualizar, btnExcluir;
    private JTextArea txtRelatorio;

    private CarroDAO carroDAO;

    public EstacionamentoGUI(Connection connection) {
        carroDAO = new CarroDAO(connection);
        setTitle("Controle de Estacionamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Campos de texto e botões
        txtMarca = new JTextField(10);
        txtPlaca = new JTextField(10);
        txtCor = new JTextField(10);
        txtHoraEntrada = new JTextField(10);
        txtHoraSaida = new JTextField(10);

        btnAdicionar = new JButton("Adicionar");
        btnListar = new JButton("Listar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Excluir");

        txtRelatorio = new JTextArea();
        txtRelatorio.setEditable(false);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Marca:"));
        panel.add(txtMarca);
        panel.add(new JLabel("Placa:"));
        panel.add(txtPlaca);
        panel.add(new JLabel("Cor:"));
        panel.add(txtCor);
        panel.add(new JLabel("Hora Entrada:"));
        panel.add(txtHoraEntrada);
        panel.add(new JLabel("Hora Saída:"));
        panel.add(txtHoraSaida);
        panel.add(btnAdicionar);
        panel.add(btnListar);
        panel.add(btnAtualizar);
        panel.add(btnExcluir);
        panel.add(new JScrollPane(txtRelatorio));

        setContentPane(panel);

        // Ações dos botões
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro carro = new Carro(txtMarca.getText(), txtPlaca.getText(), txtCor.getText(),
                            Integer.parseInt(txtHoraEntrada.getText()), Integer.parseInt(txtHoraSaida.getText()));
                    carroDAO.adicionarCarro(carro);
                    JOptionPane.showMessageDialog(null, "Carro adicionado com sucesso!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar carro.");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Carro> carros = carroDAO.listarCarros();
                    txtRelatorio.setText("");
                    for (Carro carro : carros) {
                        txtRelatorio.append(carro.getMarca() + " - " + carro.getPlaca() + " - " + carro.getCor() +
                                " - Entrada: " + carro.getHoraEntrada() + " - Saída: " + carro.getHoraSaida() + "\n");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao listar carros.");
                }
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Carro carro = new Carro(txtMarca.getText(), txtPlaca.getText(), txtCor.getText(),
                            Integer.parseInt(txtHoraEntrada.getText()), Integer.parseInt(txtHoraSaida.getText()));
                    carroDAO.atualizarCarro(carro);
                    JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar carro.");
                }
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carroDAO.excluirCarro(txtPlaca.getText());
                    JOptionPane.showMessageDialog(null, "Carro excluído com sucesso!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao excluir carro.");
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            Connection connection = ConexaoBD.conectar();
            EstacionamentoGUI gui = new EstacionamentoGUI(connection);
            gui.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
        }
    }
}
