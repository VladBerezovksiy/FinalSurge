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
    String weight_dimension = "kg";
    @Builder.Default
    String sleep_amount = "Enough";
    @Builder.Default
    String endDate = "4/12/2022";
}