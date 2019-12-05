package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.Contato;

public class DAO {

	public void adicionaContato(Contato contato) {
		Connection con = ConexaoBD.getConexao();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO contato (nome,telefone,endereco,numero,bairro,cidade,uf,caract_caes) VALUES (?,?,?,?,?,?,?,?)");

			stmt.setString(1, contato.getNome());
			stmt.setInt(2, contato.getTelefone());
			stmt.setString(3, contato.getEnde());
			stmt.setInt(4, contato.getNum());
			stmt.setString(5, contato.getBairro());
			stmt.setString(6, contato.getCidade());
			stmt.setString(7, contato.getUf().toUpperCase());
			stmt.setString(8, contato.getCaoAdotado());

			// executa

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
			stmt.close();
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao salvar!");

		} finally {
			ConexaoBD.fechaConexao(con, stmt);
		}

	}

	public java.util.List<Contato> visualizar() {
		Connection con = ConexaoBD.getConexao();
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		java.util.List<Contato> contatos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM contato");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();

				contato.setId(rs.getInt("id_contato"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getInt("telefone"));
				contato.setEnde(rs.getString("endereco"));
				contato.setNum(rs.getInt("numero"));
				contato.setBairro(rs.getString("bairro"));
				contato.setCidade(rs.getString("cidade"));
				contato.setUf(rs.getString("uf"));
				contato.setCaoAdotado(rs.getString("caract_caes"));

				contatos.add(contato);
			}

		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			ConexaoBD.fechaConexao(con, stmt, rs);
		}
		return contatos;
	}

	public java.util.List<Contato> buscar(String nome) {
		Connection con = ConexaoBD.getConexao();
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;

		java.util.List<Contato> contatos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM contato WHERE nome LIKE ? ");
			stmt.setString(1, nome + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();

				contato.setId(rs.getInt("id_contato"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getInt("telefone"));
				contato.setEnde(rs.getString("endereco"));
				contato.setNum(rs.getInt("numero"));
				contato.setBairro(rs.getString("bairro"));
				contato.setCidade(rs.getString("cidade"));
				contato.setUf(rs.getString("uf"));
				contato.setCaoAdotado(rs.getString("caract_caes"));

				contatos.add(contato);
			}

		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			ConexaoBD.fechaConexao(con, stmt, rs);
		}
		return contatos;
	}

	public void editar(Contato contato) {
		Connection con = ConexaoBD.getConexao();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE contato SET nome=?, telefone=?,endereco=?,numero=?,bairro=?, cidade=?, uf=?, caract_caes=? WHERE id_contato=?");

			stmt.setString(1, contato.getNome());
			stmt.setInt(2, contato.getTelefone());
			stmt.setString(3, contato.getEnde());
			stmt.setInt(4, contato.getNum());
			stmt.setString(5, contato.getBairro());
			stmt.setString(6, contato.getCidade());
			stmt.setString(7, contato.getUf().toUpperCase());
			stmt.setString(8, contato.getCaoAdotado());
			stmt.setInt(9, contato.getId());
			// executa

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao atualizar!");

		} finally {
			ConexaoBD.fechaConexao(con, stmt);
		}

	}

	public void excluir(Contato contato) {
		Connection con = ConexaoBD.getConexao();
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM contato WHERE id_contato=?");
			stmt.setInt(1, contato.getId());
			// executa

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao excluir!");

		} finally {
			ConexaoBD.fechaConexao(con, stmt);
		}

	}

	@SuppressWarnings("finally")
	public  static boolean seIdExiste(Contato contato) {

		Connection con = ConexaoBD.getConexao();
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isId = false;
		try {
			stmt = con.prepareStatement("select * from contato WHERE id_contato=?");
			stmt.setInt(1, contato.getId());
			// executa

			
			rs = stmt.executeQuery();
			if (rs.next()) {
				isId = true;
			} else {
				isId = false;
			}

			
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(null, "Erro ao excluir!");

		} finally {
			
			ConexaoBD.fechaConexao(con, stmt);
			JOptionPane.showMessageDialog(null, " id verificado");
			return isId;
		}
	}

}
