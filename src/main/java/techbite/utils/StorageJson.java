package techbite.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class StorageJson implements techbite.entity.Storage {
    private final JsonFile jsonFile;

    public StorageJson() throws IOException {
        this(resolveBaseDir());
    }

    public StorageJson(Path baseDir) throws IOException {
        this.jsonFile = new JsonFile(baseDir);
    }

    private static Path resolveBaseDir() {
        String override = System.getenv("TECHBITE_DATA_DIR");
        if (override != null && !override.isBlank()) {
            return Paths.get(override);
        }
        return Paths.get("src", "main", "resources");
    }

    @Override
    public <T extends techbite.entity.StorageID> void create(String fileName, Class<T> type, T entity) throws IOException {
        List<T> all = new ArrayList<>(jsonFile.loadList(type, fileName));
        boolean replaced = false;
        for (int i = 0; i < all.size(); i++) {
            if (equalsId(all.get(i), entity.getId())) {
                all.set(i, entity);
                replaced = true;
                break;
            }
        }
        if (!replaced) all.add(entity);
        jsonFile.saveList(all, fileName);
    }

    @Override
    public <T extends techbite.entity.StorageID> Optional<T> getById(String fileName, Class<T> type, String id) throws IOException {
        return jsonFile.loadList(type, fileName).stream().filter(e -> equalsId(e, id)).findFirst();
    }

    @Override
    public <T extends techbite.entity.StorageID> List<T> listAll(String fileName, Class<T> type) throws IOException {
        return jsonFile.loadList(type, fileName);
    }

    @Override
    public <T extends techbite.entity.StorageID> T update(String fileName, Class<T> type, T entity) throws IOException {
        List<T> all = new ArrayList<>(jsonFile.loadList(type, fileName));
        boolean updated = false;
        for (int i = 0; i < all.size(); i++) {
            if (equalsId(all.get(i), entity.getId())) {
                all.set(i, entity);
                updated = true;
                break;
            }
        }
        if (!updated) {
            all.add(entity);
        }
        jsonFile.saveList(all, fileName);
        return entity;
    }

    @Override
    public <T extends techbite.entity.StorageID> boolean delete(String fileName, Class<T> type, String id) throws IOException {
        List<T> all = jsonFile.loadList(type, fileName);
        int before = all.size();
        List<T> remaining = all.stream().filter(e -> !equalsId(e, id)).collect(Collectors.toList());
        if (remaining.size() != before) {
            jsonFile.saveList(remaining, fileName);
            return true;
        }
        return false;
    }

    private boolean equalsId(techbite.entity.StorageID e, String id) {
        return e.getId() != null && e.getId().equals(id);
    }
}
