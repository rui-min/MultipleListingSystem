package model;

/**
 * Interface helps achieve Abstraction.
 * The interface "java.model.Storage" forces implemented class(es) to include one getter
 * method and one setter method related to number of locker storages in the property.
 */
public interface Storage {
    /**
     * Set the storage type and amounts.
     * @param type tyoe of the storages, e.g. Locker, Garage, Basement, etc.
     * @param howMany how many storages are there.
     */
    public void setStorage(String type, int howMany);

    /**
     * Get the number of storages in the calling object.
     * @return how many storages are there in the calling object.
     */
    public int howManyStorage();

    /**
     * Get the storage type.
     * @return a string indicating the type of storage.
     */
    public String getStorageType();
}