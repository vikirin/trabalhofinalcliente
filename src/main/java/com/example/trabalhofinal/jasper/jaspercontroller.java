package com.example.trabalhofinal.jasper;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import javax.swing.*;
import com.example.trabalhofinal.dao.AuxilliargeradoDAO;
import com.example.trabalhofinal.model.auxiliargerado;

import java.util.List;

public class jaspercontroller {
    public void gerarRelatorio() throws JRException{
        AuxilliargeradoDAO auxilliargeradoDAO =new AuxilliargeradoDAO();
        List<auxiliargerado> auxiliargeradoList =auxilliargeradoDAO.findall();
        //Criação do PDF com o Jasper
        JasperReport relatorioAula10 =
                JasperCompileManager.compileReport(
                        "src/main/resources/notaFiscal.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(auxiliargeradoList));



        //SWING para mostrar a tela PDF
        JDialog tela = new JDialog( new JDialog(),
                "Relatorio Pessoas", true);
        tela.setSize(800, 600);
        JRViewer painel = new JRViewer(relatorio);
        tela.getContentPane().add(painel);
        tela.setVisible(true);

    }
}

