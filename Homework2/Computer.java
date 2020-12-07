package Homework2;

import Homework3.*;

public interface Computer {
    String turnOn(int v) throws ComputerTurnOnException;

    String turnOff() throws ComputerTurnOffException;

    String connect(boolean wifi) throws ComputerConnectionError;
}


