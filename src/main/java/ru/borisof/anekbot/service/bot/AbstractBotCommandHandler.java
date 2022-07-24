package ru.borisof.anekbot.service.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class AbstractBotCommandHandler {

    protected abstract boolean shouldProcessEvent(Update updateEvent);

    protected abstract SendMessage processEvent(Update updateEvent);


}
