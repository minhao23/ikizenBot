package bot;

import org.telegram.telegrambots.meta.api.objects.Update;

public class Parser {

    public Parser() {
    }

    public CommandType parse(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return CommandType.ERROR;
        }

        var msg = update.getMessage();
        var user = msg.getFrom();
        String text = getMessageText(update);

        System.out.println(user.getFirstName() + " wrote: " + text);
        System.out.println(update);

        // Handle commands
        if (text.equals("/start")) {
            return CommandType.START;
        } else if (text.equals("/help")) {
            return CommandType.HELP;
        } else if (text.startsWith("/")) {
            return CommandType.ERROR;
        } else {
            return CommandType.ECHO;
        }
    }

    // Optional: Get additional context from the message
    public String getMessageText(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getText();
        }
        return "";
    }

    // Optional: Get user info
    public String getUserInfo(Update update) {
        if (update.hasMessage()) {
            var user = update.getMessage().getFrom();
            return user.getFirstName() + " " + user.getLastName();
        }
        return "Unknown User";
    }

    public static String reply(Update update){
        Parser p = new Parser();
        CommandType c = p.parse(update);
        String reply = Message.buildMessage(c);
        return reply;
    }

    public static Long getID(Update update){
        var msg = update.getMessage();
        var user= msg.getFrom();
        return user.getId();
    }

}
