package by.zapolski.week07.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class Transport extends AbstractShip{
    private String color;
    private Integer carryingCapacity;
}
