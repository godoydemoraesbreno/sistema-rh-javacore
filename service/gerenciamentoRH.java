package service;

import model.funcionario;
import java.util.ArrayList;
import java.util.List;

public class gerenciamentoRH {

    private List<funcionario> listaFuncionarios = new ArrayList<>();

    public void cadastrar(funcionario f) {
        listaFuncionarios.add(f);
    }

    public boolean remover(int id) {
        return listaFuncionarios.removeIf(f -> f.getId() == id);
    }

    public void darAumento(int id, double porcentagem) {
        for (funcionario f : listaFuncionarios) {
            if (f.getId() == id) {
                double novoSalario = f.getSalario() * (1 + (porcentagem / 100));
                f.setSalario(novoSalario);
                return;
            }
        }
    }

    public List<funcionario> listarTodos() {
        return listaFuncionarios;
    }
}

