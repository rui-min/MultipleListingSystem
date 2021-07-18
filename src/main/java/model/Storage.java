package model;

/**
 * Interface helps achieve Abstraction.
 * The interface "model.LockerStorage" forces implemented class(es) to include one getter
 * method and one setter method related to number of locker storages in the property.
 */
public interface Storage {
    public int howManyStorage();
    public void setStorage(String type, int howManyLockerStorage);
    public String getStorageType();
}