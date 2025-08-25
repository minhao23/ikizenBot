package bot;

import bot.CommandType;

public class Message {

    public static String buildMessage(CommandType commandType) {
        return buildMessage(commandType, null);
    }

    public static String buildMessage(CommandType commandType, String additionalText) {
        switch (commandType) {
            case START:
                return "🚀 Welcome to the ikizen!\n\n" +
                        "To start the bot, click the Open button at the bottom left corner.\n" +
                        "I can help you with improving your productivity.\n"+
                        "Let's have a great day together!";

            case HELP:
                return "📖 Available Commands:\n\n" +
                        "/start - Start the bot\n" +
                        "/help - Show this help message\n"+
                        "/helptodo - Provides an explanation on how to use the todo list\n"+
                        "/helptimer - Provides an explanation on how to use the timer\n";

            case ECHO:
                return "Hi, that's not one of our commands,\n use the drop down to start, " +
                        "or click \"Open\" to use Ikizen";
            case ERROR:
                return "❌ Sorry, I didn't understand that command.\n" +
                        "Use /help to see available commands.";
            case HELPTIMER:
                return "⏰ This is the pomodoro timer.\n" +
                        "This technique aims to improve focus, productivity, " +
                        "and reduce burnout by working in shorter, " +
                        "more manageable blocks of time. " +
                        "To better optimise your usage of the pomodoro timer, " +
                        "take a short break after every working session, and a long break every once in a awhile!";
            case HELPTODO:
                return  "📋 This is the Todo List.\n" +
                        "Based on the Eisenhower Matrix, " +
                        "Ikizen will provide you with a clear way of dividing your tasks by priority and urgency";

            default:
                return "Something went wrong. Please try again.";
        }
    }

    // Optional: Custom message builder with user personalization
    public static String buildWelcomeMessage(String userName) {
        return "👋 Hello " + userName + "!\n\n" +
                "Welcome to Ikizen! " +
                "I'm here to assist you. Use /help to see what I can do.";
    }
}