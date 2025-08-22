public class Message {

    public static String buildMessage(CommandType commandType) {
        return buildMessage(commandType, null);
    }

    public static String buildMessage(CommandType commandType, String additionalText) {
        switch (commandType) {
            case START:
                return "🚀 Welcome to the bot!\n\n" +
                        "I can help you with various tasks. " +
                        "Use /help to see available commands.";

            case HELP:
                return "📖 Available Commands:\n\n" +
                        "/start - Start the bot\n" +
                        "/help - Show this help message\n\n" +
                        "Just send me any message and I'll echo it back!";

            case ECHO:
                return "Hi, that's not one of our commands,\n use the drop down to start, " +
                        "or click \"Open\" to use Ikizen";
            case ERROR:
                return "❌ Sorry, I didn't understand that command.\n" +
                        "Use /help to see available commands.";

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