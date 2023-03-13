package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;

public class DominioTest {
    @Test
    public void podeAdicionarCursosNosDevs() {
        Dev dev = configurarDev();

        Assertions.assertTrue(dev.getConteudosInscritos().size() > 0);
    }

    @Test
    public void podeConcluirCursos() {
        Dev dev = configurarDev();

        dev.progredir();

        Assertions.assertTrue(dev.getConteudosInscritos().isEmpty());
        Assertions.assertTrue(dev.getConteudosConcluidos().size() == 1);
    }

    Dev configurarDev() {
        Curso curso = new Curso();
        curso.setTitulo("Curso");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.adicionarConteudo(curso);

        Dev dev = new Dev();
        dev.setNome("Dev");
        dev.inscreverBootcamp(bootcamp);

        return dev;
    }
}
