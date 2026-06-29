package mobile.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainData {
    private String trainNumber;
    private String departureDate;
    private String departureTime;
    private String routeFrom;
    private String routeTo;
    private String carType;
    private String serviceClass;
    private int price;
    private int freeSeats;
    private String carrier;
    private String carriageNumber;
}
