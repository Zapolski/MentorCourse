package by.zapolski.week07.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper=true, includeFieldNames=true)
public abstract class AbstractBattleShip extends AbstractShip{
    Integer firepower;
}
