package techbite.utils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Database {
    // CRUD operations for Identifiable entities stored in a JSON array file
    <T extends techbite.entity.Identifiable> T create(String fileName, Class<T> type, T entity) throws IOException;
    <T extends techbite.entity.Identifiable> Optional<T> getById(String fileName, Class<T> type, String id) throws IOException;
    <T extends techbite.entity.Identifiable> List<T> listAll(String fileName, Class<T> type) throws IOException;
    <T extends techbite.entity.Identifiable> T update(String fileName, Class<T> type, T entity) throws IOException;
    <T extends techbite.entity.Identifiable> boolean delete(String fileName, Class<T> type, String id) throws IOException;
}
