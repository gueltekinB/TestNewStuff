package business;

import java.util.List;

public class AndroidPhone {

    private String modelName;
    private int versionNumber;
    private Color color;
    private List<Buttons> buttons;

    public AndroidPhone(String modelName, int versionNumber, Color color, List<Buttons> buttons) {
        this.modelName = modelName;
        this.versionNumber = versionNumber;
        this.color = color;
        this.buttons = buttons;
    }

    public String getModelName() {
        return modelName;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public Color getColor() {
        return color;
    }

    public List<Buttons> getButtons() {
        return buttons;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setButtons(List<Buttons> buttons) {
        this.buttons = buttons;
    }
}
