package ru.borisof.anekbot.service.bot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.borisof.anekbot.service.bot.AbstractBotCommandHandler;

@Component
public class StartCommandHandler extends AbstractBotCommandHandler {

    @Override
    protected boolean shouldProcessEvent(final Update updateEvent) {
        return  updateEvent.getMessage() != null
            && updateEvent.getMessage().getText() != null
            && updateEvent.getMessage().getText().toLowerCase().equals("/start");
    }

    @Override
    protected SendMessage processEvent(final Update updateEvent) {
        SendMessage message = new SendMessage();
        message.setChatId(updateEvent.getMessage().getChatId().toString());
        message.setText("Ну здарова, ебаный рот. Я буду травить тебе анекдоты, пока ты не сдохнешь от кринжа. Чтобы "
                        + "получить аник, пиши команду /anek");
        return message;
    }
}
