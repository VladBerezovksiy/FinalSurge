package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtherCalcModel {

    @Builder.Default
    String distance = "12";
    @Builder.Default
    String measure = "Kilometers";
    @Builder.Default
    String hours = "3";
    @Builder.Default
    String minutes = "59";
    @Builder.Default
    String seconds = "40";

}
