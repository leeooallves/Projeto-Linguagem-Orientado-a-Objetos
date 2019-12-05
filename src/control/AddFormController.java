package control;

import model.Contato;
import util.DAO;
import view.AddForm;
import view.DisplayMain;
import view.FrameBase;
import view.PanelBase;

public class AddFormController {
	private static Contato contato;
	static int id;

	public static void salvar(Contato contato) {
		DAO contDao = new DAO();
		contDao.editar(contato);
		limpaCampo();
		FrameBase.showPanels(PanelBase.DISPLAY_MAIN, contato);
		DisplayMainController.visualizar();
	}

	public static void salvar() {
		// Contato contato = editar();
		DAO contDao = new DAO();
		// if (contato == null) {

		String nome = (AddForm.jtNome.getText());
		System.out.println("nome: " + nome);
		int telefone = (Integer.parseInt(AddForm.jtTel.getText()));
		String ende = (AddForm.jtEnd.getText());
		int num = (Integer.parseInt(AddForm.jtNum.getText()));
		String bairro = (AddForm.jtBairro.getText());
		String cidade = (AddForm.jtCidade.getText());
		String uf = (AddForm.jtUf.getText());
		String caoAdotado = (AddForm.jtCaoAdotado.getText());

		Contato contato = new Contato(nome, telefone, ende, num, bairro, cidade, uf, caoAdotado);
		if (DAO.seIdExiste(contato)==true) {
			contDao.editar(contato);
		} else {
			contDao.adicionaContato(contato);
		}

		limpaCampo();
		FrameBase.showPanels(PanelBase.DISPLAY_MAIN, null);
		DisplayMainController.visualizar();
		// } else {
		// contato.setNome(AddForm.jtNome.getText());
		// contato.setTelefone(Integer.parseInt(AddForm.jtTel.getText()));
		// contato.setEnde(AddForm.jtEnd.getText());
		// contato.setNum(Integer.parseInt(AddForm.jtNum.getText()));
		// contato.setBairro(AddForm.jtBairro.getText());
		// contato.setCidade(AddForm.jtCidade.getText());
		// contato.setUf(AddForm.jtUf.getText());
		// contato.setCaoAdotado(AddForm.jtCaoAdotado.getText());
		// contDao.editar(contato);
		// limpaCampo();
		// FrameBase.showPanels(PanelBase.DISPLAY_MAIN, contato);
		// DisplayMainController.visualizar();
		// }
	}

	public static void limpaCampo() {
		AddForm.jtNome.setText("");
		AddForm.jtTel.setText("");
		AddForm.jtEnd.setText("");
		AddForm.jtNum.setText("");
		AddForm.jtBairro.setText("");
		AddForm.jtCidade.setText("");
		AddForm.jtUf.setText("");
		AddForm.jtCaoAdotado.setText("");
	}

	public static void editar() {
		int index = DisplayMain.tabela.getSelectedRow();
		if (index != -1) {
			System.out.println("entrouu!!!");
			int id = ((int) DisplayMain.tabela.getValueAt(index, 0));
			String nome = ((String) DisplayMain.tabela.getValueAt(index, 1));
			int telefone = ((int) DisplayMain.tabela.getValueAt(index, 2));
			String ende = ((String) DisplayMain.tabela.getValueAt(index, 3));
			int num = ((int) DisplayMain.tabela.getValueAt(index, 4));
			String bairro = ((String) DisplayMain.tabela.getValueAt(index, 5));
			String cidade = ((String) DisplayMain.tabela.getValueAt(index, 6));
			String uf = ((String) DisplayMain.tabela.getValueAt(index, 7));
			String caoAdotado = ((String) DisplayMain.tabela.getValueAt(index, 8));
			contato = new Contato(id, nome, telefone, ende, num, bairro, cidade, uf, caoAdotado);
			AddForm.jtNome.setText(contato.getNome());
			AddForm.jtTel.setText(Integer.toString(contato.getTelefone()));
			AddForm.jtEnd.setText(contato.getEnde());
			AddForm.jtNum.setText(Integer.toString(contato.getNum()));
			AddForm.jtBairro.setText(contato.getBairro());
			AddForm.jtCidade.setText(contato.getCidade());
			AddForm.jtUf.setText(contato.getUf());
			AddForm.jtCaoAdotado.setText(contato.getCaoAdotado());

			// return contato;
		}
		// return null;
	}
}
