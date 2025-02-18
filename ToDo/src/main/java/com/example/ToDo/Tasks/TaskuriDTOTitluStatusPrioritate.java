package com.example.ToDo.Tasks;

public class TaskuriDTOTitluStatusPrioritate {
    private static String titlu;
    private static String status;
    private static char prioritate;

    public static String getTitlu() {
        return titlu;
    }

    public static void setTitlu(String titlu) {
        TaskuriDTOTitluStatusPrioritate.titlu = titlu;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        TaskuriDTOTitluStatusPrioritate.status = status;
    }

    public static char getPrioritate() {
        return prioritate;
    }

    public static void setPrioritate(char prioritate) {
        TaskuriDTOTitluStatusPrioritate.prioritate = prioritate;
    }
}
