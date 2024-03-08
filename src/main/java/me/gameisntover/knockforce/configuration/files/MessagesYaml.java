package me.gameisntover.knockforce.configuration.files;

import me.gameisntover.knockforce.configuration.YamlConfiguration;

public class MessagesYaml extends YamlConfiguration {
    public MessagesYaml() {
        super("messages.yml");
    }

    public String getPrefix() {
        return this.getString("general.prefix");
    }
}
