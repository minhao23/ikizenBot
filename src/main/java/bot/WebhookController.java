package bot;

import bot.Bot;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebhookController {

    private final Bot bot;

    public WebhookController(Bot bot) {
        this.bot = bot;
    }

    @PostMapping("/webhook")
    public Object onUpdate(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}