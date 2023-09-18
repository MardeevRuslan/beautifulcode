package org.example;

import com.fasterxml.jackson.core.util.RequestPayload;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;


public class MainClassTest {



    @Test
    public void testEmptyText() {
        BracketCheckerApplication.RequestPayload payload = new BracketCheckerApplication.RequestPayload("");
        BracketCheckerApplication bracketCheckerApplication = new BracketCheckerApplication();
        ResponseEntity<?> response = bracketCheckerApplication.checkBrackets(payload);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"isEmpty\": true}", response.getBody());

    }

    @Test
    public void testCorrectBrackets() {
        BracketCheckerApplication.RequestPayload payload = new BracketCheckerApplication.RequestPayload("\"Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, (как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, особенно когда мы достигли высшей точки и увидели прекрасный вид на долину (я почувствовал, что все усилия стоили того).\"");
        BracketCheckerApplication bracketCheckerApplication = new BracketCheckerApplication();
        ResponseEntity<?> response = bracketCheckerApplication.checkBrackets(payload);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"isCorrect\": true}", response.getBody());
    }

    @Test
    public void testIncorrectBrackets() {
        BracketCheckerApplication.RequestPayload payload = new BracketCheckerApplication.RequestPayload("((Я не пошёл в поход");
        BracketCheckerApplication bracketCheckerApplication = new BracketCheckerApplication();
        ResponseEntity<?> response = bracketCheckerApplication.checkBrackets(payload);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"isCorrect\": false}", response.getBody());
    }


}
