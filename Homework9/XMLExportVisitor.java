package Homework9;

import Homework2.*;

public class XMLExportVisitor implements Visitor {

    private static String T = "\n";

    public XMLExportVisitor() {
    }

    public String export(Computer... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        sb.append("<computers>\n\t");
        T = "\n\t";
        for (Computer computer : args) {
            sb.append(computer.accept(this)).append(T);
        }
        T = "\n";
        sb.append("</computers>\n");
        return sb.toString();
    }

    public String export(Computer computer) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");

        sb.append(computer.accept(this)).append(T);

        return sb.toString();
    }

    @Override
    public String visitTablet(Tablet computer) {
        return "<tablet>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "   <display>" + computer.getDisplay() + "</display>" + T +
                "</tablet>";
    }

    @Override
    public String visitNotebook(Notebook computer) {
        return "<notebook>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "   <display>" + computer.getDisplay() + "</display>" + T +
                "   <keyboard>" + computer.getKeyboard() + "</keyboard>" + T +
                "</notebook>";
    }

    @Override
    public String visitNetbook(Netbook computer) {
        return "<netbook>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "   <display>" + computer.getDisplay() + "</display>" + T +
                "   <keyboard>" + computer.getKeyboard() + "</keyboard>" + T +
                "</netbook>";
    }

    @Override
    public String visitPersonalComputer(PersonalComputer computer) {
        return "<personalComputer>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "   <graphicsCard>" + computer.getGraphicsCard() + "</graphicsCard>" + T +
                "</personalComputer>";
    }

    @Override
    public String visitNettop(Nettop computer) {
        return "<nettop>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "</nettop>";
    }

    @Override
    public String visitMonoblock(Monoblock computer) {
        return "<monoblock>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "   <display>" + computer.getDisplay() + "</display>" + T +
                "</monoblock>";
    }

    @Override
    public String visitServer(Server computer) {
        return "<server>" + T +
                "   <marker>" + computer.getMarker() + "</marker>" + T +
                "   <model>" + computer.getModel() + "</model>" + T +
                "   <cpu>" + computer.getCPU() + "</cpu>" + T +
                "   <ram>" + computer.getRAM() + "</ram>" + T +
                "   <hdd>" + computer.getHDD() + "</hdd>" + T +
                "</server>";
    }
}
