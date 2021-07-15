/**
 * Interface helps achieve Abstraction.
 * The interface "LockerStorage" forces implemented class(es) to include one getter
 * method and one setter method related to number of locker storages in the property.
 */
public interface LockerStorage {
    public int howManyLockerStorage();
    public void setHowManyLockerStorage(int howManyLockerStorage);
}
