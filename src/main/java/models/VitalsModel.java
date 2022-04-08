package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VitalsModel {

    @Builder.Default
    String date = "4/5/2022";
    @Builder.Default
    String steps = "10500";
    @Builder.Default
    String colories = "555";
    @Builder.Default
    String weight = "57";
    @Builder.Default
    String weightDimension = "kg";
    @Builder.Default
    String sleepAmount = "Not Enough";
    @Builder.Default
    String endDate = "4/12/2022";
    @Builder.Default
    String wrongDate = "13/13/2022";
    @Builder.Default
    String emptyDate = "";
    @Builder.Default
    String negativeSteps = "-10500";
    @Builder.Default
    String notNumberSteps = "two";
}