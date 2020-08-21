package com.company;

import com.company.button.Buttons;
import com.company.crib.Crib;
import com.company.poll.Polls;
import com.company.questions.QuestionsServer;

import lombok.SneakyThrows;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.methods.send.SendSticker;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;


public class Bot extends TelegramLongPollingBot{
    QuestionsServer questionsServer = new QuestionsServer();
    Polls polls = new Polls();
    Crib crib = new Crib();

    @Override
    public String getBotUsername() {
        return "JavaGuruInterviewBot";
    }


    static int questionId = 0;
    static int levelId = 0;


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        if(txt.equals("На старт")|| txt.equals("/start")){
            sendMsg(msg, "Привет.\nMоя задача ускорить твой процесс обучения\nили" +
                    " помочь проверить твои знания.\nДавай начнем!");
        }
        if(txt.equals("Назад")){
            sendMsg(msg,  "Выбери то что тебя интересует");
        }
        if(txt.equals("Шпаргалка")){
            sendMsgForCheatSheet(msg, "");
        }
        if(txt.equals("Java 8")){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(msg.getChatId());
            sendPhoto.setNewPhoto(new File(crib.getCribPath(1)));
            sendPhoto(sendPhoto);
            sendMsgAndButtonBack(msg, crib.getCribDescription(1));
        }
        if(txt.equals("Java Collections")){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(msg.getChatId());
            sendPhoto.setNewPhoto(new File(crib.getCribPath(2)));
            sendPhoto(sendPhoto);
            sendMsgAndButtonBack(msg, crib.getCribDescription(2));
        }
        if(txt.equals("Maven")){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(msg.getChatId());
            sendPhoto.setNewPhoto(new File(crib.getCribPath(3)));
            sendPhoto(sendPhoto);
            sendMsgAndButtonBack(msg, crib.getCribDescription(3));
        }
        if(txt.equals("Git")){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(msg.getChatId());
            sendPhoto.setNewPhoto(new File(crib.getCribPath(4)));
            sendPhoto(sendPhoto);
            sendMsgAndButtonBack(msg, crib.getCribDescription(4));
        }
        if(txt.equals("SQL")){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(msg.getChatId());
            sendPhoto.setNewPhoto(new File(crib.getCribPath(5)));
            sendPhoto(sendPhoto);
            sendMsgAndButtonBack(msg, crib.getCribDescription(5));
        }
        if(txt.equals("Regex")){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(msg.getChatId());
            sendPhoto.setNewPhoto(new File(crib.getCribPath(6)));
            sendPhoto(sendPhoto);
            sendMsgAndButtonBack(msg, crib.getCribDescription(6));
        }
        if(txt.equals("Темы")){
            sendMsgAndButtonBack(msg, "Выбирай тему в которой хочешь почитать вопросы\n/oop\n/javacore.");
        }
        if(txt.equals("Помощь")){
            sendMsg(msg, "Для того чтобы получить вопросы к собеседованию\n       ---> нажми Вопросы\n" +
                    "Для того чтобы выбрать уровень вопросов\n       ---> нажми Уровни\n" +
                    "Для того чтобы выбрать темы вопросов\n       ---> нажми Темы\n" +
                    "Для того чтобы увидеть шпаргалки\n       ---> нажми Шпаргалка\n");
        }
        if(txt.equals("Информация")){
            sendMsg(msg, "Owner: Kupreichik Anton\n" +
                    "Version: 0.0.1.1 beta\n" +
                    "Release date: 06.06.2020\n\nCheat sheet added and questions updated");
        }
        if(txt.equals("/oop")){
            sendMsgAndButtonBack(msg,questionsServer.getListOfQuestion(1));
        }
        if(txt.equals("/javacore")){
            sendMsgAndButtonBack(msg,questionsServer.getListOfQuestion(2));
        }
        if(txt.equals("Вопросы") || txt.equals("Еще вопрос")){
            int newQuestion = (int)(Math.random() * 41) + 1;
            if(questionId != newQuestion) {
                questionId = newQuestion;
                sendMsgAndAnswer(msg, questionsServer.getQuestion(questionId));
            }
            else{
                questionId = (int)(Math.random() * 41) + 1;
                sendMsgAndAnswer(msg, questionsServer.getQuestion(questionId));}
        }
        if(txt.equals("Ответ")){
            sendMsgForNewQuestion(msg, questionsServer.getAnswer(questionId));
        }
        if(txt.equals("Уровни")) {
            sendMsgAndLevel(msg, "Выбери свой уровень");

        }
        if(txt.equals("Junior")){
            questionId = (int)(Math.random() * 41) + 1;
            levelId = 1;
            sendMsgAndAnswer(msg, questionsServer.getQuestionByLevel(levelId, questionId));
        }
        if(txt.equals("Middle")){
            levelId = 2;
            questionId = 14;
            sendMsgAndAnswer(msg,questionsServer.getQuestionByLevel(levelId, questionId));

        }
        if(txt.equals("Senior")){
            sendMsgAndAnswer(msg, "https://www.google.com/search?q=%D1%84%D0%BE%D1%82%D0%BE&sxsrf=ALeK" +
                    "k010qODD8xvehwcf5s-kko2m0o7xkQ:1591292291234&tbm=isch&source=iu&ictx=1&fir=DrdLFy_sJRxOUM%25" +
                    "3A%252CZXXDQexNXnQVDM%252C_&vet=1&usg=AI4_-kSephgf8BFHH6Y2FlmUDbMejFPEJw&sa=X&" +
                    "ved=2ahUKEwjuvoLe2ejpAhWEyaQKHQJDCR8Q9QEwB3oECAUQKg#imgrc=DrdLFy_sJRxOUM:" );
        }
    }

    @Override
    public String getBotToken() {
        return "1012890460:AAGhjqrATVTenNFXd4wzIZzgsnj0h-W3pZA";
    }
    Buttons buttons = new Buttons();

    private synchronized void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setParseMode("HTML");
        s.setText("<b>"+  text +"</b>");
        buttons.setMain(s);
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sendMsgForCheatSheet(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setParseMode("HTML");
        s.setText("<b>Выбери какая тема тебя интересует</b>"+ text);
        buttons.setButtonForCheatSheet(s);
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sendMsgForNewQuestion(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        buttons.setButtons(s);
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sendMsgAndLevel(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        buttons.setLevel(s);
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sendMsgAndAnswer(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setParseMode("HTML");
        s.setText("<b>"+  text +"</b>");
        buttons.setAnswer(s);
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sendMsgAndButtonBack(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId());
        s.setText(text);
        buttons.setButtonBack(s);
        try {
            execute(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}