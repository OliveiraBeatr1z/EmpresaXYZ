package view;

import controller.ModificacaoCadastroController;

public class Principal {
    public static void main(String[] args) {
        ModificacaoCadastroController controller = new ModificacaoCadastroController();

        try {
            controller.novoCadastro(41, 60, 8000.00);
            controller.novoCadastro(31, 40, 5000.00);
            controller.novoCadastro(21, 30, 3000.00);

            System.out.println("Arquivos criados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
