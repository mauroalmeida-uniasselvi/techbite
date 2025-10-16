package techbite.entity;

import java.io.*;
import java.util.*;

public interface Database {
    <T extends techbite.entity.Identifiable> void create(String fileName, Class<T> type, T entity) throws IOException;

    <T extends techbite.entity.Identifiable> Optional<T> getById(String fileName, Class<T> type, String id) throws IOException;

    <T extends techbite.entity.Identifiable> List<T> listAll(String fileName, Class<T> type) throws IOException;

    <T extends techbite.entity.Identifiable> T update(String fileName, Class<T> type, T entity) throws IOException;

    <T extends techbite.entity.Identifiable> boolean delete(String fileName, Class<T> type, String id) throws IOException;
}
