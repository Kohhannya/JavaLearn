package Homework2;

abstract class Component {

    public String printComponent() {
        return getClass().getSimpleName() + " " + toString();
    }
}

class CPU extends Component {
    private String name;
    private int numberOfCores;
    private String frequency;

    public CPU(String name, int numberOfCores, String frequency) {
        this.name = name;
        this.numberOfCores = numberOfCores;
        this.frequency = frequency;
    }

    public String toString() {
        return name + " with " + numberOfCores + " cores and " + frequency; //без пробела в конце
    }
}

class RAM extends Component {
    String memory;
    String type;
    String frequency;

    public RAM(String memory, String type, String frequency) {
        this.memory = memory;
        this.type = type;
        this.frequency = frequency;
    }

    public String toString() {
        return memory + ", " + type + ", " + frequency;
    }
}

class HDD extends Component {
    String type;
    String memory;

    public HDD(String type, String memory) {
        this.type = type;
        this.memory = memory;
    }

    public String toString() {
        return type + " " + memory;
    }
}

class Display extends Component {
    private String diagonal;
    private String screenResolution;
    private boolean LEDlights;
    private String matrixType;

    public Display(String diagonal, String screenResolution, boolean LEDlights, String matrixType) {
        this.diagonal = diagonal;
        this.screenResolution = screenResolution;
        this.LEDlights = LEDlights;
        this.matrixType = matrixType;
    }

    public String toString() {
        return diagonal + " diagonal, " + screenResolution + " screenResolution, LED lights: " + LEDlights + ", matrixType: " + matrixType;
    }
}

class Keyboard extends Component {
    String keyboardColor;
    boolean keysBacklighting;
    boolean FingerprintScanner;


    public Keyboard(String keyboardColor, boolean keysBacklighting, boolean FingerprintScanner) {
        this.keyboardColor = keyboardColor;
        this.keysBacklighting = keysBacklighting;
        this.FingerprintScanner = FingerprintScanner;
    }

    public String toString() {
        return keyboardColor + ", keys Backlighting: " + keysBacklighting + ", Fingerprint Scanner: " + FingerprintScanner;
    }
}

class GraphicsCard extends Component {
    String type;
    String memory;
    String frequancy;

    public GraphicsCard(String type, String memory, String frequancy) {
        this.type = type;
        this.memory = memory;
        this.frequancy = frequancy;
    }

    public String toString() {
        return memory + ", " + type + ", " + frequancy;
    }
}