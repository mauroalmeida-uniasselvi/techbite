package techbite.entity;

import java.io.*;
import java.util.*;

public interface Storage {
    <T extends techbite.entity.StorageID> void create(String fileName, Class<T> type, T entity) throws IOException;

    <T extends techbite.entity.StorageID> Optional<T> getById(String fileName, Class<T> type, String id) throws IOException;

    <T extends techbite.entity.StorageID> List<T> listAll(String fileName, Class<T> type) throws IOException;

    <T extends techbite.entity.StorageID> T update(String fileName, Class<T> type, T entity) throws IOException;

    <T extends techbite.entity.StorageID> boolean delete(String fileName, Class<T> type, String id) throws IOException;
}
