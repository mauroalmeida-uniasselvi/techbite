package techbite.utils;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JsonFile {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .findAndRegisterModules()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final Path baseDir;

    public JsonFile(Path baseDir) throws IOException {
        this.baseDir = baseDir;
        Files.createDirectories(baseDir);
    }

    public JsonFile() throws IOException {
        this(Paths.get("src", "main", "resources"));
    }

    public <T> List<T> loadList(Class<T> elementType, String fileName) throws IOException {
        Path file = baseDir.resolve(fileName);
        if (file.getParent() != null) {
            Files.createDirectories(file.getParent());
        }
        if (Files.notExists(file) || Files.size(file) == 0) {
            return new ArrayList<>();
        }
        CollectionType listType = MAPPER.getTypeFactory().constructCollectionType(List.class, elementType);
        List<T> result = MAPPER.readValue(file.toFile(), listType);
        return result == null ? new ArrayList<>() : new ArrayList<>(result);
    }

    public <T> void saveList(List<T> list, String fileName) throws IOException {
        Path file = baseDir.resolve(fileName);
        if (file.getParent() != null) {
            Files.createDirectories(file.getParent());
        }
        MAPPER.writeValue(file.toFile(), list);
    }
}
