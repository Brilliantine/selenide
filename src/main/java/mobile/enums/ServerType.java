package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ServerType {
    DEBUG("debug",Contour.MASTER, Branches.TEST_RELEASE),
    //ADAPTER("adapter",Contour.BRANCHES, Branches.ADAPTER),
    ADAPTER("adapter",Contour.MASTER, Branches.TEST_RELEASE),
    PROD("prod", null, null);

    private final String value;
    private final Contour autoContour;
    private final Branches autoBranch;

    /**
     * Преобразует строку в ServerType (без учета регистра и пробелов).
     * Если строка неизвестна или null - возвращает DEBUG.
     * Пример: "adapter" → ADAPTER, "PROD" → PROD, "unknown" → DEBUG
     */
    public static ServerType fromString(String value){
        if(value == null) return DEBUG;
        for (ServerType type : values()){
            if(type.value.equalsIgnoreCase(value.trim())){
                return type;
            }
        }
        return DEBUG;
    }
}
