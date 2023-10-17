package Students;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DataBase {

    ObjectWithData saveNewEntity(DbCollectionNames collectionName, ObjectWithData value);

    ObjectWithData getEntity(DbCollectionNames collectionName, UUID id);

    List<ObjectWithData> getAllEntities(DbCollectionNames collectionName);

    ObjectWithData updateEntity(DbCollectionNames collectionName, ObjectWithData value);

    List<ObjectWithData> updateMany(DbCollectionNames collectionName, List<ObjectWithData> values);

    boolean isEntityExists(DbCollectionNames collectionName, UUID id);

    void deleteEntity(DbCollectionNames collectionName, ObjectWithData value);

    Group getGroupByName(String name);

    //    method for look at state of DB, only for debug
    Map<DbCollectionNames, Map<UUID, ObjectWithData>> getData();

}
