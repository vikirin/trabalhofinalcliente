package com.example.trabalhofinal.dao;
import com.example.trabalhofinal.LoginClienteController;
import com.example.trabalhofinal.config.connectionFactory;
import com.example.trabalhofinal.model.auxiliargerado;
import com.example.trabalhofinal.inter.iauxiliargeradoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuxilliargeradoDAO implements iauxiliargeradoDAO{
    long cli=LoginClienteController.getIdcliente();
    @Override
    public List<auxiliargerado> findall() {
        String query = "SElECT * FROM pre_pedidopizza,pre_pedidobebida " +
                "WHERE pre_pedidobebida.idcliente = " +cli+
                "&& pre_pedidopizza.idcliente = " +cli+
                ";";
        List<auxiliargerado> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                auxiliargerado auxiliargerado =new auxiliargerado();
                auxiliargerado.setTamanho(rs.getString("tamanho"));
                auxiliargerado.setSabor(rs.getString("sabor"));
                auxiliargerado.setValortotalp(rs.getFloat("valortotalp"));
                auxiliargerado.setId_pedido(rs.getLong("id_Pedido"));
                auxiliargerado.setIdPizza((rs.getLong("idPizza")));
                auxiliargerado.setIdCliente(rs.getLong("idcliente"));
                auxiliargerado.setNomebebida(rs.getString("nomebebida"));
                auxiliargerado.setValortotalb(rs.getFloat("valortotalb"));
                auxiliargerado.setQuntidade(rs.getLong("quntidade"));
                auxiliargerado.setIdpedido(rs.getLong("idpedido"));
                auxiliargerado.setIdBebida(rs.getLong("idbebida"));
                auxiliargerado.setIdcliente(rs.getLong("idcliente"));
                lista.add(auxiliargerado);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }
}
