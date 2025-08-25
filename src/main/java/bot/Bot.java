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
        return System.getenv("BOT_TOKEN");
    }

    @Override
    public String getBotPath() {
        // This is part of your webhook URL → https://yourdomain.onrender.com/webhook
        return "webhook";
    }
    public static String escapeMarkdownV2(String text) {
        return text.replaceAll("([_\\*\\[\\]\\(\\)~`>#+\\-=|{}.!])", "\\\\$1");
    }

    @Override
    public SendMessage onWebhookUpdateReceived(Update update) {
        String reply = Parser.reply(update);
        Long user = Parser.getID(update);

        SendMessage message = SendMessage.builder()
                .chatId(user.toString())
                .text(reply)
                .build();
        message.setParseMode("MarkdownV2");
        message.setText(escapeMarkdownV2(reply));
        return message;
    }
}