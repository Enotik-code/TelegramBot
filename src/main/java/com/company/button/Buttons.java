package com.company.button;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Buttons {

    public synchronized void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardHelp = new KeyboardRow();
        keyboardHelp.add(new KeyboardButton("Еще вопрос"));
        KeyboardRow keyboardInfo = new KeyboardRow();
        keyboardInfo.add(new KeyboardButton("Назад"));
        keyboard.add(keyboardHelp);
        keyboard.add(keyboardInfo);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void setAnswer(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardQuestion = new KeyboardRow();
        keyboardQuestion.add(new KeyboardButton("Ответ"));
        KeyboardRow keyboardStart = new KeyboardRow();
        keyboardStart.add(new KeyboardButton("Назад"));
        keyboard.add(keyboardQuestion);
        keyboard.add(keyboardStart);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void setLevel(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardJunior = new KeyboardRow();
        keyboardJunior.add(new KeyboardButton("Junior"));
        KeyboardRow keyboardMiddle = new KeyboardRow();
        keyboardMiddle.add(new KeyboardButton("Middle"));
        KeyboardRow keyboardSenior = new KeyboardRow();
        keyboardSenior.add(new KeyboardButton("Senior"));
        KeyboardRow keyboardStart = new KeyboardRow();
        keyboardSenior.add(new KeyboardButton("Назад"));
        keyboard.add(keyboardJunior);
        keyboard.add(keyboardMiddle);
        keyboard.add(keyboardSenior);
        keyboard.add(keyboardStart);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void setMain(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardJunior = new KeyboardRow();
        keyboardJunior.add(new KeyboardButton("Вопросы"));
        KeyboardRow keyboardMiddle = new KeyboardRow();
        keyboardMiddle.add(new KeyboardButton("Уровни"));
        KeyboardRow keyboardThemes = new KeyboardRow();
        keyboardThemes.add(new KeyboardButton("Темы"));
        KeyboardRow keyboardCheat = new KeyboardRow();
        keyboardCheat.add(new KeyboardButton("Шпаргалка"));
        KeyboardRow keyboardSenior = new KeyboardRow();
        keyboardSenior.add(new KeyboardButton("Помощь"));
        KeyboardRow keyboardStart = new KeyboardRow();
        keyboardSenior.add(new KeyboardButton("Информация"));
        keyboard.add(keyboardJunior);
        keyboard.add(keyboardMiddle);
        keyboard.add(keyboardThemes);
        keyboard.add(keyboardCheat);
        keyboard.add(keyboardSenior);
        keyboard.add(keyboardStart);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void setButtonBack(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardBack = new KeyboardRow();
        keyboardBack.add(new KeyboardButton("Назад"));
        keyboard.add(keyboardBack);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void setButtonForCheatSheet(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardJava8 = new KeyboardRow();
        keyboardJava8.add(new KeyboardButton("Java 8"));
        KeyboardRow keyboardJavaCollections = new KeyboardRow();
        keyboardJavaCollections.add(new KeyboardButton("Java Collections"));
        KeyboardRow keyboardMaven = new KeyboardRow();
        keyboardMaven.add(new KeyboardButton("Maven"));
        KeyboardRow keyboardGit = new KeyboardRow();
        keyboardGit.add(new KeyboardButton("Git"));
        KeyboardRow keyboardSQL = new KeyboardRow();
        keyboardSQL.add(new KeyboardButton("SQL"));
        KeyboardRow keyboardRegex = new KeyboardRow();
        keyboardRegex.add(new KeyboardButton("Regex"));
        KeyboardRow keyboardBack = new KeyboardRow();
        keyboardRegex.add(new KeyboardButton("На старт"));

        keyboard.add(keyboardJava8);
        keyboard.add(keyboardJavaCollections);
        keyboard.add(keyboardMaven);
        keyboard.add(keyboardGit);
        keyboard.add(keyboardSQL);
        keyboard.add(keyboardRegex);
        keyboard.add(keyboardBack);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
