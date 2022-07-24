package ru.borisof.anekbot.service.bot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.borisof.anekbot.repo.AnekRepository;
import ru.borisof.anekbot.service.AnekService;
import ru.borisof.anekbot.service.bot.AbstractBotCommandHandler;

@Component
@RequiredArgsConstructor
public class GetAnekCommandHandler extends AbstractBotCommandHandler {

    private final AnekRepository anekRepository;

    @Override
    protected boolean shouldProcessEvent(final Update updateEvent) {
        return  updateEvent.getMessage() != null
            && updateEvent.getMessage().getText() != null
            && updateEvent.getMessage().getText().toLowerCase().equals("/anek");
    }

    @Override
    protected SendMessage processEvent(final Update updateEvent) {

        var anek = anekRepository.findRandomAnek();

        SendMessage message = new SendMessage();
        message.setChatId(updateEvent.getMessage().getChatId().toString());
        message.setText(anek.getContent());
        return message;
    }
}
