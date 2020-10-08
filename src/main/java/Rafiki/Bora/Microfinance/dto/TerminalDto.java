package Rafiki.Bora.Microfinance.dto;

public class TerminalDto {
    String modelType;
    String serialNumber;

    public TerminalDto(){ }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
