package mls.server_property.model;

/**
 * Interface helps achieve Abstraction.
 * The interface "java.model.Storage" forces implemented class(es) to include two getter
 * methods and one setter method related to number and type of storages in the property.
 */
public interface Storage {
    public int howManyStorage();
    public void setStorage(String type, int nOfStorages);
    public String getStorageType();
}