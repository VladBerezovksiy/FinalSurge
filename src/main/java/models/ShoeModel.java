package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoeModel {

    @Builder.Default
    String name = "Test";
    @Builder.Default
    String model = "Lui";
    @Builder.Default
    String cost = "10";
    @Builder.Default
    String distance = "63";
    @Builder.Default
    String size = "2";

}
