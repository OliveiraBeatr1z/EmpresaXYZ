package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import br.com.beatrizoliveiralistagenerica.Lista;
import model.Cliente;

public class ModificacaoCadastroController {

    public void novoCadastro(int idadeMin, int idadeMax, Double limiteCredito) throws Exception {
        Lista listaClientes = new Lista();

        File arquivo = new File("C:\\TEMP");
        if (!arquivo.exists()) {
            throw new Exception("Arquivo cadastro.csv não encontrado.");
        }

        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;

        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(";");
            if (dados.length < 4) continue;

            Cliente c = new Cliente();
            c.setNome(dados[0]);
            c.setCpf(dados[1]);
            c.setIdade(Integer.parseInt(dados[2]));
            c.setLimiteCredito(Double.parseDouble(dados[3]));

            if (c.getIdade() >= idadeMin && c.getIdade() <= idadeMax && c.getLimiteCredito() > limiteCredito) {
                listaClientes.addLast(c);
            }
        }

        reader.close();

        String cadastro = "Idade" + idadeMin + "-" + idadeMax + "_limite" + limiteCredito + ".csv";
        novoArquivo(listaClientes, cadastro);
    }

    private void novoArquivo(Lista lista, String cadastro) throws Exception {
        File arquivo = new File("C:\\TEMP", cadastro);

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < lista.size(); i++) {
            Cliente c = (Cliente) lista.get(i);
            buffer.append(c.getNome()).append(";")
                  .append(c.getCpf()).append(";")
                  .append(c.getIdade()).append(";")
                  .append(c.getLimiteCredito()).append("\n");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
        writer.write(buffer.toString());
        writer.close();
    }
}
