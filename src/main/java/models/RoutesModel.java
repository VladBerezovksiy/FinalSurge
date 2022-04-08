package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoutesModel {

    @Builder.Default
    String name = "Test";
    @Builder.Default
    String activity = "Walk";
    @Builder.Default
    String distance = "101";

}
