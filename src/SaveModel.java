public class SaveModel <T  extends Task> {
    Format format;
    String text;
    String path;
    T task;
    public SaveModel(T task) {
        this.task = task;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void save() {
        text = format.createString(task);
        Saver.saveFile(text, this.path);
    }
}