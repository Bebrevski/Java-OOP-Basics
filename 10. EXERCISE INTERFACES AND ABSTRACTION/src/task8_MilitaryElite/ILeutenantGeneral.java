package task8_MilitaryElite;

import java.util.Set;

public interface ILeutenantGeneral extends ISoldier, IPrivate{

    Set<Private> getPrivates();
}
