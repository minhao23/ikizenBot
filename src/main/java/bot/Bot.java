package bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class Bot extends TelegramWebhookBot {

    @Override
    public String getBotUsername() {
        return "ikizenBot";
    }

    @Override
    public String getBotToken() {
        return "7727848236:AAGCUgowWrClJS3LDXoaYaSQ4aH1kh1Lhr8";
    }

    @Override
    public String getBotPath() {
        // This is part of your webhook URL → https://yourdomain.onrender.com/webhook
        return "webhook";
    }

    @Override
    public SendMessage onWebhookUpdateReceived(Update update) {
        String reply = Parser.reply(update);
        Long user = Parser.getID(update);

        return SendMessage.builder()
                .chatId(user.toString())
                .text(reply)
                .build();
    }
}