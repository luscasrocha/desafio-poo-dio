import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = criarCurso("Curso Java", "Descrição curso Java", 8);
        Curso curso2 = criarCurso("Curso JS", "Descrição curso JS", 4);
        Mentoria mentoria = criarMentoria("Mentoria de Java", "Descrição mentoria Java", LocalDate.now());

        Bootcamp bootcamp = criarBootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer", curso1, curso2, mentoria);

        Dev devCamila = criarDev("Camila", bootcamp);
        exibirProgressoDev(devCamila);

        Dev devJoao = criarDev("João", bootcamp);
        exibirProgressoDev(devJoao);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static Mentoria criarMentoria(String titulo, String descricao, LocalDate data) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(data);
        return mentoria;
    }

    private static Bootcamp criarBootcamp(String nome, String descricao, Conteudo... conteudos) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);
        for (Conteudo conteudo : conteudos) {
            bootcamp.getConteudos().add(conteudo);
        }
        return bootcamp;
    }

    private static Dev criarDev(String nome, Bootcamp bootcamp) {
        Dev dev = new Dev();
        dev.setNome(nome);
        dev.inscreverBootcamp(bootcamp);
        return dev;
    }

    private static void exibirProgressoDev(Dev dev) {
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        dev.progredir();
        dev.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos " + dev.getNome() + ": " + dev.getConteudosConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());
    }
}