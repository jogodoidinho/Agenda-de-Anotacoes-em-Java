package aplication;

import entities.Agenda;
import entities.utils.returnPost;

import java.sql.SQLException;
import java.time.LocalDate;

public class testes {
    public static void main(String[] args) throws SQLException {
        String name = "Davi";
        Agenda x = new Agenda(name);
        String title = "A infância";
        String conteudo = "Sem lei nem Rei, me vi arremessado\n" +
                "bem menino a um Planalto pedregoso.\n" +
                "Cambaleando, cego, ao Sol do Acaso,\n" +
                "vi o mundo rugir. Tigre maldoso.\n" +
                "\n" +
                "O cantar do Sertão, Rifle apontado,\n" +
                "vinha malhar seu Corpo furioso.\n" +
                "Era o Canto demente, sufocado,\n" +
                "rugido nos Caminhos sem repouso.\n" +
                "\n" +
                "E veio o Sonho: e foi despedaçado!\n" +
                "E veio o Sangue: o marco iluminado,\n" +
                "a luta extraviada e a minha grei!\n" +
                "\n" +
                "Tudo apontava o Sol! Fiquei embaixo,\n" +
                "na Cadeia que estive e em que me acho,\n" +
                "a Sonhar e a cantar, sem lei nem Rei!";
//        x.deleteNote(LocalDate.now());
//        x.addNote(title,conteudo,LocalDate.now());
//        for(returnPost y : x.showNote(LocalDate.now())){
//            System.out.println(y);
//        }
        for(returnPost y : x.showAllNotesofYear()){
            System.out.println(y);
        }
        x.closeConn();


    }
}
