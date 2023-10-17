package Students;

import java.util.*;

import static Students.DbCollectionNames.GROUPS_DB_COLLECTION;

public class DataBaseImpl implements DataBase {

    public static DataBaseImpl INSTANCE;

    public DataBaseImpl() {
        loadDataCollections();
    }

    public static DataBaseImpl getInstance() {
        DataBaseImpl localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (DataBaseImpl.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    localInstance = INSTANCE = new DataBaseImpl();
                }
            }
        }
        return localInstance;
    }

    private final Map<DbCollectionNames, Map<UUID, ObjectWithData>> data = new HashMap<>();

    @Override
    public ObjectWithData saveNewEntity(DbCollectionNames collectionName, ObjectWithData value) {
        if (data.get(collectionName).containsKey(value.getId())) {
            throw new RuntimeException(String.format("Value by key '%s' already exists.", value.getId()));
        }
        data.get(collectionName).put(value.getId(), value);
        return data.get(collectionName).get(value.getId());
    }

    @Override
    public ObjectWithData getEntity(DbCollectionNames collectionName, UUID id) {
        ObjectWithData object = data.get(collectionName).get(id);
        if (object == null) {
            System.out.printf("Value by key '%s' does not exists.", id);
        }
        return object;
    }

    @Override
    public List<ObjectWithData> getAllEntities(DbCollectionNames collectionName) {
        return new ArrayList<>(data.get(collectionName).values());
    }

    @Override
    public ObjectWithData updateEntity(DbCollectionNames collectionName, ObjectWithData value) {
        ObjectWithData object = data.get(collectionName).get(value.getId());
        if (object == null) {
            System.out.printf("Value by key '%s' does not exists.", value.getId());
        }
        data.get(collectionName).put(value.getId(), value);
        return data.get(collectionName).get(value.getId());
    }

    public List<ObjectWithData> updateMany(DbCollectionNames collectionName, List<ObjectWithData> values) {
        for (ObjectWithData value : values) {
            updateEntity(collectionName, value);
        }
        return values;
    }

    @Override
    public boolean isEntityExists(DbCollectionNames collectionName, UUID id) {
        return data.get(collectionName).containsKey(id);
    }

    @Override
    public void deleteEntity(DbCollectionNames collectionName, ObjectWithData value) {
        data.get(collectionName).remove(value.getId());
    }

    @Override
    public Group getGroupByName(String name) {
        return (Group) getAllEntities(GROUPS_DB_COLLECTION).stream()
                .filter(group -> ((Group) group).getGroupName().equals(name))
                .findFirst()
                .get();
    }

    @Override
    public Map<DbCollectionNames, Map<UUID, ObjectWithData>> getData() {
        return data;
    }

    private void loadDataCollections() {
        data.put(DbCollectionNames.STUDENTS_DB_COLLECTION, new HashMap<>());
        data.put(DbCollectionNames.GROUPS_DB_COLLECTION, new HashMap<>());
        data.put(DbCollectionNames.TASKS_DB_COLLECTION, new HashMap<>());
    }

}
