package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutModel {

    @Builder.Default
    String activity = "Swim";
    @Builder.Default
    String optionActivity = "Drills";
    @Builder.Default
    String date = "4/22/2022";
    @Builder.Default
    String name = "Run-Bike";
    @Builder.Default
    String distance = "100";
    @Builder.Default
    String perceivedEffort = "Hard";
    @Builder.Default
    String howIFeel = "Poor";
}
