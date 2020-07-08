package com.company.poll;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Polls {



    public synchronized void setPoll(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardYes = new KeyboardRow();
        keyboardYes.add(new KeyboardButton("Верно"));
        KeyboardRow keyboardNo = new KeyboardRow();
        keyboardNo.add(new KeyboardButton("Не верно"));

        keyboard.add(keyboardYes);
        keyboard.add(keyboardNo);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}
