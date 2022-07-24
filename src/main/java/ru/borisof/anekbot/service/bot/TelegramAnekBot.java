package ru.borisof.anekbot.service.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TelegramAnekBot extends TelegramLongPollingBot {

    private final Collection<AbstractBotCommandHandler> commandHandlers;

    @Value("${telegram.bot-name}")
    private String telegramBotName;

    @Value("${telegram.bot-token}")
    private String telegramBotToken;


    @Override
    public String getBotUsername() {
        return telegramBotName;
    }

    @Override
    public String getBotToken() {
        return telegramBotToken;
    }


    @Override
    public void onUpdateReceived(final Update update) {

        commandHandlers.stream()
                .filter(el -> el.shouldProcessEvent(update))
                .map(el -> el.processEvent(update))
                .forEach(el -> {
                    try {
                        execute(el);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
