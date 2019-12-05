
package util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import view.DisplayMain;
import view.FrameBase;

public class ConexaoBD {

	Connection con = null;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/contatos?useSSL=false";
	private static String user = "root";
	private static String password = "Leaozinho1996";

	public ConexaoBD() {
		verificarBanco();
	}

	public static Connection getConexao() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException ex) {
			JOptionPane.showMessageDialog(null, "Banco não conectado! Favor verificar conexão!", "Atenção",JOptionPane.INFORMATION_MESSAGE);
			FrameBase.fecharJanela();
			throw new RuntimeException("Erro na Execução", ex);
		}
	}

	public static void fechaConexao(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void fechaConexao(Connection con, PreparedStatement stmt) {
		fechaConexao(con);

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
		fechaConexao(con, stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void verificarBanco() {
		if (ConexaoBD.getConexao() != null) {
			DisplayMain.lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconDbOk.png")));
			fechaConexao(con);
		} else {
			DisplayMain.lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconDbError.png")));
		}
	}

}
