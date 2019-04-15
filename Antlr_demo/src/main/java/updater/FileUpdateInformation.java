package updater;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUpdateInformation implements Runnable {

    @Override
    public void run() {
        System.out.println(this.mdFile);

    }

    public File getFile() {
        return file;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public TimeUnit getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeUnit timeType) {
        this.timeType = timeType;
    }

    public double getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(double updateTime) {
        this.updateTime = updateTime;
    }

    enum UpdateType {
        append, replace
    }

    private File file;
    private File mdFile;
    private double updateTime;
    private TimeUnit timeType;
    private UpdateType updateType;

    public FileUpdateInformation(File mdFile, double updateTime, TimeUnit timeType, String updateType) {
        this.mdFile = mdFile;
        this.updateTime = updateTime;
        this.timeType = timeType;
        switch(updateType) {
            case "append":
                this.updateType = UpdateType.append;
                break;
            case "replace":
                this.updateType = UpdateType.replace;
                break;
            default:
                throw new RuntimeException();
        }
    }

}
