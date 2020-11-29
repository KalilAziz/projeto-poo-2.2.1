/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;

/**
 *
 * @author kalil
 */
public class DaoMedico {
    ConexaoBD conex = new ConexaoBD();
    BeansMedico mod = new BeansMedico();
    
    public void salvar(BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos (nome_medico,crm_medico,valor_medico) values (?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCrm());
            pst.setInt(3, mod.getValor());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso!!");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados!\nErro:" +ex);
        }
        
        
        conex.desconecta();
    }
    
    public void Editar(BeansMedico mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set nome_medico=?, crm_medico=?, valor_medico=? where cod_medico=?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCrm());
            pst.setInt(3, mod.getValor());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com seucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração de dados \nErro:" +ex);
        }
        
        conex.desconecta();
    }
    
    public void Excluir(BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where cod_medico =?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com seucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados \nErro:" +ex);
        }
        
        
        conex.desconecta();
    }
}
