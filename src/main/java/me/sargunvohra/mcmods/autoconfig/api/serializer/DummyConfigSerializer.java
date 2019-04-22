package me.sargunvohra.mcmods.autoconfig.api.serializer;

import me.sargunvohra.mcmods.autoconfig.api.ConfigData;
import me.sargunvohra.mcmods.autoconfig.api.ConfigSerializer;
import me.sargunvohra.mcmods.autoconfig.impl.Utils;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Constructor;

public class DummyConfigSerializer<T extends ConfigData> implements ConfigSerializer<T> {

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final String name;
    private final Class<T> configClass;

    public DummyConfigSerializer(String name, Class<T> configClass) {
        this.name = name;
        this.configClass = configClass;
    }

    @Override
    public void serialize(T config) {
    }

    @Override
    public T deserialize() {
        return createDefault();
    }

    @Override
    public T createDefault() {
        return Utils.constructUnsafely(configClass);
    }
}